FROM eclipse-temurin:17-jdk-alpine

# Instaliraj Maven i ostale potrebne alate
RUN apk add --no-cache maven bash

WORKDIR /app

# Kopiraj pom.xml i src direktorij u kontejner
COPY pom.xml .
COPY src ./src

# Preuzmi sve ovisnosti (offline mod)
RUN mvn dependency:go-offline

# Buildaj projekt (npr. package fazu)
RUN mvn package

# Opcionalno: naredbe za pokretanje aplikacije
CMD ["java", "-jar", "target/tvoj-artifact.jar"]
