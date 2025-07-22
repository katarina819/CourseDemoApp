FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY mvnw .
COPY pom.xml .

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src
