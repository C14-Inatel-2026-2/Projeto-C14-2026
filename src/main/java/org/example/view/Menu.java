package org.example.model;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    GerenciadorJogadores gerenciador;
    String nome;

    public void GerarTela(int caso) {

        while (caso != 0) {

            switch (caso) {
                case 1:
                    System.out.println("========== Criando Admin ==========");
                    System.out.print("insira o nome desejado: ");
                    nome = scanner.nextLine();

                    this.gerenciador = new GerenciadorJogadores(nome);
                    System.out.println("Administrador " + gerenciador.getAdmin().getNome() + " criado com sucesso!");

                    caso = 2;
                    break;

                case 2:
                    System.out.println("\n=====MOVIE GUESSER=====");
                    System.out.println("1 - Jogar");
                    System.out.println("2 - Adicionar jogador");
                    System.out.println("3 - Sair");
                    System.out.print("Escolha uma opção: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Opção inválida!");
                        scanner.nextLine();

                        caso = 2;
                        break;
                    }

                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("Indo para configurações");
                            //Futuramente chamar a tela de configurações (caso = 4)
                            caso = 2;
                            break;

                        case 2:
                            //Vai para adicionar jogador
                            caso = 3;
                            break;

                        case 3:
                            System.out.println("Encerrando MovieGuesser");

                            caso = 0;
                            break;

                        default:
                            System.out.println("Opção inválida!");
                            caso = 2;
                            break;
                    }
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
                    caso = 2;
                    break;

                default:
                    System.out.println("Tela inválida!");
                    caso = 2;
                    break;
            }
        }
    }
}
