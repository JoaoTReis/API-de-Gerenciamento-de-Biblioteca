# Etapa 1: Build usando Maven com Java 17
FROM maven:3.8.8-eclipse-temurin-17 AS builder

WORKDIR /app

# Definindo as variáveis de ambiente para o Docker
ENV DATABASE_URL=jdbc:postgresql://api_gerenciamento_biblioteca_user:C06NWMwyTHNJUC7UbZKFBkkQPJj600eS@dpg-cuj8ufaj1k6c73cpejgg-a.oregon-postgres.render.com/api_gerenciamento_biblioteca
ENV DATABASE_USERNAME=api_gerenciamento_biblioteca_user
ENV DATABASE_PASSWORD=C06NWMwyTHNJUC7UbZKFBkkQPJj600eS

# Copia o projeto para o contêiner
COPY . .

# Compila a aplicação e gera o JAR
RUN mvn clean package -DskipTests

# Etapa 2: Apenas o runtime da aplicação
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copia o JAR gerado da etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Exponha a porta do serviço
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
