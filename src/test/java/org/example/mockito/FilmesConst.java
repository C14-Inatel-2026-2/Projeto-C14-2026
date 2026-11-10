package org.example.mockito;

public class FilmesConst {

    public static final String NOTA_INVALIDA = """
            [
                {
                    "nome": "Filme Teste",
                    "anoLancamento": 2025,
                    "nota": 15.0,
                    "sinopse": "Sinopse teste",
                    "diretor": "Diretor Teste",
                    "duracao": 120,
                    "classificacao": "Livre",
                    "genero": "Aventura"
                }
            ]
            """;
    public static final String DURACAO_INVALIDA = """
        [
            {
                "nome": "Filme Teste",
                "anoLancamento": 2025,
                "nota": 8.0,
                "sinopse": "Sinopse teste",
                "diretor": "Diretor Teste",
                "duracao": 0,
                "classificacao": "Livre",
                "genero": "Aventura"
            }
        ]
        """;
}
