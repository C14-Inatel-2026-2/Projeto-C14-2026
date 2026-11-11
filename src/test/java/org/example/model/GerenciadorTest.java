package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GerenciadorTest {
    @Test
    public void CadastroAdminNome(){
        GerenciadorJogadores gerenciadorTest = new GerenciadorJogadores("Jorge");

        assertEquals("Jorge", gerenciadorTest.getAdmin().getNome());
    }

    @Test
    public void CadastroAdminId(){
        GerenciadorJogadores gerenciadorTest = new GerenciadorJogadores("Jorge");

        assertEquals(0, gerenciadorTest.getAdmin().getId());
    }



    @Test
    public void CadastroJogadorNome(){
        GerenciadorJogadores gerenciadorTest = new GerenciadorJogadores("Jorge");
        gerenciadorTest.AddJogador("João");

        assertEquals("João", gerenciadorTest.getJogadores().get(0).getNome());
    }

    @Test
    public void CadastroJogadorId(){
        GerenciadorJogadores gerenciadorTest = new GerenciadorJogadores("Jorge");
        gerenciadorTest.AddJogador("João");

        assertEquals(1, gerenciadorTest.getJogadores().get(0).getId());
    }
    
    @Test
    public void MudarNomeUsuario(){
        GerenciadorJogadores gerenciadorTest = new GerenciadorJogadores("Jorge");
        gerenciadorTest.AddJogador("João");

        gerenciadorTest.getJogadores().get(0).setNome("Vini");

        assertEquals("Vini", gerenciadorTest.getJogadores().get(0).getNome());
    }
}
