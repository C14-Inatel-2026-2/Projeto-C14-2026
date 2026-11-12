package org.example.view;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void devePermitirConfigurarQuantidadeDePartidas(){
        String entradas = "Admin\n1\n1\n3\n1\n2\n2\n4\n";

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(saida));

            Menu menu = new Menu(new Scanner(entradas));
            menu.GerarTela(1);

            String resultado = saida.toString();

            assertTrue(resultado.contains("Configuração salva com sucesso!"));
            assertTrue(resultado.contains("Quantidade atual de partidas: 3"));
        } finally {
            System.setOut(saidaOriginal);
        }
    }

    @Test
    public void naoDeveAlterarConfiguracaoComQuantidadeInvalida() {
        String entradas = "Admin\n1\n1\n11\n1\n2\n2\n4\n";

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream saidaOriginal = System.out;

        try {
            System.setOut(new PrintStream(saida));

            Menu menu = new Menu(new Scanner(entradas));
            menu.GerarTela(1);

            String resultado = saida.toString();

            assertTrue(resultado.contains(
                    "A quantidade de partidas deve ser entre 1 e 10"
            ));
            assertTrue(resultado.contains("Quantidade atual de partidas: 5"));

        } finally {
            System.setOut(saidaOriginal);
        }
    }

    @Test
    public void naoDeveAceitarEntradaNaoNumerica() {
        String entradas = "Admin\n1\n1\nabc\n2\n4\n";

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
}