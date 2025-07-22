FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Kopiraj mvnw i pom.xml iz pravog foldera u image
COPY ../demoo/demo/mvnw .
COPY ../demoo/demo/pom.xml .

# Daj execute permisiju na mvnw
RUN chmod +x mvnw

# Preuzmi dependency-e offline
RUN ./mvnw dependency:go-offline

# Kopiraj cijeli izvorni kod
COPY ../demoo/demo/src ./src
