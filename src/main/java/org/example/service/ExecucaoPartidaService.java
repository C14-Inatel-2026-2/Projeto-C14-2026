package org.example.service;

import org.example.model.Partida;
import org.example.model.Usuario;
import org.example.model.Rodada;
import java.util.LinkedHashMap;
import java.util.Map;

import java.util.List;

public class ExecucaoPartidaService {

    private final Partida partida;
    private final List<Usuario> jogadores;
    private int indiceJogadorAtual;
    private final JogoService jogoService = new JogoService();
    private final Map<Usuario, Double> palpitesRodada = new LinkedHashMap<>();

    public ExecucaoPartidaService(Partida partida) {
        if (partida == null) {
            throw new IllegalArgumentException(
                    "A partida não pode ser nula."
            );
        }

        this.jogadores = partida.getJogadores();

        if (jogadores.isEmpty()) {
            throw new IllegalArgumentException(
                    "A partida precisa ter jogadores."
            );
        }

        if (jogadores.size() != partida.getNumeroParticipantes()) {
            throw new IllegalStateException(
                    "A quantidade de jogadores cadastrados está incompleta."
            );
        }

        this.partida = partida;
        this.indiceJogadorAtual = 0;
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

        indiceJogadorAtual = 0;
        partida.avancarRodada();
        palpitesRodada.clear();
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

        Usuario jogador = getJogadorAtual();

        int pontos = jogoService.jogarRodada(partida, rodada, palpite);

        palpitesRodada.put(jogador, palpite);

        avancarJogador();

        return pontos;
    }

    public int getQuantidadePalpitesRodada() {
        return palpitesRodada.size();
    }
}
