package org.example.view;
import org.example.model.GerenciadorJogadores;
import org.example.model.Jogador;
import org.example.model.ConfiguracaoJogo;

import java.util.Scanner;

public class Menu {
    GerenciadorJogadores gerenciador;
    String nome;
    int id;
    ConfiguracaoJogo configuracao = new ConfiguracaoJogo();

    private Scanner scanner;

    public Menu(){
        this.scanner = new Scanner(System.in);
    }

    public Menu(Scanner scanner){
        this.scanner = scanner;
    }

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
                    System.out.println("3 - Remover jogador");
                    System.out.println("4 - Sair");
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
                            caso = 5;
                            break;

                        case 2:
                            //Vai para adicionar jogador
                            caso = 3;
                            break;

                        case 3:
                            //Vai para adicionar jogador
                            caso = 4;
                            break;

                        case 4:
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

                case 4:
                    System.out.println("");
                    System.out.println("======== Removendo Jogador ========");
                    System.out.println("Jogadores Cadastrados");

                    for (Jogador jogador : gerenciador.getJogadores()) {
                        System.out.println(
                                "ID: " + jogador.getId() + " | Nome: " + jogador.getNome()
                        );
                    }
                    System.out.println("");

                    System.out.print("insira o id desejado: ");
                    id = scanner.nextInt();
                    gerenciador.RemoverJogador(id);
                    System.out.println("Jogador de id " + id + " removido com sucesso!");
                    caso = 2;
                    break;

                case 5:
                    System.out.println("\n===== CONFIGURAÇÕES DA PARTIDA =====");

                    System.out.println("1 - Configurar partida");
                    System.out.println("2 - Voltar ao menu principal");
                    System.out.println("Escolha uma opção: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println("Opção inválida!");
                        scanner.nextLine();
                        caso = 5;
                        break;
                    }

                    int escolha = scanner.nextInt();
                    scanner.nextLine();

                    switch (escolha) {
                        case 1:
                            System.out.println("Quantidade atual de partidas: " + configuracao.getQuantidadePartidas());

                            System.out.print("Digite a quantidade desejada (1 a 10): ");

                            if(!scanner.hasNextInt()){
                                System.out.println("Digite um número válido!");
                                scanner.nextLine();
                                caso = 5;
                                break;
                            }

                            int quantidade = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                configuracao.setQuantidadePartidas(quantidade);
                                System.out.println("Configuração salva com sucesso!");
                            }catch(IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }
                            caso = 5;
                            break;

                        case 2:
                            caso = 2;
                            break;

                        default:
                            System.out.println("Opção inválida!");
                            caso = 5;
                            break;
                    }
                    break;

                case 5:
                    System.out.println("\n===== FIM DA PARTIDA =====");
                    System.out.println("Jogar novamente?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.println("Escolha uma opção: ");

                    if(!scanner.hasNextInt()){
                        System.out.println("Opção inválida!");
                        scanner.nextLine();
                        caso = 5;
                        break;
                    }

                    int resposta = scanner.nextInt();
                    scanner.nextLine();

                    switch (resposta){
                        case 1:
                            System.out.println("Voltando às configurações");
                            caso = 4;
                            break;

                        case 2:
                            System.out.println("Encerrando MovieGuesser");
                            caso = 0;
                            break;

                        default:
                            System.out.println("Opção inválida!");
                            caso = 5;
                            break;
                    }
                    break;

                default:
                    System.out.println("Tela inválida!");
                    caso = 2;
                    break;
            }
        }
    }
}
