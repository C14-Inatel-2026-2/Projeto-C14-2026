package org.example.model;
import java.util.ArrayList;
import java.util.List;

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

    public void RemoverJogador(int id) {
        jogadores.removeIf(jogador -> jogador.getId() == id);
    }


    public ArrayList<Jogador> getJogadores() { return jogadores; }

    public Administrador getAdmin() { return admin; }

    public List<Usuario> getParticipantes(){
        List<Usuario> participantes = new ArrayList<>();

        participantes.add(admin);
        participantes.addAll(jogadores);

        return participantes;
    }
}
