# 📚 CourseApp

Full-stack aplikacija za upravljanje edukativnim tečajevima. Omogućuje pregled i prijavu na tečajeve.

## 🛠️ Tehnologije

### ✅ Backend
- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Maven
- Docker
- Commercetools
- Deployment: Render 

#### ✅ Frontend
- React 19
- React Router DOM
- CSS
- Deployment: Netlify

---

### 📦 Backend Setup

### 🔧 Pokretanje lokalno (bez Dockera)

1. Kloniraj projekt:
   ```bash
   git clone https://github.com/tvoj-username/courseapp.git
   cd courseapp/backend
   

2. Uredi src/main/resources/application.properties:
   ```bash
   spring.datasource.url=jdbc:postgresql://localhost:5432/courseapp
   spring.datasource.username=postgres
   spring.datasource.password=lozinka
   spring.jpa.hibernate.ddl-auto=update
   

3. Pokreni aplikaciju:
   ```bash
   ./mvnw spring-boot:run
   

4. Aplikacija je dostupna na:
   ```bash
   http://localhost:8080/courses
   

---

### 🐳 Pokretanje s Dockerom

1. U korijenu backend direktorija napravi Docker image:
   ```bash
   docker build -t courseapp-backend .
   

2. Pokreni container:
   ```bash
   docker run -p 8080:8080 courseapp-backend
   

---

# 🎨 Frontend Setup (React)

1. Idi u frontend direktorij:
   ```bash
   cd ../frontend
   

2. Instaliraj pakete:
   ```bash
   npm install
   

3. Pokreni aplikaciju:
   ```bash
   npm start
   

4. Otvori:
   ```bash
   http://localhost:3000
    

---

# 🔗 Backend URL

Kreiraj .env datoteku u frontend/ direktoriju:
```bash
REACT_APP_BACKEND_URL=https://coursedemoapp-1.onrender.com


---

 ** 🌍 Deployment **

   🧾 Backend (Render)
   
   Platforma: https://render.com

   URL npr.: https://coursedemoapp-1.onrender.com

   Build Command: ./mvnw clean install -DskipTests

   Start Command: java -jar target/demo-0.0.1-SNAPSHOT.jar


---

** 🌐 Frontend (Netlify) **

   
   Platforma: https://netlify.com

   Build command: npm run build

   Publish folder: build

   Environment varijabla:
   REACT_APP_BACKEND_URL=https://coursedemoapp-1.onrender.com



