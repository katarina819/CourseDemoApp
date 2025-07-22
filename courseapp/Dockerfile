# Build stage
FROM maven:3.8.6-openjdk-17 AS build

WORKDIR /app

# Kopiraj samo potrebne datoteke za build
COPY demoo/demo/pom.xml .
COPY demoo/demo/src ./src

# Preuzmi Maven dependencies i napravi build bez testova
RUN mvn dependency:go-offline
RUN mvn package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Kopiraj buildani JAR iz build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Pokreni aplikaciju
CMD ["java", "-jar", "app.jar"]
