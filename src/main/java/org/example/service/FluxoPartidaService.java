
package org.example.service;

import org.example.model.CatalogoFilmes;
import org.example.model.Partida;
import org.example.model.Rodada;
import org.example.view.TelaPartida;

import java.util.Scanner;

public class FluxoPartidaService {

    private final Partida partida;
    private final ExecucaoPartidaService execucao;
    private final TelaPartida tela;
    private final Scanner scanner;

    public FluxoPartidaService(Partida partida, Scanner scanner) {
        if (partida == null || scanner == null) {
            throw new IllegalArgumentException(
                    "A partida e o scanner não podem ser nulos."
            );
        }

        this.partida = partida;
        this.scanner = scanner;
        this.execucao = new ExecucaoPartidaService(partida);
        this.tela = new TelaPartida();

        CatalogoFilmes catalogo = new CatalogoFilmes();
        SorteioService sorteio = new SorteioService(
                catalogo.carregarFilmes()
        );

        if (sorteio.quantidadeDisponivel() < partida.getLimiteRodadas()) {
            throw new IllegalStateException(
                    "Não há filmes suficientes para todas as rodadas."
            );
        }

        execucao.configurarSorteio(sorteio);
    }

    public void executar() {
        if (!partida.estaAtiva()) {
            partida.iniciar();
        }

        while (partida.estaAtiva()) {
            Rodada rodada = execucao.prepararProximaRodada();
            int numeroRodada = partida.getRodadas() + 1;

            while (partida.estaAtiva()
                    && partida.getRodadas() < numeroRodada) {

                tela.mostrarVezJogador(
                        execucao.getJogadorAtual(),
                        execucao.getNumeroJogadorAtual(),
                        numeroRodada,
                        partida.getLimiteRodadas(),
                        rodada.getFilmes()
                );

                double palpite = lerPalpite();

                int pontos = execucao.registrarPalpite(rodada, palpite);

                System.out.println(
                        "\nVocê ganhou " + pontos + " pontos!"
                );
            }
        }

        System.out.println("\nPartida finalizada!");
    }

    private double lerPalpite() {
        while (true) {
            String entrada = scanner.nextLine().trim();

            try {
                double palpite = Double.parseDouble(
                        entrada.replace(',', '.')
                );

                if (!Double.isFinite(palpite)
                        || palpite < 0
                        || palpite > 10) {
                    throw new NumberFormatException();
                }

                return palpite;

            } catch (NumberFormatException e) {
                System.out.print(
                        "Palpite inválido! Digite uma nota de 0 a 10: "
                );
            }
        }
    }
}

