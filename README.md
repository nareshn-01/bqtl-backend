#  BQTL Laboratory Workflow Management System

A full-stack Laboratory Workflow Management System developed for Bharat Quality Testing Lab (BQTL). The application helps laboratories manage services, sample requests, test reports, and invoices through a modern web interface.

##  Features

### Authentication
- Secure JWT Login
- Role-based access
- Protected routes

### Dashboard
- Admin dashboard
- Overview of laboratory activities

### Services
- View laboratory services
- Service categories
- Pricing management

### Sample Management
- Create sample requests
- View submitted samples
- Track sample status

### Test Reports
- Upload PDF reports
- View uploaded reports
- Download reports
- Store report metadata

### Invoice Management
- Generate invoices
- View invoices
- Download invoices

---

# Tech Stack

## Frontend

- React.js
- Vite
- React Router DOM
- Axios
- CSS3
- JavaScript (ES6)

## Backend

- Java 21
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA
- Hibernate
- Maven

## Database

- PostgreSQL

---

# Project Structure

```
bqtl-backend/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/bqtl/
│   │   └── resources/
│   │
│   └── test/
│
├── uploads/
├── pom.xml
├── README.md
│
└── frontend/
    ├── public/
    ├── src/
    ├── package.json
    ├── vite.config.js
    └── README.md
```

---

# Backend Setup

Clone the repository

```bash
git clone <repository-url>
```

Move into backend

```bash
cd bqtl-backend
```

Run Spring Boot

```bash
mvn clean spring-boot:run
```

Backend runs on

```
http://localhost:8080
```

Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

#  Frontend Setup

Move into frontend folder

```bash
cd frontend
```

Install dependencies

```bash
npm install
```

Run development server

```bash
npm run dev
```

Frontend runs on

```
http://localhost:5173
```

---

# Database

Database

```
PostgreSQL
```

Example configuration

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bqtl
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# REST APIs

## Authentication

- POST /auth/login
- POST /auth/register

## Services

- GET /services
- POST /services

## Samples

- GET /samples
- POST /samples

## Reports

- GET /reports
- POST /reports/{sampleId}
- GET /reports/download/{id}

## Invoices

- GET /invoices
- POST /invoices

---

# Modules

- Login
- Dashboard
- Services
- Samples
- Create Sample
- Upload Report
- Reports
- Invoices

---

#  Developed By

**Naresh N**

B.Tech – Artificial Intelligence & Machine Learning

Srinivas University

---

#  License

This project is developed for educational and academic purposes.
