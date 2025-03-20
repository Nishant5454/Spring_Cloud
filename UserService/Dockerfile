FROM openjdk:21-slim
WORKDIR /app
COPY target/UserService-0.0.1-SNAPSHOT.jar UserService.jar
EXPOSE 8081

ENTRYPOINT ["java","-jar","UserService.jar"]