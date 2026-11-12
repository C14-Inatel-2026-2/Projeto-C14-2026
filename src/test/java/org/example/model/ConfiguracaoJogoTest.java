package org.example.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConfiguracaoJogoTest {

    @Test
    public void deveIniciarComCincoPartidas(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        assertEquals(5, config.getQuantidadePartidas());
    }

    @Test
    public void devePermitirUmaPartida(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        config.setQuantidadePartidas(1);
        assertEquals(1, config.getQuantidadePartidas());
    }

    @Test
    public void devePermitirDezPartidas(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        config.setQuantidadePartidas(10);
        assertEquals(10, config.getQuantidadePartidas());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirMaisDeDezPartidas(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        config.setQuantidadePartidas(11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirZeroPartidas(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        config.setQuantidadePartidas(0);
    }
}
