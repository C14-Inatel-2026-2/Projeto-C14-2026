package org.example.model;

public class Administrador extends Usuario{

    public Administrador(String nome, int id) {
        super(nome, id);
    }

    public Jogador AddJogador(String nome, int id){
        Jogador novoJogador = new Jogador(nome,id);

        return novoJogador;
    }
}