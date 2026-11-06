package org.example;

import org.example.model.Filmes;
import org.example.model.Partida;
import org.example.model.Rodada;
import org.example.service.JogoService;

public class Main {

    public static void main(String[] args) {
        System.out.println("MovieGuesser funcionando!");

        Filmes filme = new Filmes(
                "Interestelar",
                2014,
                8.7f,
                "Uma viagem espacial",
                "Christopher Nolan",
                169,
                "10 anos",
                "Ficção científica / Aventura"
        );

        Partida partida = new Partida(1);
        Rodada rodada = new Rodada(1, filme);
        JogoService jogo = new JogoService();

        int pontos = jogo.jogarRodada(partida, rodada, 8.0);

        System.out.println("Filme: " + filme.getNome());
        System.out.println("Palpite: " + rodada.getPalpite());
        System.out.println("Nota do filme: " + filme.getNota());
        System.out.println("Pontos da rodada: " + pontos);
        System.out.println("Total da partida: " + partida.getPontuacaoTotal());
    }



}