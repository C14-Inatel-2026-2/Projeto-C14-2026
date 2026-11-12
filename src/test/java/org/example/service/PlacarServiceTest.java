package org.example.service;

import org.example.model.Filmes;
import org.example.model.Jogador;
import org.example.model.Partida;
import org.example.model.Administrador;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class PlacarServiceTest {

    private final Jogador vini = new Jogador("Vini", 1);
    private final Jogador ana = new Jogador("Ana", 2);

    private final Filmes filme = new Filmes(
            "Interestelar", 2014, 8.7f, "Uma viagem espacial",
            "Christopher Nolan", 169, "10 anos", "Ficção científica"
    );

    private PlacarService placar;
    private Partida partida;

    @Before
    public void prepararPartida() {
        // Fixture comum
        placar = new PlacarService();
        partida = criarPartida(1, 2, vini, ana);
        placar.iniciarPartida(partida);
    }

    @Test
    public void devePontuarDoisJogadoresSemAvancarARodada() {
        // Procedure
        int pontosVini = placar.registrarPalpite(partida, vini.getId(), filme, 8.0);
        int pontosAna = placar.registrarPalpite(partida, ana.getId(), filme, 8.7);

        // Assert
        assertEquals(93, pontosVini);
        assertEquals(100, pontosAna);
        assertEquals(0, partida.getRodadas());
        assertTrue(partida.estaAtiva());
    }

    @Test
    public void deveAcumularPontosEOrdenarRankingDaPartida() {
        // Procedure
        placar.registrarPalpite(partida, vini.getId(), filme, 8.0);
        placar.registrarPalpite(partida, ana.getId(), filme, 8.7);
        partida.avancarRodada();

        placar.registrarPalpite(partida, vini.getId(), filme, 8.7);
        placar.registrarPalpite(partida, ana.getId(), filme, 7.0);
        partida.avancarRodada();

        var resultado = placar.rankingPartida(partida.getId());

        // Assert
        assertEquals(1, resultado.numeroPartida());
        assertEquals(List.of(
                new PlacarService.ResultadoJogador(1, "Vini", 193),
                new PlacarService.ResultadoJogador(2, "Ana", 183)
        ), resultado.ranking());
    }

    @Test
    public void deveSomarPartidasNoRankingGeralEIdentificarVencedor() {
        // Fixture
        Partida segundaPartida = criarPartida(2, 1, vini, ana);

        // Procedure
        placar.registrarPalpite(partida, vini.getId(), filme, 8.7);
        placar.registrarPalpite(partida, ana.getId(), filme, 8.0);
        partida.avancarRodada();

        placar.registrarPalpite(partida, vini.getId(), filme, 8.7);
        placar.registrarPalpite(partida, ana.getId(), filme, 8.0);
        partida.avancarRodada();

        placar.iniciarPartida(segundaPartida);
        placar.registrarPalpite(segundaPartida, vini.getId(), filme, 7.0);
        placar.registrarPalpite(segundaPartida, ana.getId(), filme, 8.7);
        segundaPartida.avancarRodada();

        var ranking = placar.rankingGeral();
        var vencedores = placar.vencedores();

        // Assert
        var campea = new PlacarService.ResultadoJogador(2, "Ana", 286);
        assertEquals(List.of(
                campea,
                new PlacarService.ResultadoJogador(1, "Vini", 283)
        ), ranking);
        assertEquals(List.of(campea), vencedores);
        assertEquals(200, placar.rankingPartida(1).ranking().get(0).pontos());
    }

    @Test
    public void deveIdentificarTodosOsVencedoresEmCasoDeEmpate() {
        // Procedure
        placar.registrarPalpite(partida, vini.getId(), filme, 8.7);
        placar.registrarPalpite(partida, ana.getId(), filme, 8.7);
        var vencedores = placar.vencedores();

        // Assert
        assertEquals(List.of(
                new PlacarService.ResultadoJogador(1, "Vini", 100),
                new PlacarService.ResultadoJogador(2, "Ana", 100)
        ), vencedores);
    }

    @Test
    public void deveSepararJogadoresComMesmoNome() {
        // Fixture
        Jogador primeiro = new Jogador("João da Silva", 10);
        Jogador segundo = new Jogador("João da Silva", 20);
        Partida outraPartida = criarPartida(2, 1, primeiro, segundo);
        placar.iniciarPartida(outraPartida);

        // Procedure
        placar.registrarPalpite(outraPartida, primeiro.getId(), filme, 8.0);
        placar.registrarPalpite(outraPartida, segundo.getId(), filme, 8.7);
        var ranking = placar.rankingPartida(2).ranking();

        // Assert
        assertEquals(List.of(
                new PlacarService.ResultadoJogador(20, "João da Silva", 100),
                new PlacarService.ResultadoJogador(10, "João da Silva", 93)
        ), ranking);
    }

    @Test
    public void deveRejeitarSegundoPalpiteDoJogadorNaMesmaRodada() {
        // Fixture
        placar.registrarPalpite(partida, vini.getId(), filme, 8.0);

        // Procedure e Assert
        assertThrows(IllegalStateException.class,
                () -> placar.registrarPalpite(partida, vini.getId(), filme, 8.7));

        assertEquals(93, placar.rankingPartida(1).ranking().get(0).pontos());
    }

    @Test
    public void deveRejeitarPalpitesInvalidosSemConsumirATentativa() {
        // Procedure e Assert
        for (double palpite : new double[]{-1, 11, 8.75, Double.NaN}) {
            assertThrows(IllegalArgumentException.class,
                    () -> placar.registrarPalpite(partida, vini.getId(), filme, palpite));
        }

        int pontos = placar.registrarPalpite(partida, vini.getId(), filme, 8.0);
        assertEquals(93, pontos);
    }

    @Test
    public void deveRejeitarJogadorForaDaPartida() {
        // Procedure e Assert
        assertThrows(IllegalArgumentException.class,
                () -> placar.registrarPalpite(partida, 99, filme, 8.0));
    }

    @Test
    public void deveRejeitarPalpiteDepoisDeEncerrarAPartida() {
        // Fixture
        partida.finalizar();

        // Procedure e Assert
        assertThrows(IllegalStateException.class,
                () -> placar.registrarPalpite(partida, vini.getId(), filme, 8.0));
    }

    @Test
    public void novoJogoDeveComecarSemResultadosAnteriores() {
        // Fixture
        placar.registrarPalpite(partida, vini.getId(), filme, 8.7);

        // Procedure
        PlacarService novoJogo = new PlacarService();

        // Assert
        assertTrue(novoJogo.rankingGeral().isEmpty());
        assertTrue(novoJogo.vencedores().isEmpty());
    }

    private Partida criarPartida(int id, int rodadas, Jogador... jogadores) {
        Partida novaPartida = new Partida(id, jogadores.length, rodadas);

        for (Jogador jogador : jogadores) {
            novaPartida.adicionarJogador(jogador);
        }

        novaPartida.iniciar();
        return novaPartida;
    }

    @Test
    public void deveIncluirAdministradorNoRanking() {
        // Fixture
        Administrador admin = new Administrador("Admin", 0);
        Partida novaPartida = new Partida(2, 2, 1);
        novaPartida.adicionarJogador(admin);
        novaPartida.adicionarJogador(ana);
        novaPartida.iniciar();
        placar.iniciarPartida(novaPartida);

        // Procedure
        placar.registrarPalpite(novaPartida, admin.getId(), filme, 8.7);
        placar.registrarPalpite(novaPartida, ana.getId(), filme, 8.0);
        novaPartida.avancarRodada();
        var ranking = placar.rankingPartida(novaPartida.getId()).ranking();

        // Assert
        assertEquals(List.of(
                new PlacarService.ResultadoJogador(0, "Admin", 100),
                new PlacarService.ResultadoJogador(2, "Ana", 93)
        ), ranking);
    }
}