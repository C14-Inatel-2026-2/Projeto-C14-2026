
package org.example.view;

import org.example.model.Filmes;
import org.example.model.Usuario;

public class TelaPartida {

    public void mostrarVezJogador(
            Usuario usuario,
            int numeroJogador,
            int rodadaAtual,
            int totalRodadas,
            Filmes filme) {

        System.out.println(
                "\n========== RODADA " + rodadaAtual
                        + " DE " + totalRodadas + " =========="
        );

        System.out.println(
                "Jogador " + numeroJogador + " - " + usuario.getNome()
        );

        System.out.println("Filme: " + filme.getNome());
        System.out.println("Ano: " + filme.getAnoLancamento());
        System.out.println("Gênero: " + filme.getGenero());
        System.out.println("Diretor: " + filme.getDiretor());

        System.out.println("\nQual é a nota do filme no IMDb?");
        System.out.print("Digite seu palpite: ");
    }
}


