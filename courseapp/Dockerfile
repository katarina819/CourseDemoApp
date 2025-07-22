FROM eclipse-temurin:17-jdk-alpine

# Kopiraj Maven Wrapper i pom.xml (za caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Dozvoli izvršavanje mvnw
RUN chmod +x mvnw

# Preuzmi ovisnosti (cache)
RUN ./mvnw dependency:go-offline

WORKDIR /app

COPY src ./src

RUN ./mvnw package

CMD ["java", "-jar", "target/courseapp-0.0.1-SNAPSHOT.jar"]
