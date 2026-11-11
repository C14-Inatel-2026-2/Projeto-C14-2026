package org.example.model;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.example.mockito.FilmesConst;
import java.io.StringReader;

public class CatalogoFilmesTest {

    @Test
    public void deveCarregarFilmesDoJson() {

        CatalogoFilmes catalogo = new CatalogoFilmes();

        List<Filmes> filmes = catalogo.carregarFilmes();

        assertEquals(15, filmes.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCarregarFilmeComNotaInvalida() {

        CatalogoFilmes catalogo = new CatalogoFilmes();
        StringReader leitor = new StringReader(FilmesConst.NOTA_INVALIDA);

        catalogo.converterJson(leitor);

    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveCarregarFilmeComDuracaoInvalida() {

        CatalogoFilmes catalogo = new CatalogoFilmes();
        StringReader leitor = new StringReader(FilmesConst.DURACAO_INVALIDA);

        catalogo.converterJson(leitor);

    }
}
