FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/EurekaService-0.0.1-SNAPSHOT.jar EurekaService.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","EurekaService.jar"]