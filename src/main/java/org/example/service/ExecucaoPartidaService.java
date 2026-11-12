package org.example.service;

import org.example.model.Partida;
import org.example.model.Usuario;

import java.util.List;

public class ExecucaoPartidaService {

    private final Partida partida;
    private final List<Usuario> jogadores;
    private int indiceJogadorAtual;

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

    public boolean avancarJogador() {
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
        return false;
    }
}
