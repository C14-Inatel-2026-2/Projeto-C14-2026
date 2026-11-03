package org.example.model;

public class Administrador extends Usuario{

    public Administrador(String nome, int id) {
        super(nome, id);
    }

    public void AddJogador(String nome){
        // precisa criar variavel global chamada proximoId pra controlar quantos já existem e garantir que nenhum id se repita

        // proximoId++;
        // Jogador novoJogador = new Jogador(nome, proximoId);
    }
}
