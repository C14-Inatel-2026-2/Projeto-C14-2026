package org.example.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class FilmesTest {

    @Test
    public void deveCriarFilmeComNotaCorreta(){
        Filmes filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );

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
        Filmes filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );

        filmeTeste.setDuracao(150);

        assertEquals(150, filmeTeste.getDuracao());

    }



    @Test
    public void deveAtualizarNotaValida() {
        Filmes filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );

        filmeTeste.setNota(9.0f);

        assertEquals(9.0f, filmeTeste.getNota(), 0.001f);
    }


    @Test(expected = IllegalArgumentException.class)
    public void validarNotaDeveRejeitarNotaMaiorQueDez() {

        Filmes filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );

        filmeTeste.validarNota(15.0f);

    }

    @Test
    public void validarNotaDeveAceitarNotaIgualZero() {

        Filmes filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );


        filmeTeste.validarNota(0.0f);
    }

    @Test
    public void validarNotaDeveAceitarNotaIgualDez() {

        // Fixture
        Filmes filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );

        // Exercise
        filmeTeste.validarNota(10.0f);

        // Assertion: o método deve terminar sem lançar exceção.
    }

    @Test(expected = IllegalArgumentException.class)
    public void validarDuracaoDeveRejeitarDuracaoNegativa() {

        Filmes filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );

        filmeTeste.validarDuracao(-20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validarDuracaoDeveRejeitarDuracaoIgualZero() {

        Filmes filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );

        filmeTeste.validarDuracao(0);

    }

    @Test
    public void validarDuracaoDeveAceitarDuracaoValida() {

        // Fixture
        Filmes filmeTeste = new Filmes(
                "Filme Teste",
                2025,
                8.5f,
                "Sinopse do filme teste",
                "Diretor Teste",
                120,
                "Livre",
                "Aventura"
        );

        // Exercise
        filmeTeste.validarDuracao(150);

        // Assertion: o método deve terminar sem lançar exceção.
    }



}
