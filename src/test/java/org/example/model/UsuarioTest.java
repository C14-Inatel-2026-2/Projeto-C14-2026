package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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

    @Test
    public void SenhaMinimo7Caracteres(){
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario(
                    "João",
                    "joao@email.com",
                    "123456"
            );
        });
    }

    @Test
    public void MudarSenha(){
        Usuario usuarioTest = new Usuario(
                "João",
                "Joao@email.com",
                "senhaSuperSegura123"
        );

        usuarioTest.MudarSenha("EssaSenhaÉMaisForte", "EssaSenhaÉMaisForte");

        assertEquals("EssaSenhaÉMaisForte", usuarioTest.getSenha());
    }

    @Test
    public void SenhasDiferentes(){
        Usuario usuarioTest = new Usuario(
                "João",
                "Joao@email.com",
                "senhaSuperSegura123"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            usuarioTest.MudarSenha(
                    "senhaNova123",
                    "senhaNova456"
            );
        });
    }

}
