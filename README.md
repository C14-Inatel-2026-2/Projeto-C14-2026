# Projeto de Engenharia de Software

## 1. Descrição do Projeto

O projeto MovieGuesser, consiste no desenvolvimento de um jogo de adivinhação de notas de filmes, no qual os participantes devem tentar estimar a avaliação de diferentes filmes em uma escala de 0 a 10.

Antes do início da partida, os jogadores informam seus nomes e configuram a quantidade de rodadas e participantes. Durante o jogo, o sistema apresenta filmes selecionados aleatoriamente, sem repetições na mesma partida. Cada jogador envia seu palpite e recebe uma pontuação de acordo com a proximidade entre sua estimativa e a nota correta do filme.

Ao final da partida, o sistema apresenta a pontuação dos participantes e gera um pódio com a classificação final dos jogadores. Os resultados são armazenados temporariamente durante a execução da partida e descartados após seu encerramento, sem manter um histórico permanente.

## 2. Tecnologias utilizadas

Java: linguagem de programação utilizada no desenvolvimento da lógica do jogo.

Maven: Ferramenta utilizada para o gerenciamento das dependências e a organização do processo de construção do projeto Java.

Jenkins: Ferramenta utilizada para a criação e execução do pipeline de integração contínua (CI).

JUnit : Ferramenta para construção e testes.
Jacoco: Ferramenta para cobertura de teste.

Git e GitHub: ferramentas utilizadas para versionamento do código e colaboração entre os integrantes.

Jira: plataforma utilizada para organizar o Product Backlog, planejar as Sprints e acompanhar as histórias de usuário.

Scrum: metodologia ágil adotada para o planejamento e o gerenciamento das atividades do projeto.

Render: Ferramenta para deploy na nuvem.


## 3. Instalação e execução

### 3.1. Pré-requisitos

Para executar o projeto localmente, é necessário ter instalado:

- Java JDK 17 ou versão compatível.
- Apache Maven.
- Git para clonar o repositório.

Verifique a instalação do Java e do Maven:

```powershell
java -version
mvn -version
```

### 3.2. Instalação e execução local

Clone o repositório e acesse a pasta do projeto:

```powershell
git clone https://github.com/viniciusbg18/Projeto-C14-2026.git
cd Projeto-C14-2026
```

Compile o projeto, execute os testes automatizados e gere o arquivo JAR:

```powershell
mvn clean package
```

Execute o MovieGuesser pelo terminal:

```powershell
java -jar target/MovieGuesser-1.0-SNAPSHOT.jar
```

O jogo será iniciado no terminal, permitindo o cadastro do administrador, a configuração das rodadas e a participação dos jogadores.

### 3.3. Deploy na nuvem — Render

O projeto possui um serviço publicado na plataforma **Render**, integrado ao processo de entrega da aplicação.

**Link do deploy:**

https://movieguesser-bpnf.onrender.com/

O deploy disponibiliza o serviço em um ambiente remoto. Como o MovieGuesser utiliza uma interface de terminal, a execução interativa do jogo está documentada na seção de execução local.

### 3.4. Integração contínua — Jenkins

O projeto:

- Compilação do código Java.
- Execução dos testes unitários automatizados.
- Geração de relatórios de testes e cobertura de código.
- Empacotamento da aplicação em um arquivo JAR.
- Execução das etapas de deploy e integração com o ambiente de nuvem.

Esse processo contribui para identificar possíveis falhas, verificar a qualidade do código e facilitar a entrega de novas versões do MovieGuesser.


## 4. Como jogar

1. Inicie o programa e informe o nome do administrador, que será também o primeiro participante.
2. No menu inicial, escolha **Jogar**. Se desejar, antes disso use **Adicionar jogador** para incluir outras pessoas; o cadastro adicional é opcional.
3. Nas configurações, defina a quantidade de rodadas (de **1 a 10**) e selecione **Iniciar partida**.
4. Observe o filme e as dicas exibidas (ano, gênero e diretor). Digite um palpite para a **nota do IMDb**, entre **0 e 10**; o terminal também aceita vírgula como separador decimal.
5. Cada participante joga na sua vez. A rodada termina depois que todos tiverem enviado o palpite; o jogo continua até atingir o limite configurado.
6. Consulte a pontuação e o resultado ao término, conforme o fluxo de classificação implementado.


## 5. Requisitos Funcionais (RF)

Os requisitos funcionais descrevem as funcionalidades que o sistema deve oferecer.

- **RF01 – Identificação do jogador:** O sistema deve permitir que os participantes informem seus nomes antes do início da partida.
- **RF02 – Configuração da partida:** O sistema deve permitir configurar a quantidade de rodadas e o número de participantes.
- **RF03 – Seleção de filmes:** O sistema deve selecionar filmes aleatoriamente, sem repetir títulos durante a mesma partida.
- **RF04 – Envio de palpites:** O sistema deve permitir que os jogadores informem palpites entre 0 e 10 para cada filme apresentado.
- **RF05 – Validação de palpites:** O sistema deve validar os valores informados, impedindo palpites fora do intervalo permitido.
- **RF06 – Cálculo de pontuação:** O sistema deve calcular a pontuação de cada jogador considerando a diferença entre o palpite e a nota correta do filme.
- **RF07 – Acumulação de pontos:** O sistema deve acumular automaticamente a pontuação dos jogadores ao longo das rodadas.
- **RF08 – Resultado e classificação da partida:** O sistema deve apresentar a pontuação final dos participantes e gerar um pódio com a classificação dos jogadores ao término da partida.

## 6. Requisitos Não Funcionais (RNF)

Os requisitos não funcionais descrevem características de qualidade e restrições que o sistema deve atender.

- **RNF01 – Usabilidade:** O sistema deve apresentar uma interface simples e intuitiva, facilitando a utilização pelos jogadores.
- **RNF02 – Desempenho:** O sistema deve realizar os cálculos de pontuação e atualizar os resultados sem atrasos perceptíveis.
- **RNF03 – Confiabilidade:** O sistema deve garantir que os palpites e as pontuações sejam processados corretamente.
- **RNF04 – Integridade dos dados:** O sistema deve garantir que os palpites e as pontuações dos participantes sejam armazenados e processados corretamente durante a execução da partida.
- **RNF05 – Compatibilidade:** O sistema deve funcionar adequadamente no ambiente e nas plataformas definidos para sua implementação.
- **RNF06 – Manutenibilidade:** O código deve ser organizado e estruturado de forma a facilitar futuras correções e melhorias.

## 7. Metodologia de desenvolvimento e Gerenciamento

O projeto declara o uso de **Scrum**, com histórias e tarefas acompanhadas no **Jira**, versionamento no **GitHub**, revisão por **Pull Requests** e integração contínua no **Jenkins**.

**Distribuição técnica documentada:** João Selim (cadastro), Ana Clara (configuração e rodízio), Giovanna Cabral (sorteio e execução), 
Vinícius Godoy (pontuação e ranking) e Mayara Cristina (menu e navegação). Essa divisão descreve responsabilidades das histórias e **não substitui** o registro dos papéis Scrum 
(PO, facilitador, QA etc.).

**Papéis Scrum exercidos:**

- **Product Owner:** Giovanna Cabral
- **Scrum Master:** Vinícius Godoy 
- **Equipe de desenvolvimento:** Giovanna, Vinícius, Mayara, João e Ana.

### Organização das sprints e reuniões

O desenvolvimento foi organizado em sprints acompanhadas pelo backlog do Jira.

**Sprint 1 — Estrutura do jogo**

- **Início:** 02/11/2026.
- **Término planejado:** 13/11/2026.
- **Quantidade de histórias cadastradas:** 7.
- **Objetivo:** permitir a identificação dos jogadores, a configuração da partida e a seleção aleatória de filmes sem repetição.

**Reuniões e acompanhamento:**

- **Frequência:** [informar frequência real].
- **Formato:** [presencial, online ou híbrido].
- **Atividades:** [descrever como o grupo acompanhava o progresso, discutia dificuldades e distribuía tarefas].


### Definition of Ready (DoR) — Definição de preparado

Embora o grupo não utilizasse formalmente o termo Definition of Ready (DoR), as tarefas eram iniciadas quando as informações necessárias para o desenvolvimento estavam definidas e compreendidas pelos integrantes.

Na prática, os critérios utilizados eram:

- A história de usuário deveria estar descrita e compreendida pela equipe.
- A funcionalidade e os critérios de aceitação deveriam estar definidos.
- O responsável pela implementação deveria estar identificado.
- As principais dúvidas e dependências deveriam ser discutidas antes do início do desenvolvimento.

Esses critérios ajudavam a equipe a compreender o que precisava ser desenvolvido e a organizar a distribuição das atividades.

### Definition of Done (DoD) — Definição de pronto

O grupo considerava uma tarefa concluída após a implementação da funcionalidade, a execução dos testes e a abertura de um Pull Request no GitHub.

Na prática, os critérios utilizados eram:

- A funcionalidade deveria estar implementada conforme os requisitos definidos.
- O código deveria estar versionado na branch do integrante responsável.
- Os testes automatizados deveriam ser executados para verificar o funcionamento da implementação.
- Um Pull Request deveria ser aberto no GitHub com as alterações realizadas.

Dessa forma, a equipe utilizava os testes e os Pull Requests como principais critérios para considerar uma tarefa concluída, contribuindo para a organização e o acompanhamento do desenvolvimento.

## 8. Histórias de usuário

### US-01 — Cadastro e gerenciamento de jogadores

**Responsável:** João Selim

**História de usuário:** Como jogador, quero me cadastrar e adicionar outros participantes, para que todos possam participar e um administrador gerencie as configurações.

**Descrição das funcionalidades:**

O primeiro cadastro cria o administrador (ID único), que também participa da partida; novos jogadores recebem IDs próprios e ficam disponíveis para jogar. No terminal, a adição ocorre por uma opção do menu, e não por botão gráfico `+`.

**Critérios de aceitação:**

1. O sistema deve permitir o cadastro inicial de um jogador.
2. O primeiro jogador cadastrado deve ser identificado como administrador.
3. O administrador deve conseguir adicionar outros jogadores pelo botão "+".
4. Cada jogador deve possuir um identificador único.
5. Os jogadores cadastrados devem estar disponíveis durante as partidas.

**Subtarefas técnicas:**

1. Implementar o cadastro inicial.
2. Implementar a identificação do administrador.
3. Implementar a adição de novos jogadores.
4. Implementar a geração dos IDs.
5. Criar testes unitários.
6. Realizar commits incrementais.
7. Executar e validar o pipeline do Jenkins.

---

### US-02 — Configuração e rodízio de jogadores

**Responsável:** Ana Clara

**História de usuário:** Como administrador, quero definir a quantidade de rodadas e iniciar a partida, para controlar sua duração e a ordem de participação.

**Descrição das funcionalidades:**

Configurar de 1 a 10 rodadas; iniciar por uma opção numérica do menu; respeitar o limite e encerrar ao final.

**Pendente de conferência no fluxo completo:** rotação da ordem dos participantes uma posição à direita entre rodadas, conforme a história original.

**Critérios de aceitação:**

1. O administrador deve conseguir definir a quantidade de rodadas.
2. O sistema deve permitir iniciar o jogo por meio de um switch.
3. A quantidade de rodadas configurada deve ser respeitada.
4. A ordem dos jogadores deve ser alterada a cada nova rodada.
5. O rodízio deve deslocar a ordem dos jogadores uma posição para a direita, utilizando seus IDs.
6. Ao atingir a quantidade de rodadas configurada, o jogo deve ser finalizado.

**Subtarefas técnicas:**

1. Implementar a tela de configurações.
2. Implementar a seleção da quantidade de rodadas.
3. Implementar o switch de início.
4. Implementar o controle de rodadas.
5. Implementar o algoritmo de rodízio.
6. Criar testes unitários.
7. Realizar commits incrementais.
8. Executar e validar o pipeline do Jenkins.

---

### US-03 — Sorteio de filmes sem repetição

**Responsável:** Giovanna Cabral

**História de usuário:** Como jogador, quero receber um filme aleatório em cada rodada, sem repetição durante a mesma partida, para ter uma experiência variada.

**Descrição das funcionalidades:**

Sortear um filme por rodada, não repetir filmes na partida e apresentar tantos filmes distintos quantas forem as rodadas realizadas.

**Critérios de aceitação:**

1. Ao iniciar uma rodada, o sistema deverá selecionar um filme aleatoriamente.
2. Cada rodada deverá apresentar apenas um filme.
3. Um filme já apresentado não poderá aparecer novamente durante a mesma partida.
4. Ao finalizar as cinco rodadas, o jogador deverá ter recebido cinco filmes diferentes.


**Subtarefas técnicas:**

1. Implementar o serviço de sorteio aleatório de filmes (`SorteioService`).
2. Implementar o controle dos filmes já sorteados durante a partida.
3. Garantir que um filme não seja selecionado novamente na mesma partida.
4. Integrar o sorteio de filmes à execução das rodadas.
5. Garantir que cada rodada utilize apenas um filme sorteado.
6. Criar testes unitários para validar a seleção aleatória e a ausência de repetições.
7. Realizar commits incrementais das funcionalidades desenvolvidas.
8. Executar e validar os testes no pipeline do Jenkins.

---

### US-04 — Execução da partida e envio de palpites

**Responsável:** Giovanna Cabral

**História de usuário:** Como jogador, quero visualizar o filme e registrar meu palpite sobre sua nota, para participar das rodadas e receber pontos.

**Descrição das funcionalidades:**

Apresentar jogador atual, filme e dicas (ano, gênero, diretor); receber um palpite de nota IMDb de 0 a 10; registrar o palpite, avançar para o próximo participante e encerrar a rodada somente depois de todos participarem.

Ano, gênero e diretor não são perguntas a responder na implementação atual.

**Critérios de aceitação:**

1. O sistema deve apresentar a ordem dos jogadores.
2. O sistema deve apresentar o filme correspondente à vez do jogador.
3. O jogador deve conseguir responder às perguntas sobre nota, ano, gênero e diretor.
4. O sistema deve registrar os palpites enviados.
5. Após a participação de um jogador, o sistema deve passar para o próximo.
6. Quando todos tiverem participado, a rodada deve ser encerrada.

**Subtarefas técnicas:**

1. Implementar a tela de execução da partida.
2. Exibir o jogador atual.
3. Implementar a exibição das perguntas.
4. Implementar o registro dos palpites.
5. Implementar a passagem para o próximo jogador.
6. Encaminhar os palpites para o cálculo de pontuação.
7. Criar testes unitários.
8. Realizar commits incrementais.
9. Executar e validar o pipeline do Jenkins.

---

### US-05 — Visualização de resultados e ranking

**Responsável:** Vinícius Godoy

**História de usuário:** Como jogador, quero consultar a classificação final e descobrir quem venceu, para acompanhar o desempenho dos participantes.

**Descrição das funcionalidades:**

Mostrar nomes e pontuações, classificação e vencedor; manter os resultados temporariamente durante o jogo.

**Pendente de conferência no fluxo completo:** verificar se o ranking por partida e o ranking geral descritos na história original correspondem ao fluxo atual.

**Critérios de aceitação:**

1. Ao final de cada partida, o sistema deve apresentar um ranking.
2. O ranking deve exibir o número da partida, os nomes e os pontos dos jogadores.
3. Ao final de todas as partidas, o sistema deve apresentar o ranking geral.
4. O ranking geral deve considerar as pontuações acumuladas.
5. O sistema deve identificar o vencedor.
6. Os resultados devem ser mantidos temporariamente durante o jogo.

**Subtarefas técnicas:**

1. Implementar o ranking de cada partida.
2. Implementar o acúmulo de pontuação.
3. Implementar o ranking geral.
4. Implementar a identificação do vencedor.
5. Criar testes unitários.
6. Realizar commits incrementais.
7. Executar e validar o pipeline do Jenkins.

---

### US-06 — Cálculo de pontuação

**Responsável:** Vinícius Godoy

**História de usuário:** Como jogador, quero receber pontos conforme a proximidade entre meu palpite e a nota do filme, para avaliar meu desempenho.

**Descrição das funcionalidades:**

Aplicar a fórmula documentada, impedir pontuação negativa, associar os pontos ao participante correto e disponibilizá-los para o ranking.

Na implementação atual, o cálculo considera o palpite da nota, não respostas separadas sobre ano, gênero e diretor.

**Critérios de aceitação:**

1. O sistema deve calcular a pontuação utilizando a fórmula definida pela equipe.
2. A pontuação deve considerar os critérios de avaliação de cada pergunta.
3. Os pontos devem ser associados ao jogador correspondente.
4. Os resultados devem ser disponibilizados para a geração dos rankings.

**Subtarefas técnicas:**

1. Implementar a fórmula de pontuação definida pelo Selim.
2. Calcular a pontuação dos palpites.
3. Associar os pontos aos respectivos jogadores.
4. Criar testes unitários para os cálculos.
5. Realizar commits incrementais.
6. Executar e validar o pipeline do Jenkins.

---

### US-07 — Menu inicial e navegação

**Responsável:** Mayara Cristina

**História de usuário:** Como jogador, quero navegar entre o menu e as configurações e decidir se jogo novamente, para controlar a experiência.

**Descrição das funcionalidades:**

Mostrar menu inicial, acessar configurações, iniciar partida e oferecer o fluxo de nova partida ou encerramento.

**Pendente de conferência no fluxo completo:** confirmar o comportamento de "Jogar novamente?".

**Critérios de aceitação:**

1. O sistema deve apresentar um menu inicial.
2. O jogador deve conseguir acessar as configurações.
3. Ao finalizar o jogo, deve aparecer a pergunta "Jogar novamente?".
4. Ao selecionar "Sim", o sistema deve retornar às configurações.
5. Ao selecionar "Não", o sistema deve encerrar o fluxo do jogo.

**Subtarefas técnicas:**

1. Implementar o menu inicial.
2. Implementar a navegação entre as telas.
3. Implementar a opção de jogar novamente.
4. Criar testes unitários para as funções desenvolvidas.
5. Realizar commits incrementais.
6. Executar e validar o pipeline do Jenkins.


## 9. Integração contínua, testes e relatórios


## 9.1 Integração Contínua e Entrega Contínua (CI/CD)

Tendo como objetivo manter a qualidade, a confiabilidade e a integridade do código, nosso projeto utiliza as práticas de **Integração Contínua (CI)** e **Entrega Contínua (CD)**, por meio da ferramenta **Jenkins**, integrada ao nosso repositório no GitHub.

Nosso processo automatizado contempla a compilação do projeto, execução dos testes, geração do relatório de cobertura, empacotamento da aplicação e etapas de deploy.

### 9.2. Integração Contínua

A integração contínua do MovieGuesser foi estruturada utilizando as seguintes ferramentas:

- **GitHub:** armazenamento, versionamento e integração do código desenvolvido pelos integrantes.
- **Jenkins:** gerenciamento e execução das etapas automatizadas do pipeline.
- **Apache Maven:** gerenciamento das dependências, compilação, execução dos testes e empacotamento.
- **Render:** plataforma de hospedagem utilizada na etapa de deploy em nuvem.

O Jenkins utiliza um arquivo chamado `Jenkinsfile`, localizado na raiz do repositório, que define as etapas necessárias para construir, testar e preparar a aplicação para distribuição.

O objetivo dessa integração é permitir que alterações realizadas no código sejam verificadas de maneira padronizada, reduzindo a necessidade de executar manualmente todas as operações de compilação e testes.

### 9.3. Estrutura do Pipeline Jenkins

O pipeline foi desenvolvido e dividido em **seis etapas**, cada uma responsável por uma atividade do processo de integração e entrega.

#### 1. Build

A primeira etapa é responsável pela compilação do projeto Java utilizando o Maven.

#### 2. Testes JUnit

Após a compilação, o Jenkins executa os testes automatizados existentes no projeto.

Os resultados são coletados a partir dos arquivos XML produzidos pelo **Maven Surefire**, permitindo visualizar quais testes foram executados e identificar eventuais falhas.

#### 3. Code Coverage

A etapa de cobertura utiliza o plugin **JaCoCo** para gerar relatórios sobre a quantidade de código exercitada durante a execução dos testes.

Os relatórios são arquivados como artefatos do Jenkins, possibilitando a consulta posterior dos resultados.

#### 4. Package

Com a execução das etapas anteriores, o Maven realiza o empacotamento da aplicação.

O processo gera o arquivo `MovieGuesser-1.0-SNAPSHOT.jar`, que contém a aplicação compilada e suas dependências necessárias.

#### 5. Deploy

Nesta etapa, o arquivo JAR gerado é copiado para o diretório de distribuição do Jenkins.

Essa operação organiza e disponibiliza o artefato para utilização posterior.

#### 6. Deploy Render

A última etapa realiza a integração com a plataforma **Render**, acionando um *deploy hook* por meio de uma requisição HTTP.

A URL do hook é obtida por meio de uma credencial configurada no Jenkins, identificada como `render-deploy-hook`, evitando a exposição dessa informação diretamente no código-fonte.

As etapas de **Deploy** e **Deploy Render** possuem uma condição no `Jenkinsfile` para execução apenas quando `GIT_BRANCH` corresponde a `origin/main`.


## 10. Uso de IA

Foi utilizado **ChatGPT (OpenAI)** como apoio individual em tarefas de desenvolvimento e documentação do MovieGuesser, incluindo orientação sobre código Java, interpretação de logs Maven/Jenkins, fluxo Git e revisão de requisitos. 
Os exemplos abaixo são prompts reais desta interação;

| Exemplo de prompt real :

Giovanna : "O chat é o seguinte, rodei pipeline e funcionou de novo. Como é aquele comando que eu dou no CMD lá pra funcionar?"

Vinícius: "Por agora faremos outra mudança em relação as partidas, a imagem em anexo se trata do arquivo do jogo em funcionamento, 
fizemos essa captura ontem a noite antes do estado atual do código. Se vc conseguir testar e rodar o código atual para ver se ainda está rodando 
com a mesma tela da imagem, confira, se não for possível tudo bem também, podemos fazer a análise pelo código"

Mayara: "Estou desenvolvendo um projeto em Java chamado MovieGuesser para a disciplina C14 de Engenharia de Software. Sou responsável pela US-07, que envolve a implementação do 
menu inicial, navegação entre funcionalidades, configuração de partidas e opção de jogar novamente. Considerando as boas práticas de Engenharia de Software, analise meu código e me ajude a identificar possíveis melhorias na organização, legibilidade, tratamento de exceções e integração com as classes desenvolvidas pelos demais integrantes. Além disso, verifique se meus testes unitários com JUnit cobrem adequadamente os critérios de aceitação da história de usuário, explique eventuais erros de compilação ou execução e me oriente na utilização do Git, Maven e Jenkins para garantir a qualidade e a integração contínua do projeto. 
Priorize explicações passo a passo, preservando as funcionalidades existentes e justificando cada alteração proposta."

Ana: "Chat, estou trabalhando na implementação de uma funcionalidade do nosso projeto em Java e já tenho uma estrutura inicial das classes. Estou com dificuldade em desenvolver a parte 
responsável pelo cadastro e gerenciamento dos jogadores. Pode me ajudar a pensar em como implementar essa funcionalidade, sugerindo métodos e ajustes nas classes que já existem? Quero entender como encaixar essa implementação na estrutura atual do projeto, mantendo a organização e os
princípios de orientação a objetos. Se possível, explique o motivo das alterações e apresente exemplos de código."


João:


**Dinâmica de uso:** apoio conversacional individual, com validação das sugestões por leitura de código, testes e execução do jogo; as respostas não foram adotadas automaticamente. **Trabalho humano confirmado nesta interação:** 
operação do Git/GitHub, execução de pipelines, inspeção dos resultados e teste manual do fluxo individual. 

## Desenvolvimento realizado sem o auxílio de Inteligência Artificial

Durante o desenvolvimento do **MovieGuesser**, diversas etapas foram realizadas de forma autônoma pela equipe, utilizando os conhecimentos adquiridos ao longo da disciplina de Engenharia de Software.

A **idealização do jogo foi inteiramente desenvolvida pelos integrantes**, sem a utilização de inteligência artificial para pesquisar ou definir sua proposta. A equipe foi responsável por elaborar o conceito do MovieGuesser, estabelecer suas regras, definir a dinâmica das partidas e planejar as funcionalidades necessárias para seu funcionamento.

As principais decisões conceituais e arquiteturais também foram tomadas pelos integrantes, incluindo a organização do projeto, a divisão das responsabilidades entre as classes e a aplicação dos princípios de Programação Orientada a Objetos. A estruturação do código foi planejada para separar as responsabilidades e facilitar a manutenção, a integração e a evolução das funcionalidades.

Além disso, a equipe participou diretamente da elaboração das primeiras classes do sistema, como `Rodada.java`, `Partida.java`, `Filmes.java` e `Jogador.java`, definindo seus atributos, comportamentos e relacionamentos com base nas necessidades identificadas durante o planejamento do jogo.

Outro aspecto desenvolvido pela equipe foi a **organização das entregas e das etapas de implementação**, incluindo a definição das funcionalidades, a distribuição das tarefas entre os integrantes e as decisões relacionadas à apresentação e à disponibilização do projeto.

Dessa forma, embora ferramentas de inteligência artificial tenham sido utilizadas como apoio em determinadas atividades de desenvolvimento, **a concepção do MovieGuesser, as decisões fundamentais de Engenharia de Software e o planejamento de sua estrutura foram realizados pela própria equipe**, com base em discussões, conhecimentos técnicos e decisões coletivas.
