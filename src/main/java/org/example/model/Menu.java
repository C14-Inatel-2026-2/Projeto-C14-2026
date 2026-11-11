package org.example.model;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    GerenciadorJogadores gerenciador;
    String nome;

    public void GerarTela(int caso) {
        switch (caso) {
            case 1:
                System.out.println("========== Criando Admin ==========");
                System.out.print("insira o nome desejado: ");
                nome = scanner.nextLine();

                this.gerenciador = new GerenciadorJogadores(nome);
                System.out.println("Administrador " + gerenciador.getAdmin().getNome() + " criado com sucesso!");

                break;

            case 2:
                //add menu principal
                break;

            case 3:
                System.out.println("");
                System.out.println("======= Adicionando Jogador =======");
                System.out.println("Jogadores Cadastrados");

                for (Jogador jogador : gerenciador.getJogadores()) {
                    System.out.println(
                            "ID: " + jogador.getId() + " | Nome: " + jogador.getNome()
                    );
                }
                System.out.println("");

                System.out.print("insira o nome desejado: ");
                nome = scanner.nextLine();

                gerenciador.AddJogador(nome);
                System.out.println("Jogador " + nome + " criado com sucesso!");
                GerarTela(2);

                break;
        }
    }
}
