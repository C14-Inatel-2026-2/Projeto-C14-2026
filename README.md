# Projeto de Engenharia de Software

Desenvolvimento de um software em Java, com utilização de dependências, desenvolvimento de testes
e outras features.

## Planejamento e Gerenciamento — Scrum (Jira)

O planejamento e o acompanhamento das atividades do projeto Movie Guesser são realizados utilizando a metodologia ágil Scrum, no Jira.

### US-06 — Gerenciar resultados e gerar pódio da partida

**Responsável:** Ana

**Título:** Gerenciar resultados e gerar pódio da partida.

**História de usuário:**
Como jogador, quero que as pontuações de todos os participantes sejam acumuladas durante a partida e que, ao final, seja apresentado um pódio com a classificação dos jogadores, para comparar seus desempenhos.

**Descrição da funcionalidade:**
Gerenciamento temporário dos resultados dos participantes durante uma partida, permitindo acumular as pontuações individuais e apresentar a classificação final após a conclusão de todas as rodadas.
Os resultados serão mantidos apenas durante a execução da partida, sem armazenamento permanente ou utilização de banco de dados.

**Critérios de aceite:**

1. Armazenar temporariamente os palpites e as pontuações de cada participante durante a partida.
2. Acumular individualmente os pontos obtidos em cada rodada.
3. Calcular a pontuação total de todos os participantes ao final da partida.
4. Ordenar os participantes conforme suas pontuações, da maior para a menor.
5. Apresentar o pódio final com a classificação dos jogadores.
6. Descartar os dados temporários após o encerramento da partida, sem manter histórico permanente.

