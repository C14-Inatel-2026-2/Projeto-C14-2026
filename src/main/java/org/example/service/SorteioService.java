
package org.example.service;

import org.example.model.Filmes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SorteioService {

    private final List<Filmes> filmesDisponiveis;

    public SorteioService(List<Filmes> filmes) {
        if (filmes == null || filmes.isEmpty()) {
            throw new IllegalArgumentException(
                    "O catálogo de filmes não pode estar vazio."
            );
        }

        this.filmesDisponiveis = new ArrayList<>(filmes);
        Collections.shuffle(this.filmesDisponiveis);
    }

    public Filmes sortearFilme() {
        if (filmesDisponiveis.isEmpty()) {
            throw new IllegalStateException(
                    "Não existem mais filmes disponíveis."
            );
        }

        return filmesDisponiveis.remove(0);
    }

    public int quantidadeDisponivel() {
        return filmesDisponiveis.size();
    }

    public List<Filmes> sortearFilmesParaPartida(int quantidadeRodadas) {
        if (quantidadeRodadas < 1) {
            throw new IllegalArgumentException(
                    "A quantidade de rodadas deve ser positiva."
            );
        }

        if (quantidadeRodadas > filmesDisponiveis.size()) {
            throw new IllegalArgumentException(
                    "Não há filmes suficientes para todas as rodadas."
            );
        }

        List<Filmes> filmesSorteados = new ArrayList<>();

        for (int i = 0; i < quantidadeRodadas; i++) {
            filmesSorteados.add(sortearFilme());
        }

        return filmesSorteados;
    }

}

