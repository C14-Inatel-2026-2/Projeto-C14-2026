package org.example.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConfiguracaoJogoTest {

    @Test
    public void deveIniciarComCincoRodadas(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        assertEquals(5, config.getQuantidadeRodadas());
    }

    @Test
    public void devePermitirUmaRodada(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        config.setQuantidadeRodadas(1);
        assertEquals(1, config.getQuantidadeRodadas());
    }

    @Test
    public void devePermitirDezRodadas(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        config.setQuantidadeRodadas(10);
        assertEquals(10, config.getQuantidadeRodadas());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirMaisDeDezRodadas(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        config.setQuantidadeRodadas(11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDevePermitirZeroRodadas(){
        ConfiguracaoJogo config = new ConfiguracaoJogo();
        config.setQuantidadeRodadas(0);
    }
}
