package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;


public class FilmesTest {

    private Filmes filmeTeste;

    @Before
    public void prepararFilme() {
        filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );
    }


    @Test
    public void deveCriarFilmeComNotaCorreta(){

        assertEquals(8.5f, filmeTeste.getNota(), 0.001f);
    }


    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarNotaMaiorQueDez() {

        // Fixture + Exercise
        new Filmes(
                "Filme Teste",
                2025,
                15.0f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarNotaMenorQueZero() {
        new Filmes(
                "Filme Teste",
                2025,
                -1.0f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarDuracaoMenorQueZero() {

        new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                -20,
                "Livre",
                "Aventura"
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAceitarDuracaoIgualZero() {
        new Filmes(
                "Filme Teste",
                2018,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                0,
                "Livre",
                "Romance"
        );
    }

    @Test
    public void deveAceitarDuracaoValida(){

        filmeTeste.setDuracao(150);
        assertEquals(150, filmeTeste.getDuracao());

    }



    @Test
    public void deveAtualizarNotaValida() {

        filmeTeste.setNota(9.0f);

        assertEquals(9.0f, filmeTeste.getNota(), 0.001f);
    }


    @Test(expected = IllegalArgumentException.class)
    public void validarNotaDeveRejeitarNotaMaiorQueDez() {

        filmeTeste.validarNota(15.0f);

    }

    @Test
    public void validarNotaDeveAceitarNotaIgualZero() {

        filmeTeste.validarNota(0.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validarNotaDeveRejeitarNotaNegativa() {
        filmeTeste.validarNota(-1.0f);
    }

    @Test
    public void validarNotaDeveAceitarNotaIgualDez() {

        filmeTeste.validarNota(10.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validarDuracaoDeveRejeitarDuracaoNegativa() {

        filmeTeste.validarDuracao(-20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validarDuracaoDeveRejeitarDuracaoIgualZero() {

        filmeTeste.validarDuracao(0);

    }

    @Test
    public void validarDuracaoDeveAceitarDuracaoValida() {

        filmeTeste.validarDuracao(150);
    }


}
