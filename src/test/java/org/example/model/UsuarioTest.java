package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class UsuarioTest {

    @Test
    public void CadastroJogador(){
        Usuario usuarioTest = new Jogador(
                "João",
                0
        );

        assertEquals("João", usuarioTest.getNome());
        assertEquals(0, usuarioTest.getId());
        assertEquals(0, usuarioTest.getPontuacao());
    }

    @Test
    public void CadastroAdmin(){
        Usuario usuarioTest = new Administrador(
                "João",
                0
        );

        assertEquals("João", usuarioTest.getNome());
        assertEquals(0, usuarioTest.getId());
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
