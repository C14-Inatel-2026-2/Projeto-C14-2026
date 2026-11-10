package org.example.model;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CatalogoFilmesTest {

    @Test
    public void deveCarregarFilmesDoJson() {

        CatalogoFilmes catalogo = new CatalogoFilmes();

        List<Filmes> filmes = catalogo.carregarFilmes();

        assertEquals(15, filmes.size());
    }
}
