FROM openjdk:22
COPY . .
RUN ./mvnw clean install -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/todolist-0.0.1-SNAPSHOT.jar"]