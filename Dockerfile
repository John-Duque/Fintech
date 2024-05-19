# Etapa 1: Construção
FROM maven:3.8.5-openjdk-17 AS build

# Defina o diretório de trabalho na etapa de build
WORKDIR /app

# Copie o arquivo pom.xml e as dependências do projeto
COPY pom.xml .
COPY src ./src

# Execute o comando de build para construir o JAR da aplicação
RUN mvn clean package -DskipTests

# Etapa 2: Execução
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho na etapa de execução
WORKDIR /app

# Copie o JAR construído da etapa anterior para um diretório temporário
COPY --from=build /app/target/*.jar /app/app.jar

# Exponha a porta 8080
EXPOSE 8080

# Comando de entrada para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
