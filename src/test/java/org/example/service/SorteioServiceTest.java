package org.example.service;

import org.example.model.CatalogoFilmes;
import org.example.model.Filmes;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SorteioServiceTest {

    @Test
    public void deveSortearCincoFilmesSemRepeticao() {

        CatalogoFilmes catalogo = new CatalogoFilmes();
        List<Filmes> filmes = catalogo.carregarFilmes();

        SorteioService sorteio = new SorteioService(filmes);

        List<Filmes> sorteados =
                sorteio.sortearFilmesParaPartida(5);

        assertEquals(5, sorteados.size());
        assertEquals(5, new HashSet<>(sorteados).size());
    }
}
