package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PartidaTest {

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarPontuacaoNegativa() {
        Partida partida = new Partida(1 , 1,2);

        partida.iniciar();

        partida.adicionarPontuacao(-50);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarIdInvalido(){
        new Partida(0,2,3);
    }

    @Test
    public void deveAdicionarPontuacaoCorretamente(){
        Partida partida = new Partida(1,2,3);

        partida.iniciar();

        partida.adicionarPontuacao(50);
        assertEquals(50, partida.getPontuacaoTotal());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveAdicionarPontuacaoAposFinalizar(){
        Partida partida = new Partida(1,1,1);

        partida.finalizar();
        partida.adicionarPontuacao(10);
    }

    @Test
    public void deveFinalizarAposCincoRodadas(){
        Partida partida = new Partida(1,3,5);

        partida.iniciar();

        for(int i = 0; i<5; i++){
            partida.avancarRodada();
        }

        assertEquals(5, partida.getRodadas());
        assertFalse(partida.isStatus());
    }

    @Test(expected = IllegalStateException.class)
    public void naoDeveAcancarRodadaAposFinalizar(){
        Partida partida = new Partida(1,2,5);

        for(int i = 0; i <5; i++){
            partida.avancarRodada();
        }

        partida.avancarRodada();
    }
}
