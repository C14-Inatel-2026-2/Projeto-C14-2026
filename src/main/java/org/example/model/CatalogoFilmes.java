package org.example.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

    public class CatalogoFilmes {

        public List<Filmes> carregarFilmes() {

            InputStream arquivo = getClass()
                    .getResourceAsStream("/filmes.json");

            if (arquivo == null) {
                throw new IllegalStateException(
                        "Arquivo filmes.json não encontrado."
                );
            }

            try (Reader leitor = new InputStreamReader(
                    arquivo, StandardCharsets.UTF_8)) {

                Gson gson = new Gson();

                Type tipoLista = new TypeToken<List<Filmes>>() {}.getType();

                List<Filmes> filmes = gson.fromJson(leitor, tipoLista);

                if (filmes == null) {
                    throw new IllegalStateException(
                            "O catálogo de filmes está vazio."
                    );
                }
                for (Filmes filme : filmes) {
                    filme.validarNota(filme.getNota());
                    filme.validarDuracao(filme.getDuracao());
                }

                return filmes;

            } catch (java.io.IOException e) {
                throw new IllegalStateException(
                        "Erro ao ler o catálogo de filmes.", e
                );
            }
        }
    }
