package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UsuarioTest {

    @Test
    public void CadastroUsuario(){
        Usuario usuarioTest = new Usuario(
                "João",
                "Joao@email.com",
                "senhaSuperSegura123"
        );

        assertEquals("João", usuarioTest.getNome());
        assertEquals("Joao@email.com", usuarioTest.getEmail());
        assertEquals("senhaSuperSegura123", usuarioTest.getSenha());
        assertEquals("João", usuarioTest.getPerfil());
    }

    @Test
    public void MudarPerfil(){
        Usuario usuarioTest = new Usuario(
                "João",
                "Joao@email.com",
                "senhaSuperSegura123"
        );

        usuarioTest.MudarPerfil("Pedro");

        assertEquals("Pedro", usuarioTest.getPerfil());
    }


}
