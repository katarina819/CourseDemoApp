# Koristi Java 17 JDK baziranu na Alpine
FROM eclipse-temurin:17-jdk-alpine

# Postavi radni direktorij u kontejneru
WORKDIR /app

# Kopiraj Maven Wrapper i pom.xml (za dependency caching)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Omogući izvršavanje Maven Wrapper skripte
RUN chmod +x mvnw

# Preuzmi sve dependencije da se cache koristi
RUN ./mvnw dependency:go-offline

# Kopiraj ostatak source koda
COPY src ./src

# Buildaj aplikaciju (preskači testove da build brže ide)
RUN ./mvnw clean package -DskipTests

# Postavi port koji će Render koristiti (Render koristi PORT env var)
EXPOSE 8080

# Pokreni aplikaciju - zamijeni ovo sa stvarnim nazivom jar fajla
CMD ["java", "-jar", "target/courseapp-0.0.1-SNAPSHOT.jar"]
