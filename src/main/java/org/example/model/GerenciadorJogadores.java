package org.example.model;
import java.util.ArrayList;

public class GerenciadorJogadores {

    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private Administrador admin;
    private int proximoId = 1;

    public GerenciadorJogadores(String nome){
        this.admin = new Administrador(nome,0);
    }

    public void AddJogador(String nome){
        jogadores.add(admin.AddJogador(nome, proximoId));
        proximoId++;
    }


    public ArrayList<Jogador> getJogadores() { return jogadores; }

    public Administrador getAdmin() { return admin; }
}
