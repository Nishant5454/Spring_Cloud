FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/OrderService-0.0.1-SNAPSHOT.jar OrderService.jar


EXPOSE 8082

ENTRYPOINT ["java", "-jar", "OrderService.jar"]
