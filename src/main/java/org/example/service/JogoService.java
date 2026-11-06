package org.example.service;

import org.example.model.Partida;
import org.example.model.Rodada;

public class JogoService {

    public int jogarRodada(Partida partida, Rodada rodada, double palpite) {
        if (!partida.estaAtiva()) {
            throw new IllegalStateException("A partida já foi finalizada");
        }

        rodada.fazerPalpite(palpite);
        rodada.calcularPontuacao();

        int pontos = (int) Math.round(rodada.getPontuacao());
        partida.adicionarPontuacao(pontos);
        partida.avancarRodada();

        return pontos;
    }
}