# Postavi radni direktorij u /app unutar Docker imagea
WORKDIR /app

# Kopiraj mvnw i pom.xml iz pravog foldera u /app u imageu
COPY demoo/demo/mvnw .
COPY demoo/demo/pom.xml .

# Daj execute permisiju mvnw (bitno za Linux kontejnere)
RUN chmod +x mvnw

# Pokreni mvnw da preuzme dependency-e offline
RUN ./mvnw dependency:go-offline

# Kopiraj ostatak koda iz demoo/demo u /app
COPY demoo/demo/src ./src
