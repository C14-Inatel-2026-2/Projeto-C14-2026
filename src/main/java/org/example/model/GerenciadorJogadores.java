package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class GerenciadorJogadores {

    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private Administrador admin;
    private int proximoId = 1;

    private List <Usuario> ordemParticipantes = new ArrayList<>();

    public GerenciadorJogadores(String nome){
        this.admin = new Administrador(nome,0);
        ordemParticipantes.add(admin);
    }

    public void AddJogador(String nome){
        Jogador novoJogador = admin.AddJogador(nome, proximoId);

        jogadores.add(novoJogador);
        ordemParticipantes.add(novoJogador);
        proximoId++;
    }

    public void RemoverJogador(int id) {

        jogadores.removeIf(jogador -> jogador.getId() == id);
        ordemParticipantes.removeIf(usuario -> usuario.getId() == id);
    }


    public ArrayList<Jogador> getJogadores() { return jogadores; }

    public Administrador getAdmin() { return admin; }

    public List<Usuario> getParticipantes(){
        return new ArrayList<>(ordemParticipantes);
    }

    public void rotacionarParticipantes(){
        Collections.rotate(ordemParticipantes, 1);
    }
}
