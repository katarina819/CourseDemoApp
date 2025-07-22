FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Kopiraj cijeli projekt (pom.xml, mvnw, src i ostalo)
COPY . .

# Daj dopuštenje da se mvnw može izvršavati (ponekad je potrebno)
RUN chmod +x ./mvnw

# Pokreni preuzimanje ovisnosti
RUN ./mvnw dependency:go-offline

# Izradi aplikaciju bez testova
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
