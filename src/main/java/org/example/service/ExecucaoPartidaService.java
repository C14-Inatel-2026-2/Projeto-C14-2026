package org.example.service;

import org.example.model.Partida;
import org.example.model.Usuario;
import org.example.model.Rodada;
import org.example.model.Filmes;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Collections;

import java.util.List;

public class ExecucaoPartidaService {

    private final Partida partida;
    private final List<Usuario> jogadores;
    private int indiceJogadorAtual;
    private final JogoService jogoService = new JogoService();
    private final Map<Usuario, Double> palpitesRodada = new LinkedHashMap<>();
    private final Map<Usuario, Integer> pontuacoesJogadores = new LinkedHashMap<>();
    private Rodada rodadaAtual;
    private SorteioService sorteioService;
    private final PlacarService placar;

    public ExecucaoPartidaService(Partida partida) {
        this(partida, null);
    }

    public ExecucaoPartidaService(Partida partida, PlacarService placar) {
        if (partida == null) {
            throw new IllegalArgumentException("A partida não pode ser nula.");
        }

        this.jogadores = partida.getJogadores();

        if (jogadores.isEmpty()) {
            throw new IllegalArgumentException("A partida precisa ter jogadores.");
        }

        if (jogadores.size() != partida.getNumeroParticipantes()) {
            throw new IllegalStateException(
                    "A quantidade de jogadores cadastrados está incompleta."
            );
        }

        this.partida = partida;
        this.indiceJogadorAtual = 0;
        this.placar = placar;
    }

    public Usuario getJogadorAtual() {
        return jogadores.get(indiceJogadorAtual);
    }

    public int getNumeroJogadorAtual() {
        return indiceJogadorAtual + 1;
    }

    private boolean avancarJogador() {
        if (!partida.estaAtiva()) {
            throw new IllegalStateException(
                    "A partida não está ativa."
            );
        }

        if (indiceJogadorAtual < jogadores.size() - 1) {
            indiceJogadorAtual++;
            return true;
        }

        partida.avancarRodada();
        palpitesRodada.clear();
        rodadaAtual = null;

        if(partida.estaAtiva()){
            Collections.rotate(jogadores, 1);
        }

        indiceJogadorAtual = 0;
        return false;
    }


    public int registrarPalpite(Rodada rodada, double palpite) {
        if (!partida.estaAtiva()) {
            throw new IllegalStateException("A partida não está ativa.");
        }

        if (rodada == null) {
            throw new IllegalArgumentException("A rodada não pode ser nula.");
        }

        if (Double.isNaN(palpite) || Double.isInfinite(palpite)
                || palpite < 0 || palpite > 10) {
            throw new IllegalArgumentException(
                    "O palpite deve estar entre 0 e 10."
            );
        }

        if (sorteioService != null && rodadaAtual == null) {
            throw new IllegalStateException(
                    "É necessário preparar a rodada antes de registrar palpites."
            );
        }

        if (rodadaAtual == null) {
            rodadaAtual = rodada;
        } else if (rodadaAtual != rodada) {
            throw new IllegalArgumentException(
                    "Todos os jogadores devem responder à mesma rodada."
            );
        }

        Usuario jogador = getJogadorAtual();

        int pontos;

        if (placar == null) {
            pontos = jogoService.jogarRodada(partida, rodada, palpite);
        } else {
            pontos = placar.registrarPalpite(
                    partida, jogador.getId(), rodada.getFilmes(), palpite
            );
            partida.adicionarPontuacao(pontos);
        }
        avancarJogador();

        return pontos;
    }

    public int getQuantidadePalpitesRodada() {
        return palpitesRodada.size();
    }

    public int getPontuacaoJogador(Usuario jogador) {
        return pontuacoesJogadores.getOrDefault(jogador, 0);
    }

    public void configurarSorteio(SorteioService sorteioService) {
        if (sorteioService == null) {
            throw new IllegalArgumentException(
                    "O serviço de sorteio não pode ser nulo."
            );
        }

        this.sorteioService = sorteioService;
    }

    public Rodada prepararProximaRodada() {
        if (!partida.estaAtiva()) {
            throw new IllegalStateException("A partida não está ativa.");
        }

        if (sorteioService == null) {
            throw new IllegalStateException("O sorteio não foi configurado.");
        }

        if (rodadaAtual != null) {
            throw new IllegalStateException("Já existe uma rodada em andamento.");
        }

        Filmes filme = sorteioService.sortearFilme();

        rodadaAtual = new Rodada(partida.getRodadas() + 1, filme);

        return rodadaAtual;
    }


}
