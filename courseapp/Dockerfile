FROM maven:3.8.6-openjdk-17 AS build

WORKDIR /app

COPY demoo/demo/mvnw .
COPY demoo/demo/pom.xml .
COPY demoo/demo/src ./src
COPY demoo/demo/.mvn .mvn

RUN ./mvnw dependency:go-offline
RUN ./mvnw package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
