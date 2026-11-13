package org.example.view;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.example.model.Partida;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void devePermitirConfigurarQuantidadeDeRodadas(){
        String entradas = "Admin\n1\n1\n3\n1\n3\n3\n4\n";

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(saida));

            Menu menu = new Menu(new Scanner(entradas));
            menu.GerarTela(1);

            String resultado = saida.toString();

            assertTrue(resultado.contains("Configuração salva com sucesso!"));
            assertTrue(resultado.contains("Quantidade atual de rodadas: 3"));
        } finally {
            System.setOut(saidaOriginal);
        }
    }

    @Test
    public void naoDeveAlterarConfiguracaoComQuantidadeDeRodadasInvalida() {
        String entradas = "Admin\n1\n1\n11\n1\n3\n3\n4\n";

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(saida));

            Menu menu = new Menu(new Scanner(entradas));
            menu.GerarTela(1);

            String resultado = saida.toString();

            assertTrue(resultado.contains(
                    "A quantidade de rodadas deve ser entre 1 e 10"
            ));
            assertTrue(resultado.contains("Quantidade atual de rodadas: 5"));

        } finally {
            System.setOut(saidaOriginal);
        }
    }

    @Test
    public void naoDeveAceitarEntradaNaoNumerica() {
        String entradas = "Admin\n1\n1\nabc\n3\n4\n";

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(saida));

            Menu menu = new Menu(new Scanner(entradas));
            menu.GerarTela(1);

            String resultado = saida.toString();

            assertTrue(resultado.contains("Digite um número válido!"));

        } finally {
            System.setOut(saidaOriginal);
        }
    }

    @Test
    public void deveIdentificarPartidaAtiva(){
        Partida partida = new Partida(1,2,5);
        partida.iniciar();

        Menu menu = new Menu();

        boolean resultado = menu.verificarFimPartida(partida);

        assertFalse(resultado);
    }

    @Test
    public void deveIdentificarPartidaFinalizada(){
        Partida partida = new Partida(1,2,5);
        partida.iniciar();

        for (int i=0; i<5; i++){
            partida.avancarRodada();
        }

        Menu menu = new Menu();

        boolean resultado = menu.verificarFimPartida(partida);

        assertTrue(resultado);
    }

    @Test
    public void deveEncerrarJogoAoEscolherNao() {
        String entradas = "2\n";

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(saida));

            Menu menu = new Menu(new Scanner(entradas));
            menu.GerarTela(6);

            String resultado = saida.toString();

            assertTrue(resultado.contains("Jogar novamente?"));
            assertTrue(resultado.contains("Encerrando MovieGuesser"));
        } finally {
            System.setOut(saidaOriginal);
        }
    }


        @Test
        public void deveVoltarConfiguracoesAoEscolherSim() {
            String entradas = "1\n3\n4\n";

            ByteArrayOutputStream saida = new ByteArrayOutputStream();
            PrintStream saidaOriginal = System.out;

            try {
                System.setOut(new PrintStream(saida));

                Menu menu = new Menu(new Scanner(entradas));
                menu.GerarTela(6);

                String resultado = saida.toString();

                assertTrue(resultado.contains("Voltando às configurações"));
                assertTrue(resultado.contains("CONFIGURAÇÕES DA PARTIDA"));
                assertTrue(resultado.contains("Encerrando MovieGuesser"));

            } finally {
                System.setOut(saidaOriginal);
            }
        }

    }
