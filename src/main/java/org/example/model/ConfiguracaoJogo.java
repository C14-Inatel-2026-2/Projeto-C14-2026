package org.example.model;

public class ConfiguracaoJogo {

    private int quantidadeRodadas;

    public ConfiguracaoJogo(){
        this.quantidadeRodadas = 5;
    }

    public int getQuantidadeRodadas(){
        return quantidadeRodadas;
    }

    public void setQuantidadeRodadas(int quantidadeRodadas){
        if(quantidadeRodadas < 1 || quantidadeRodadas > 10){
            throw new IllegalArgumentException("A quantidade de rodadas deve ser entre 1 e 10");
        }

        this.quantidadeRodadas = quantidadeRodadas;
    }
}
