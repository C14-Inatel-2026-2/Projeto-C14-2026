package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JogadorTest {

    @Test
    public void CadastroJogadorNome(){
        Usuario usuarioTest = new Jogador("João", 0);

        assertEquals("João", usuarioTest.getNome());
    }

    @Test
    public void CadastroJogadorId(){
        Usuario usuarioTest = new Jogador("João", 0);

        assertEquals(0, usuarioTest.getId());
    }

    @Test
    public void CadastroJogadorPontuacao(){
        Usuario usuarioTest = new Jogador("João", 0);

        assertEquals(0, usuarioTest.getPontuacao());
    }

    @Test
    public void MudarNome(){
        Usuario usuarioTest = new Jogador(
                "João",
                0
        );
        usuarioTest.setNome("Pedro");

        assertEquals("Pedro", usuarioTest.getNome());
    }
}
