package org.example.model;

public class Partida {

    private int id;
    private int pontuacaoTotal;
    private boolean status;
    private int rodadas;
    private static final int limiteRodadas = 5;


    public Partida(int id) {
        if (id <= 0){
            throw new IllegalArgumentException( "O ID deve ser positivo" );
        }

        this.id = id;
        this.pontuacaoTotal = 0;
        this.status = true;
        this.rodadas = 0;
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

    public void adicionarPontuacao(int pontos) {

        if(!status){
            throw new IllegalStateException( "A partida já foi finalizada" );
        }

        if (pontos < 0) {
            throw new IllegalArgumentException( "A pontuação não pode ser negativa");
        }

        this.pontuacaoTotal += pontos;
    }

    public void avancarRodada(){
        if(!status){
            throw new IllegalStateException( " A partida já foi finalizada" );
        }

        rodadas ++;
        if(rodadas >= limiteRodadas){
            finalizar();
        }

    }

    public void finalizar() {
        this.status = false;
    }

    public boolean estaAtiva() {
        return status;
    }

}