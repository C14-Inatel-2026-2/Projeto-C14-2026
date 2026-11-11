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


    @Test
    public void RemoverJogador() {

        GerenciadorJogadores gerenciadorTest = new GerenciadorJogadores("Jorge");

        gerenciadorTest.AddJogador("João");
        gerenciadorTest.AddJogador("Pedro");
        gerenciadorTest.AddJogador("Maria");

        gerenciadorTest.RemoverJogador(2);

        assertEquals(2, gerenciadorTest.getJogadores().size());

        assertEquals("João", gerenciadorTest.getJogadores().get(0).getNome());
        assertEquals("Maria", gerenciadorTest.getJogadores().get(1).getNome());
    }

    @Test
    public void RemoverJogadorInexistente() {

        GerenciadorJogadores gerenciadorTest = new GerenciadorJogadores("Jorge");

        gerenciadorTest.AddJogador("João");

        gerenciadorTest.RemoverJogador(99);

        assertEquals(1, gerenciadorTest.getJogadores().size());
    }
}
