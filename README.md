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

- **Product Owner:** [informar integrante e como foi definido].
- **Scrum Master:** [informar integrante e como foi definido].
- **Equipe de desenvolvimento:** [informar integrantes].

A definição desses papéis ocorreu por meio de [explicar como o grupo decidiu].

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

[Confirmar quais critérios foram realmente utilizados pelo grupo.]

Critérios a verificar:

- História de usuário descrita e compreendida pela equipe.
- Funcionalidade e critérios de aceitação definidos.
- Responsável pela implementação identificado.
- Dependências e dúvidas principais discutidas.

### Definition of Done (DoD) — Definição de pronto

[Confirmar quais critérios foram realmente utilizados pelo grupo.]

Critérios a verificar:

- Funcionalidade implementada conforme os critérios de aceitação.
- Código versionado no GitHub.
- Testes automatizados executados.
- Pull request revisado e integrado à branch principal.
- Status da história atualizado no Jira.

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

O pipeline Jenkins inclui etapas de compilação, testes JUnit, relatório JaCoCo, empacotamento e cópia do JAR para o diretório de deploy.

**Evidências a anexar/linkar:** URL do build Jenkins; relatórios JUnit; relatório JaCoCo arquivado; artefato JAR; captura da execução completa; 
histórico de jobs e autoria dos jobs por integrante. O PDF exige **pelo menos um job por integrante, comitado pelo próprio** — conferir essa exigência
no Jenkinsfile e no histórico Git.

## 10. Uso de IA

Foi utilizado **ChatGPT (OpenAI)** como apoio individual em tarefas de desenvolvimento e documentação do MovieGuesser, incluindo orientação sobre código Java, interpretação de logs Maven/Jenkins, fluxo Git e revisão de requisitos. 
Os exemplos abaixo são prompts reais desta interação;

| Exemplo de prompt real | Uso da resposta | Decisão registrada |
|---|---|---|

**Dinâmica de uso:** apoio conversacional individual, com validação das sugestões por leitura de código, testes e execução do jogo; as respostas não foram adotadas automaticamente. **Trabalho humano confirmado nesta interação:** operação do Git/GitHub, execução de pipelines, inspeção dos resultados e teste manual do fluxo individual. A autoria das demais implementações e dos testes deve ser verificada no histórico de commits; não é possível afirmar que todo o código restante foi produzido sem IA.

**Exemplo de orientação que não deve ser adotada sem revisão:** remover um teste que falha apenas para obter pipeline verde não comprova a correção do comportamento testado. O grupo deve manter testes relevantes e revisar eventuais lacunas de cobertura.