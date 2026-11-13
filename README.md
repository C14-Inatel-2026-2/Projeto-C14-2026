# Projeto de Engenharia de Software

## 1. Descrição do Projeto

O projeto consiste no desenvolvimento de um jogo de adivinhação de notas de filmes, no qual os participantes devem tentar estimar a avaliação de diferentes filmes em uma escala de 0 a 10.

Antes do início da partida, os jogadores informam seus nomes e configuram a quantidade de rodadas e participantes. Durante o jogo, o sistema apresenta filmes selecionados aleatoriamente, sem repetições na mesma partida. Cada jogador envia seu palpite e recebe uma pontuação de acordo com a proximidade entre sua estimativa e a nota correta do filme.

Ao final da partida, o sistema apresenta a pontuação dos participantes e gera um pódio com a classificação final dos jogadores. Os resultados são armazenados temporariamente durante a execução da partida e descartados após seu encerramento, sem manter um histórico permanente.

## 2. Tecnologias utilizadas

Java: linguagem de programação utilizada no desenvolvimento da lógica do jogo.

Maven: Ferramenta utilizada para o gerenciamento das dependências e a organização do processo de construção do projeto Java.

Jenkins: Ferramenta utilizada para a criação e execução do pipeline de integração contínua (CI).

Git e GitHub: ferramentas utilizadas para versionamento do código e colaboração entre os integrantes.

Jira: plataforma utilizada para organizar o Product Backlog, planejar as Sprints e acompanhar as histórias de usuário.

Scrum: metodologia ágil adotada para o planejamento e o gerenciamento das atividades do projeto.

## 3. Requisitos Funcionais (RF)

Os requisitos funcionais descrevem as funcionalidades que o sistema deve oferecer.

- **RF01 – Identificação do jogador:** O sistema deve permitir que os participantes informem seus nomes antes do início da partida.
- **RF02 – Configuração da partida:** O sistema deve permitir configurar a quantidade de rodadas e o número de participantes.
- **RF03 – Seleção de filmes:** O sistema deve selecionar filmes aleatoriamente, sem repetir títulos durante a mesma partida.
- **RF04 – Envio de palpites:** O sistema deve permitir que os jogadores informem palpites entre 0 e 10 para cada filme apresentado.
- **RF05 – Validação de palpites:** O sistema deve validar os valores informados, impedindo palpites fora do intervalo permitido.
- **RF06 – Cálculo de pontuação:** O sistema deve calcular a pontuação de cada jogador considerando a diferença entre o palpite e a nota correta do filme.
- **RF07 – Acumulação de pontos:** O sistema deve acumular automaticamente a pontuação dos jogadores ao longo das rodadas.
- **RF08 – Resultado e classificação da partida:** O sistema deve apresentar a pontuação final dos participantes e gerar um pódio com a classificação dos jogadores ao término da partida.
## 3. Requisitos Não Funcionais (RNF)

Os requisitos não funcionais descrevem características de qualidade e restrições que o sistema deve atender.

- **RNF01 – Usabilidade:** O sistema deve apresentar uma interface simples e intuitiva, facilitando a utilização pelos jogadores.
- **RNF02 – Desempenho:** O sistema deve realizar os cálculos de pontuação e atualizar os resultados sem atrasos perceptíveis.
- **RNF03 – Confiabilidade:** O sistema deve garantir que os palpites e as pontuações sejam processados corretamente.
- **RNF04 – Integridade dos dados:** O sistema deve garantir que os palpites e as pontuações dos participantes sejam armazenados e processados corretamente durante a execução da partida.
- **RNF05 – Compatibilidade:** O sistema deve funcionar adequadamente no ambiente e nas plataformas definidos para sua implementação.
- **RNF06 – Manutenibilidade:** O código deve ser organizado e estruturado de forma a facilitar futuras correções e melhorias.

## Planejamento e Gerenciamento — Scrum 

O planejamento e o acompanhamento das atividades do projeto Movie Guesser são realizados utilizando a metodologia ágil Scrum, no Jira.

### US-01 - Cadastro e Gerenciamento de Jogadores

**Responsável:** João Selim 

**História de usuário:** Como jogador, quero me cadastrar e adicionar outros participantes, para que todos possam participar do jogo e um administrador possa gerenciar as configurações.

**Descrição das funcionalidades:** 

Permitir que o jogador se cadastre e, sendo o primeiro cadastrado, seja identificado como administrador. O administrador poderá adicionar outros jogadores pelo botão “+”, e cada jogador terá um ID único. Os jogadores cadastrados ficarão disponíveis durante as partidas.

**Critérios de aceite:**
1. O sistema deve permitir o cadastro inicial de um jogador.
2. O primeiro jogador cadastrado deve ser identificado como administrador.
3. O administrador deve conseguir adicionar outros jogadores pelo botão "+".
4. Cada jogador deve possuir um identificador único.
5. Os jogadores cadastrados devem estar disponíveis durante as partidas.

Subtarefas técnicas:
1. Implementar o cadastro inicial.
2. Implementar a identificação do administrador.
3. Implementar a adição de novos jogadores.
4. Implementar a geração dos IDs.
5. Criar testes unitários.
6. Realizar commits incrementais.
7. Executar e validar o pipeline do Jenkins.

### US-02 — Configuração da partida e rodízio de jogadores

**Responsável:** Ana Clara

**História de usuário:**

Como administrador, quero configurar a quantidade de rodadas e iniciar o jogo, para controlar sua duração e garantir que os jogadores participem em uma ordem organizada.

**Descrição da funcionalidade:**

Permitir que o administrador defina a quantidade de rodadas e inicie o jogo por meio de um switch. A cada nova rodada, a ordem dos jogadores será rotacionada uma posição para a direita, com base nos IDs, e o jogo será finalizado ao atingir o número de rodadas configurado.

**Critérios de aceite:**
1. O administrador deve conseguir definir a quantidade de rodadas.
2. O sistema deve permitir iniciar o jogo por meio de um switch.
3. A quantidade de rodadas configurada deve ser respeitada.
4. A ordem dos jogadores deve ser alterada a cada nova rodada.
5. O rodízio deve deslocar a ordem dos jogadores uma posição para a direita, utilizando seus IDs.
6. Ao atingir a quantidade de rodadas configurada, o jogo deve ser finalizado.

Subtarefas técnicas:
1. Implementar a tela de configurações.
2. Implementar a seleção da quantidade de rodadas.
3. Implementar o switch de início.
4. Implementar o controle de rodadas.
5. Implementar o algoritmo de rodízio.
6. Criar testes unitários.
7. Realizar commits incrementais.
8. Executar e validar o pipeline do Jenkins.

### US-03 - Selecionar filmes aleatoriamente sem repetição

**Responsável:** Giovanna Cabral

**História de usuário:** 

Como jogador, quero receber um filme selecionado aleatoriamente a cada rodada, sem que haja repetições na mesma partida, para ter uma experiência variada durante o jogo.

**Descrição da funcionalidade:**

Permitir que os jogadores possam jogar diferentes rodadas da partida sem com que o filme sorteado seja algum que já tenha sido sorteado em rodadas anteriores, mantendo o ritmo do jogo mais fluido e coerente.

**Critérios de Aceite:**
1. Ao iniciar uma rodada, o sistema deverá selecionar um filme aleatoriamente.
2. Cada rodada deverá apresentar apenas um filme.
3. Um filme já apresentado não poderá aparecer novamente durante a mesma partida.
4. Ao finalizar as rodadas, o jogador deverá ter recebido um número de filmes diferentes referente ao número de rodadas jogadas.
5. Criar testes unitários
6. Realizar commits incrementais
7. Executar e validar o pipeline do Jenkins

### US-04 — Execução da partida e envio de palpites

**Responsável:** Giovanna Cabral

**História de usuário:** 

Como jogador, quero visualizar as perguntas sobre os filmes e registrar meus palpites, para participar das rodadas e receber uma pontuação de acordo com minhas respostas.

**Descrição da funcionalidade:**

Permitir que o jogador visualize o filme da sua vez e registre palpites sobre nota, ano, gênero e diretor. O sistema apresentará a ordem dos jogadores, registrará os palpites enviados e passará para o próximo jogador, encerrando a rodada quando todos tiverem participado.

**Critérios de aceite:**
1. O sistema deve apresentar a ordem dos jogadores.
2. O sistema deve apresentar o filme correspondente à vez do jogador.
3. O jogador deve conseguir responder às perguntas sobre nota, ano, gênero e diretor.
4. O sistema deve registrar os palpites enviados.
5. Após a participação de um jogador, o sistema deve passar para o próximo.
6. Quando todos tiverem participado, a rodada deve ser encerrada.

Subtarefas técnicas:
1. Implementar a tela de execução da partida.
2. Exibir o jogador atual.
3. Implementar a exibição das perguntas.
4. Implementar o registro dos palpites.
5. Implementar a passagem para o próximo jogador.
6. Encaminhar os palpites para o cálculo de pontuação.
7. Criar testes unitários.
8. Realizar commits incrementais.
9. Executar e validar o pipeline do Jenkins.

### US-05 — Visualizar resultados e ranking dos jogadores

**Responsável:** Vinícius Godoy

**História de usuário:**

Como jogador, quero visualizar o ranking ao final de cada partida e o resultado geral do jogo, para acompanhar minha pontuação e descobrir quem foi o vencedor.

**Descrição da funcionalidade:**

Permitir que o jogador visualize o ranking ao final de cada partida, com o número da partida, os nomes e os pontos dos jogadores. Ao final de todas as partidas, o sistema apresentará o ranking geral com as pontuações acumuladas e identificará o vencedor, mantendo os resultados temporariamente durante o jogo.

A pontuação máxima por rodada será de 100 pontos, e o cálculo deverá garantir que o jogador nunca receba uma pontuação negativa.

**Critérios de aceite:**
1. Ao final de cada partida, o sistema deve apresentar um ranking.
2. O ranking deve exibir o número da partida, os nomes e os pontos dos jogadores.
3. Ao final de todas as partidas, o sistema deve apresentar o ranking geral.
4. O ranking geral deve considerar as pontuações acumuladas.
5. O sistema deve identificar o vencedor.
6. Os resultados devem ser mantidos temporariamente durante o jogo.

Subtarefas técnicas:
1. Implementar o ranking de cada partida.
2. Implementar o acúmulo de pontuação.
3. Implementar o ranking geral.
4. Implementar a identificação do vencedor.
5. Criar testes unitários.
6. Realizar commits incrementais.
7. Executar e validar o pipeline do Jenkins.

**Regra de cálculo da pontuação:**

A pontuação será determinada pela seguinte fórmula:

P = max(0, PM - (|NF - NJ| × 10))

Onde:

- P = Pontuação recebida pelo jogador.
- PM = Pontuação máxima da rodada (100 pontos).
- NF = Nota oficial do filme no IMDb.
- NJ = Nota informada pelo jogador.

A cada 0,1 ponto de diferença entre o palpite e a nota real, será descontado 1 ponto da pontuação máxima.

Os palpites deverão possuir apenas uma casa decimal.

### US-06 — Calcular pontuação dos jogadores

**Responsável:** Vinícius Godoy

**História de usuário:**

Como jogador, quero que meus palpites sejam avaliados de acordo com uma fórmula de pontuação, para receber pontos conforme o desempenho das minhas respostas.

**Descrição da funcionalidade:**
Permitir que os palpites do jogador sejam avaliados por uma fórmula de pontuação definida pela equipe, considerando os critérios de cada pergunta. Os pontos serão associados ao jogador correspondente e disponibilizados para a geração dos rankings.

Os resultados serão mantidos apenas durante a execução da partida, sem armazenamento permanente ou utilização de banco de dados.

**Critérios de aceite:**
1. O sistema deve calcular a pontuação utilizando a fórmula definida pela equipe.
2. A pontuação deve considerar os critérios de avaliação de cada pergunta.
3. Os pontos devem ser associados ao jogador correspondente.
4. Os resultados devem ser disponibilizados para a geração dos rankings.

Subtarefas técnicas:
1. Implementar a fórmula de pontuação definida 
2. Calcular a pontuação dos palpites.
3. Associar os pontos aos respectivos jogadores.
4. Criar testes unitários para os cálculos.
5. Realizar commits incrementais.
6. Executar e validar o pipeline do Jenkins.

### US-07 — Menu inicial e navegação do jogo

**Responsável:** Mayara Cristina

**História de usuário:**

Como jogador, quero acessar um menu inicial e navegar entre as etapas do jogo, para conseguir iniciar uma partida e decidir se desejo jogar novamente após seu encerramento.

**Descrição da funcionalidade:**
Permitir que o jogador acesse um menu inicial e navegue até as configurações para iniciar uma partida. Ao final do jogo, o sistema perguntará “Jogar novamente?”, retornando às configurações em caso de “Sim” e encerrando o fluxo do jogo em caso de “Não”.

**Critérios de aceite:**
1. O sistema deve apresentar um menu inicial.
2. O jogador deve conseguir acessar as configurações.
3. Ao finalizar o jogo, deve aparecer a pergunta "Jogar novamente?".
4. Ao selecionar "Sim", o sistema deve retornar às configurações.
5. Ao selecionar "Não", o sistema deve encerrar o fluxo do jogo.

Subtarefas técnicas:
1. Implementar o menu inicial.
2. Implementar a navegação entre as telas.
3. Implementar a opção de jogar novamente.
4. Criar testes unitários para as funções desenvolvidas.
5. Realizar commits incrementais.
6. Executar e validar o pipeline do Jenkins.
