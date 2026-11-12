package org.example.model;

public class ConfiguracaoJogo {

    private int quantidadePartidas;

    public ConfiguracaoJogo(){
        this.quantidadePartidas = 5;
    }

    public int getQuantidadePartidas(){
        return quantidadePartidas;
    }

    public void setQuantidadePartidas(int quantidadePartidas){
        if(quantidadePartidas < 1 || quantidadePartidas > 10){
            throw new IllegalArgumentException("A quantidade de partidas deve ser entre 1 e 10");
        }

        this.quantidadePartidas = quantidadePartidas;
    }
}
