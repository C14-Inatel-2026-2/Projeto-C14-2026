# Etapa 1: compilar e empacotar o MovieGuesser com o Maven.
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /build
COPY pom.xml ./
COPY src ./src
RUN mvn -B -DskipTests package

# Etapa 2: executar o jogo em um terminal acessivel pelo navegador.
FROM eclipse-temurin:21-jre-noble

# ttyd serve o terminal via HTTP/WebSocket; tini gerencia sinais/processos.
RUN apt-get update \
    && apt-get install -y --no-install-recommends ttyd tini \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app
RUN useradd --uid 10001 --create-home --shell /usr/sbin/nologin movieguesser \
    && chown movieguesser:movieguesser /app

# O Maven Shade Plugin deve produzir o JAR executavel com esse nome.
COPY --from=build --chown=movieguesser:movieguesser \
    /build/target/MovieGuesser-1.0-SNAPSHOT.jar /app/MovieGuesser.jar

USER movieguesser

# Porta padrao dos Web Services do Render.
ENV PORT=10000
EXPOSE 10000

ENTRYPOINT ["tini", "--"]
# -W permite digitar; -O valida a origem WebSocket.
# O terminal executa apenas o jogo (nao oferece um shell Linux).
CMD ["sh", "-c", "exec ttyd -W -O -i 0.0.0.0 -p \"${PORT:-10000}\" java -jar /app/MovieGuesser.jar"]
