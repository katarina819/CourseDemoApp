# Base image
FROM eclipse-temurin:17-jdk-alpine

# Create directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN ./mvnw dependency:go-offline

# Copy source code
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
