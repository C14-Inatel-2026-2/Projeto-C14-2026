
package org.example.service;

import org.example.model.CatalogoFilmes;
import org.example.model.Partida;
import org.example.model.Rodada;
import org.example.view.TelaPartida;
import java.math.BigDecimal;

import java.util.Scanner;

public class FluxoPartidaService {

    private final Partida partida;
    private final ExecucaoPartidaService execucao;
    private final TelaPartida tela;
    private final Scanner scanner;
    private final PlacarService placar;

    public FluxoPartidaService(Partida partida, Scanner scanner, PlacarService placar) {
        if (partida == null || scanner == null) {
            throw new IllegalArgumentException(
                    "A partida e o scanner não podem ser nulos."
            );
        }

        this.partida = partida;
        this.scanner = scanner;
        this.placar = placar;
        this.execucao = new ExecucaoPartidaService(partida, placar);
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

        var resultado = placar.rankingPartida(partida.getId());
        System.out.printf("%n=== Ranking da partida %d ===%n", resultado.numeroPartida());

        for (var jogador : resultado.ranking()) {
            System.out.printf("%s: %d pontos%n", jogador.nome(), jogador.pontos());
        }
    }

    private double lerPalpite() {
        while (true) {
            String entrada = scanner.nextLine().trim();

            try {
                double palpite = Double.parseDouble(
                        entrada.replace(',', '.')
                );

                // Valida o intervalo e rejeita NaN e infinito.
                if (!Double.isFinite(palpite)
                        || palpite < 0
                        || palpite > 10) {

                    System.out.print(
                            "Palpite inválido! Digite uma nota de 0 a 10: "
                    );
                    continue;
                }

                // Aplica a mesma regra de casas decimais do placar.
                if (BigDecimal.valueOf(palpite)
                        .stripTrailingZeros().scale() > 1) {

                    System.out.print(
                            "Use no máximo uma casa decimal. Tente novamente: "
                    );
                    continue;
                }

                return palpite;

            } catch (NumberFormatException e) {
                System.out.print(
                        "Entrada inválida! Digite uma nota de 0 a 10: "
                );
            }
        }
    }
}

