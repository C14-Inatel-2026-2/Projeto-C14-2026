package org.example.model;

public class Jogador extends Usuario{
    private float pontuacao;

    public Jogador(String nome, String email, String senha) {
        super(nome, email, senha);
        this.pontuacao = 0;
    }
}
