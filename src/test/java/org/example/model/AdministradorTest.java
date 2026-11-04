package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdministradorTest {

    @Test
    public void CadastroAdminNome(){
        Usuario usuarioTest = new Administrador("João", 0);

        assertEquals("João", usuarioTest.getNome());
    }

    @Test
    public void CadastroAdminId(){
        Usuario usuarioTest = new Administrador("João", 0);

        assertEquals(0, usuarioTest.getId());
    }

    @Test
    public void CadastroAdminPontuacao(){
        Usuario usuarioTest = new Administrador("João", 0);

        assertEquals(0, usuarioTest.getPontuacao());
    }

    @Test
    public void CriarJogador(){
        Administrador usuarioTest = new Administrador("João", 0);
        Jogador jogador1 = usuarioTest.AddJogador("jogador 1");

        assertEquals("jogador 1", jogador1.getNome());
    }
}
