package org.example.model;

public abstract class Usuario {

    private int id;
    private String nome;
    private int pontuacao;

    public Usuario(String nome, int id) {
        this.id = id;
        this.nome = nome;
        this.pontuacao = 0;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public int getPontuacao() { return pontuacao; }

    public void setPontuacao(int pontuacao) { this.pontuacao = pontuacao; }
}
