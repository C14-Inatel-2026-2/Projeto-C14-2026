package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    private int id;
    private int pontuacaoTotal;
    private boolean status;
    private int rodadas;
    private int limiteRodadas;
    private int numeroParticipantes;
    private boolean encerrada;
    private List<Usuario> jogadores;


    public Partida(int id, int numeroParticipantes, int limiteRodadas) {
        if (id <= 0){
            throw new IllegalArgumentException( "O ID deve ser positivo" );
        }

        if (numeroParticipantes < 1 || numeroParticipantes > 8){
            throw new IllegalArgumentException("Quantidade de participantes inválida");
        }

        if (limiteRodadas < 1 || limiteRodadas > 10){
            throw new IllegalArgumentException("Quantidade de rodadas inválida");
        }

        this.id = id;
        this.numeroParticipantes = numeroParticipantes;
        this.limiteRodadas = limiteRodadas;
        this.pontuacaoTotal = 0;
        this.rodadas = 0;
        this.status = false;
        this.encerrada = false;
        this.jogadores = new ArrayList<>();
    }

    public void iniciar(){
        if(status || encerrada){
            throw new IllegalStateException("A partida já foi iniciada ou encerrada");
        }

        this.status = true;
    }

    public int getId() {
    return id;
}

    public int getPontuacaoTotal() {
    return pontuacaoTotal;
}

    public boolean isStatus() {
    return status;
}

    public int getRodadas(){
        return rodadas;
    }

    public int getLimiteRodadas() {
        return limiteRodadas;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(int numeroParticipantes) {
        if(status || rodadas > 0){
            throw new IllegalStateException("Não é possível alternar uma partida iniciada");
        }
        if(numeroParticipantes < 1 || numeroParticipantes > 8){
            throw new IllegalArgumentException("Quantidade de participantes inválida");
        }

        this.numeroParticipantes = numeroParticipantes;
    }

    public void adicionarPontuacao(int pontos) {

        if(!status){
            throw new IllegalStateException( "A partida não está ativa" );
        }

        if (pontos < 0) {
            throw new IllegalArgumentException( "A pontuação não pode ser negativa");
        }

        this.pontuacaoTotal += pontos;
    }

    public void avancarRodada(){
        if(!status){
            throw new IllegalStateException( " A partida não está ativa" );
        }

        rodadas ++;
        if(rodadas >= limiteRodadas){
            finalizar();
        }

    }

    public void finalizar() {
        this.status = false;
        this.encerrada = true;
    }

    public boolean estaAtiva() {
        return status;
    }

    public void adicionarJogador(Usuario participante){

        if(status || encerrada){
            throw new IllegalStateException("Não é possível adicionar jogadores a uma partida iniciada ou encerrada");
        }

        if(participante == null){
            throw new IllegalArgumentException("Jogador inválido");
        }

        if(jogadores.size() >= numeroParticipantes){
            throw new IllegalStateException("A quantidade máxima de participantes foi atingida");
        }

        jogadores.add(participante);
    }

    public List<Usuario> getJogadores(){
        return new ArrayList<>(jogadores);
    }
}