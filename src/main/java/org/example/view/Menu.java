package org.example.view;
import org.example.model.GerenciadorJogadores;
import org.example.model.Jogador;
import org.example.model.ConfiguracaoJogo;
import org.example.model.Partida;
import org.example.service.FluxoPartidaService;
import org.example.service.PlacarService;
import org.example.model.Usuario;
import java.util.List;

import java.util.Scanner;

public class Menu {
    GerenciadorJogadores gerenciador;
    String nome;
    int id;
    ConfiguracaoJogo configuracao = new ConfiguracaoJogo();
    private final PlacarService placar = new PlacarService();
    private int proximoIdPartida = 1;

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
                    nome = scanner.nextLine().trim();

                    if (nome.isEmpty()) {
                        System.out.println("O nome do administrador não pode estar vazio!");
                        caso = 1;
                        break;
                    }

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
                            caso = 5;
                            break;

                        case 2:
                            caso = 3;
                            break;

                        case 3:
                            caso = 4;
                            break;

                        case 4:
                            System.out.println("Obrigado por jogar o MovieGuesser!");

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
                    nome = scanner.nextLine().trim();

                    if (nome.isEmpty()) {
                        System.out.println("O nome do jogador não pode estar vazio!");
                        caso = 3;
                        break;
                    }

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

                    if (!scanner.hasNextInt()) {
                        System.out.println("Digite um ID válido!");
                        scanner.nextLine();
                        caso = 4;
                        break;
                    }

                    id = scanner.nextInt();
                    scanner.nextLine();

                    boolean encontrado = false;

                    for (Jogador jogador : gerenciador.getJogadores()) {
                        if (jogador.getId() == id) {
                            encontrado = true;
                            break;
                        }
                    }

                    if (encontrado) {
                        gerenciador.RemoverJogador(id);
                        System.out.println("Jogador de ID " + id + " removido com sucesso!");
                    } else {
                        System.out.println("Jogador não encontrado!");
                    }

                    caso = 2;
                    break;

                case 5:
                    System.out.println("\n===== CONFIGURAÇÕES DA PARTIDA =====");

                    System.out.println("1 - Configurar partida");
                    System.out.println("2 - Iniciar partida");
                    System.out.println("3 - Voltar ao menu principal");
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
                            System.out.println("Quantidade atual de rodadas: " + configuracao.getQuantidadeRodadas());

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
                                configuracao.setQuantidadeRodadas(quantidade);
                                System.out.println("Configuração salva com sucesso!");
                            }catch(IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }
                            caso = 5;
                            break;

                        case 2:
                            if(executarPartidas()){
                                caso = 6;
                            }else{
                                caso = 5;
                            }
                            break;

                        case 3:
                            caso = 2;
                            break;

                        default:
                            System.out.println("Opção inválida!");
                            caso = 5;
                            break;
                    }
                    break;

                case 6:
                    System.out.println("\n===== FIM DA PARTIDA =====");
                    System.out.println("Jogar novamente?");
                    System.out.println("1 - Sim");
                    System.out.println("2 - Não");
                    System.out.println("Escolha uma opção: ");

                    if(!scanner.hasNextInt()){
                        System.out.println("Opção inválida!");
                        scanner.nextLine();
                        caso = 6;
                        break;
                    }

                    int resposta = scanner.nextInt();
                    scanner.nextLine();

                    switch (resposta){
                        case 1:
                            System.out.println("Voltando às configurações");
                            caso = 5;
                            break;

                        case 2:
                            System.out.println("Encerrando MovieGuesser");
                            caso = 0;
                            break;

                        default:
                            System.out.println("Opção inválida!");
                            caso = 6;
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

    public boolean verificarFimPartida(Partida partida) {
        return !partida.estaAtiva()
                && partida.getRodadas() >= partida.getLimiteRodadas();
    }

    public int proximaTelaAposPartida(Partida partida) {
        if (verificarFimPartida(partida)) {
            return 6;
        }

        return -1;
    }

    private boolean iniciarPartida() {

        if (gerenciador == null) {
            System.out.println("Cadastre um administrador primeiro!");
            return false;
        }

        List<Usuario> participantes = gerenciador.getParticipantes();

        if (gerenciador.getJogadores().isEmpty()) {
            System.out.println("Cadastre pelo menos um jogador antes de iniciar!");
            return false;
        }

        if (participantes.isEmpty() || participantes.size() > 8) {
            System.out.println("A partida precisa ter entre 1 e 8 participantes.");
            return false;
        }

        int quantidadeRodadas = configuracao.getQuantidadeRodadas();

        Partida partida = new Partida(
                proximoIdPartida,
                participantes.size(),
                quantidadeRodadas
        );

        for(Usuario participante : participantes) {
            partida.adicionarJogador(participante);
        }

        try {
            FluxoPartidaService fluxo = new FluxoPartidaService(partida, scanner, placar);

            partida.iniciar();
            placar.iniciarPartida(partida);

            proximoIdPartida++;
            fluxo.executar();
            return verificarFimPartida(partida);

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro ao iniciar ou executar a partida: " + e.getMessage());
            return false;
        }
    }

        private boolean executarPartidas() {
            System.out.println("\n===== INICIANDO JOGO =====");

            boolean concluida = iniciarPartida();

            if(!concluida){
                System.out.println("Não foi possível concluir o jogo");
                return false;
            }

            System.out.println("\nJogo concluído com sucesso!");
            exibirRankingGeral();
            return true;
        }

        private void exibirRankingGeral(){
            System.out.println("\n========== RANKING GERAL ==========");

            var ranking = placar.rankingGeral();

            for(int i = 0; i < ranking.size(); i++){
                var jogador = ranking.get(i);

                System.out.println(
                        (i + 1) + "º lugar - " + jogador.nome()
                                + " | Pontos: " + jogador.pontos()
                );
            }

            System.out.println("\n========== VENCEDOR(ES) ==========");

            List<PlacarService.ResultadoJogador> vencedores = placar.vencedores();

            for(PlacarService.ResultadoJogador vencedor : vencedores){
                System.out.println(
                        vencedor.nome() + " - " + vencedor.pontos() + " pontos!"
                );
            }
        }

}
