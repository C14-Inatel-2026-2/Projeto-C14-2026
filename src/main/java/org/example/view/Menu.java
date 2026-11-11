package org.example.view;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void exibirMenu(){
        int opcao;

        do{
            System.out.println("\n=====MOVIE GUESSER=====");
            System.out.println("1 - Jogar");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");

            if(!scanner.hasNextInt()){
                System.out.println("Opcao invalida!");
                scanner.nextLine();
                continue;
            }

            opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("Indo para configurações...");
                    return;

                case 2:
                    System.out.println("Encerrando Movie Guesser!!!");
                    return;

                default:
                    System.out.println("Opcao inválida!");
            }
        }while(true);
    }
}


