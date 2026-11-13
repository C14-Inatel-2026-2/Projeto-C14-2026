
package org.example.service;

import org.example.model.Filmes;
import org.example.model.Jogador;
import org.example.model.Partida;
import org.example.model.Usuario;
import org.example.model.Rodada;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExecucaoPartidaServiceTest {

    private Partida partida;
    private Rodada rodada;
    private ExecucaoPartidaService execucao;

    @Before
    public void prepararTeste() {
        partida = new Partida(1, 3, 2);

        partida.adicionarJogador(new Jogador("Ana", 1));
        partida.adicionarJogador(new Jogador("Pedro", 2));
        partida.adicionarJogador(new Jogador("Lucas", 3));

        Filmes filme = new Filmes(
                "Interestelar",
                2014,
                8.7f,
                "Viagem espacial",
                "Christopher Nolan",
                169,
                "10 anos",
                "Ficção científica"
        );

        rodada = new Rodada(1, filme);

        partida.iniciar();
        execucao = new ExecucaoPartidaService(partida);
    }

    @Test
    public void deveComecarComPrimeiroJogador() {
        assertEquals("Ana", execucao.getJogadorAtual().getNome());
    }

    @Test
    public void devePassarParaProximoJogadorAposPalpite() {
        execucao.registrarPalpite(rodada, 8.5);

        assertEquals("Pedro", execucao.getJogadorAtual().getNome());
    }

    @Test
    public void naoDeveAvancarRodadaAntesDeTodosResponderem() {
        execucao.registrarPalpite(rodada, 8.5);
        execucao.registrarPalpite(rodada, 9.0);

        assertEquals(0, partida.getRodadas());
    }

    @Test
    public void deveAvancarRodadaAposTodosResponderem() {
        execucao.registrarPalpite(rodada, 8.5);
        execucao.registrarPalpite(rodada, 9.0);
        execucao.registrarPalpite(rodada, 8.2);

        assertEquals(1, partida.getRodadas());
    }

    @Test
    public void deveReiniciarComPrimeiroJogadorNaProximaRodada() {
        execucao.registrarPalpite(rodada, 8.5);
        execucao.registrarPalpite(rodada, 9.0);
        execucao.registrarPalpite(rodada, 8.2);

        assertEquals("Ana", execucao.getJogadorAtual().getNome());
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRejeitarPalpiteMaiorQueDez() {
        execucao.registrarPalpite(rodada, 11.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRejeitarPalpiteNegativo() {
        execucao.registrarPalpite(rodada, -1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveRejeitarPalpiteNaoNumerico() {
        execucao.registrarPalpite(rodada, Double.NaN);
    }


    @Test
    public void naoDeveAvancarJogadorComPalpiteInvalido() {
        try {
            execucao.registrarPalpite(rodada, 11.0);
            fail("Deveria lançar uma exceção para palpite inválido.");
        } catch (IllegalArgumentException e) {
            assertEquals("Ana", execucao.getJogadorAtual().getNome());
        }
    }

    @Test
    public void deveManterPartidaAtivaAntesDaUltimaRodada() {
        execucao.registrarPalpite(rodada, 8.5);
        execucao.registrarPalpite(rodada, 9.0);
        execucao.registrarPalpite(rodada, 8.2);

        assertTrue(partida.estaAtiva());
    }

    @Test
    public void deveLimparPalpitesAoFinalDaRodada() {
        execucao.registrarPalpite(rodada, 8.5);
        execucao.registrarPalpite(rodada, 9.0);
        execucao.registrarPalpite(rodada, 8.2);

        assertEquals(0, execucao.getQuantidadePalpitesRodada());
    }


    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirTrocarRodadaAntesDeTodosResponderem() {
        execucao.registrarPalpite(rodada, 8.5);

        Filmes outroFilme = new Filmes(
                "Titanic",
                1997,
                7.9f,
                "Romance a bordo de um navio",
                "James Cameron",
                194,
                "12 anos",
                "Romance"
        );

        Rodada outraRodada = new Rodada(2, outroFilme);

        execucao.registrarPalpite(outraRodada, 9.0);
    }


    @Test
    public void devePermitirNovaRodadaAposTodosResponderem() {
        execucao.registrarPalpite(rodada, 8.5);
        execucao.registrarPalpite(rodada, 9.0);
        execucao.registrarPalpite(rodada, 8.2);

        Filmes outroFilme = new Filmes(
                "Titanic",
                1997,
                7.9f,
                "Romance a bordo de um navio",
                "James Cameron",
                194,
                "12 anos",
                "Romance"
        );

        Rodada segundaRodada = new Rodada(2, outroFilme);

        execucao.registrarPalpite(segundaRodada, 7.5);

        assertEquals("Pedro", execucao.getJogadorAtual().getNome());
    }


    @Test
    public void deveFinalizarPartidaAoAtingirLimiteDeRodadas() {
        execucao.registrarPalpite(rodada, 8.5);
        execucao.registrarPalpite(rodada, 9.0);
        execucao.registrarPalpite(rodada, 8.2);

        Filmes outroFilme = new Filmes(
                "Titanic",
                1997,
                7.9f,
                "Romance a bordo de um navio",
                "James Cameron",
                194,
                "12 anos",
                "Romance"
        );

        Rodada segundaRodada = new Rodada(2, outroFilme);

        execucao.registrarPalpite(segundaRodada, 7.5);
        execucao.registrarPalpite(segundaRodada, 8.0);
        execucao.registrarPalpite(segundaRodada, 7.8);

        assertFalse(partida.estaAtiva());
    }


    @Test
    public void devePrepararRodadaComFilmeSorteado() {
        Filmes filme = new Filmes(
                "Interestelar",
                2014,
                8.7f,
                "Viagem espacial",
                "Christopher Nolan",
                169,
                "10 anos",
                "Ficção científica"
        );

        SorteioService sorteio = new SorteioService(
                Collections.singletonList(filme)
        );

        execucao.configurarSorteio(sorteio);

        Rodada rodadaPreparada = execucao.prepararProximaRodada();

        assertEquals(filme, rodadaPreparada.getFilmes());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveRegistrarPalpiteSemPrepararRodada() {
        SorteioService sorteio = new SorteioService(
                Collections.singletonList(rodada.getFilmes())
        );

        execucao.configurarSorteio(sorteio);

        execucao.registrarPalpite(rodada, 8.5);
    }



}
