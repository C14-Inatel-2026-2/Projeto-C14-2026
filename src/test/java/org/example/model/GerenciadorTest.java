package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import java.util.List;

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

    @Test
    public void deveRetornarAdministradorComoParticipante(){
        GerenciadorJogadores gerenciador = new GerenciadorJogadores("Jorge");
        List<Usuario> participantes = gerenciador.getParticipantes();

        assertEquals(1, participantes.size());
        assertEquals("Jorge", participantes.get(0).getNome());
        assertEquals(0, participantes.get(0).getId());
    }

    @Test
    public void deveRetornarTodosOsJogadoresComoParticipantes(){
        GerenciadorJogadores gerenciador = new GerenciadorJogadores("Jorge");

        gerenciador.AddJogador("João");
        gerenciador.AddJogador("Maria");

        List<Usuario> participantes = gerenciador.getParticipantes();

        assertEquals(3, participantes.size());
        assertEquals("Jorge", participantes.get(0).getNome());
        assertEquals("João", participantes.get(1).getNome());
        assertEquals("Maria", participantes.get(2).getNome());
    }

    @Test
    public void devePreservarIdDosParticipantes(){
        GerenciadorJogadores gerenciador = new GerenciadorJogadores("Jorge");

        gerenciador.AddJogador("João");
        gerenciador.AddJogador("Maria");

        List<Usuario> participantes = gerenciador.getParticipantes();

        assertEquals(0, participantes.get(0).getId());
        assertEquals(1, participantes.get(1).getId());
        assertEquals(2, participantes.get(2).getId());
    }

    @Test
    public void deveRetornarListaIndependenteDoCadastroOriginal(){
        GerenciadorJogadores gerenciador = new GerenciadorJogadores("Jorge");
        gerenciador.AddJogador("João");

        List<Usuario> participantes = gerenciador.getParticipantes();

        participantes.clear();

        assertEquals(1, gerenciador.getJogadores().size());
        assertEquals(2, gerenciador.getParticipantes().size());
    }

}
