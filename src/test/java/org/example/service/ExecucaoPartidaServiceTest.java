package org.example.service;

import org.example.model.Jogador;
import org.example.model.Partida;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExecucaoPartidaServiceTest {

    private Partida partida;
    private ExecucaoPartidaService execucao;

    @Before
    public void prepararTeste() {
        partida = new Partida(1, 3, 2);

        partida.adicionarJogador(new Jogador("Ana", 1));
        partida.adicionarJogador(new Jogador("Pedro", 2));
        partida.adicionarJogador(new Jogador("Lucas", 3));

        partida.iniciar();

        execucao = new ExecucaoPartidaService(partida);
    }

    @Test
    public void deveComecarComPrimeiroJogador() {
        assertEquals("Ana", execucao.getJogadorAtual().getNome());
    }

    @Test
    public void devePassarParaProximoJogador() {
        execucao.avancarJogador();

        assertEquals("Pedro", execucao.getJogadorAtual().getNome());
    }

    @Test
    public void deveAvancarRodadaAposUltimoJogador() {
        execucao.avancarJogador();
        execucao.avancarJogador();
        execucao.avancarJogador();

        assertEquals(1, partida.getRodadas());
    }
}
