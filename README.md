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

### ✅ Frontend
- React 19
- React Router DOM
- CSS
- Netlify za deployment

---

## 📦 Backend Setup

### 🔧 Pokretanje lokalno (bez Dockera)

1. Kloniraj projekt:
   ```bash
   git clone https://github.com/tvoj-username/courseapp.git
   cd courseapp/backend

2. Uredi src/main/resources/application.properties:
   spring.datasource.url=jdbc:postgresql://localhost:5432/courseapp
   spring.datasource.username=postgres
   spring.datasource.password=lozinka
   spring.jpa.hibernate.ddl-auto=update

3. Pokreni aplikaciju:
   ./mvnw spring-boot:run

4. Aplikacija je dostupna na:
   http://localhost:8080/courses

---

## 🐳 Pokretanje s Dockerom

1. U korijenu backend direktorija napravi Docker image:
   docker build -t courseapp-backend .

2. Pokreni container:
   docker run -p 8080:8080 courseapp-backend

---

## 🎨 Frontend Setup (React)

1. Idi u frontend direktorij:
   cd ../frontend

2. Instaliraj pakete:
   npm install

3. Pokreni aplikaciju:
   npm start

4. Otvori: http://localhost:3000

---

## 🔗 Backend URL

Kreiraj .env datoteku u frontend/ direktoriju:
REACT_APP_BACKEND_URL=https://coursedemoapp-1.onrender.com

---

## 🌍 Deployment

🧾 Backend (Render)
Platforma: https://render.com

URL npr.: https://coursedemoapp-1.onrender.com

Build Command: ./mvnw clean install -DskipTests

Start Command: java -jar target/demo-0.0.1-SNAPSHOT.jar

---

## 🌐 Frontend (Netlify)

Platforma: https://netlify.com

Build command: npm run build

Publish folder: build

Environment varijabla:
REACT_APP_BACKEND_URL=https://coursedemoapp-1.onrender.com


