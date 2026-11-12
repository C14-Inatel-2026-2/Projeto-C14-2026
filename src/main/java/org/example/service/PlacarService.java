package org.example.service;

import org.example.model.Filmes;
import org.example.model.Jogador;
import org.example.model.Partida;
import org.example.model.Rodada;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlacarService {

    public record ResultadoJogador(int id, String nome, int pontos) {}

    public record ResultadoPartida(
            int numeroPartida, List<ResultadoJogador> ranking
    ) {}

    private record PontuacaoJogador(
            String nome, Map<Integer, Integer> pontosPorRodada
    ) {
        int total() {
            return pontosPorRodada.values().stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }
    }

    private record DadosPartida(
            Partida partida, Map<Integer, PontuacaoJogador> jogadores
    ) {}

    private final Map<Integer, DadosPartida> partidas = new HashMap<>();

    public void iniciarPartida(Partida partida) {
        if (!partida.estaAtiva()) {
            throw new IllegalStateException("A partida precisa estar ativa");
        }

        List<Jogador> participantes = partida.getJogadores();

        if (participantes.isEmpty()) {
            throw new IllegalArgumentException("A partida precisa ter jogadores");
        }

        Map<Integer, PontuacaoJogador> jogadores = new HashMap<>();

        for (Jogador jogador : participantes) {
            var anterior = jogadores.putIfAbsent(
                    jogador.getId(),
                    new PontuacaoJogador(jogador.getNome(), new HashMap<>())
            );

            if (anterior != null) {
                throw new IllegalArgumentException("ID de jogador duplicado");
            }
        }

        var anterior = partidas.putIfAbsent(
                partida.getId(), new DadosPartida(partida, jogadores)
        );

        if (anterior != null) {
            throw new IllegalStateException("Partida já registrada no placar");
        }
    }

    public int registrarPalpite(
            Partida partida, int idJogador, Filmes filme, double palpite
    ) {
        if (!partida.estaAtiva()) {
            throw new IllegalStateException("A partida não está ativa");
        }

        DadosPartida dados = buscarPartida(partida.getId());

        if (dados.partida() != partida) {
            throw new IllegalArgumentException("Esta partida não foi registrada");
        }

        PontuacaoJogador jogador = dados.jogadores().get(idJogador);

        if (jogador == null) {
            throw new IllegalArgumentException("Jogador não participa desta partida");
        }

        // getRodadas() conta as rodadas já concluídas.
        int numeroRodada = partida.getRodadas() + 1;

        if (jogador.pontosPorRodada().containsKey(numeroRodada)) {
            throw new IllegalStateException("Jogador já pontuou nesta rodada");
        }

        if (!Double.isFinite(palpite)
                || BigDecimal.valueOf(palpite).stripTrailingZeros().scale() > 1) {
            throw new IllegalArgumentException("Use um palpite com até uma casa decimal");
        }

        Rodada rodada = new Rodada(numeroRodada, filme);
        rodada.fazerPalpite(palpite);
        rodada.calcularPontuacao();

        int pontos = (int) Math.round(rodada.getPontuacao());
        jogador.pontosPorRodada().put(numeroRodada, pontos);

        return pontos;
    }

    public ResultadoPartida rankingPartida(int numeroPartida) {
        var resultados = buscarPartida(numeroPartida).jogadores()
                .entrySet().stream()
                .map(item -> new ResultadoJogador(
                        item.getKey(),
                        item.getValue().nome(),
                        item.getValue().total()
                ))
                .toList();

        return new ResultadoPartida(numeroPartida, ordenar(resultados));
    }

    public List<ResultadoJogador> rankingGeral() {
        Map<Integer, ResultadoJogador> totais = new HashMap<>();

        for (int numero : partidas.keySet().stream().sorted().toList()) {
            for (ResultadoJogador jogador : rankingPartida(numero).ranking()) {
                totais.merge(jogador.id(), jogador, (anterior, atual) ->
                        new ResultadoJogador(
                                anterior.id(),
                                anterior.nome(),
                                anterior.pontos() + atual.pontos()
                        )
                );
            }
        }

        return ordenar(totais.values());
    }

    public List<ResultadoJogador> vencedores() {
        List<ResultadoJogador> ranking = rankingGeral();

        if (ranking.isEmpty()) {
            return List.of();
        }

        int maiorPontuacao = ranking.get(0).pontos();

        return ranking.stream()
                .takeWhile(jogador -> jogador.pontos() == maiorPontuacao)
                .toList();
    }

    private DadosPartida buscarPartida(int numeroPartida) {
        DadosPartida dados = partidas.get(numeroPartida);

        if (dados == null) {
            throw new IllegalArgumentException("Partida não registrada no placar");
        }

        return dados;
    }

    private List<ResultadoJogador> ordenar(Collection<ResultadoJogador> resultados) {
        return resultados.stream()
                .sorted(Comparator.comparingInt(ResultadoJogador::pontos).reversed()
                        .thenComparingInt(ResultadoJogador::id))
                .toList();
    }
}