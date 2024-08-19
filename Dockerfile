FROM openjdk:22
# Definir diretório de trabalho
WORKDIR /app

# Copiar os arquivos do Maven Wrapper e o código-fonte
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY src/ src/

# Garantir que o script mvnw seja executável
RUN chmod +x ./mvnw

# Executar o build da aplicação
RUN ./mvnw clean install -DskipTests

# Expor a porta
EXPOSE 8080

# Definir o comando de inicialização
ENTRYPOINT ["java", "-jar", "target/todolist-0.0.1-SNAPSHOT.jar"]