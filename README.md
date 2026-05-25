# Authentication Service

A Spring Boot microservice implementing JWT-based authentication and role-based authorization with PostgreSQL, Docker, and Swagger documentation.

---

# Features

- User Registration
- User Login
- JWT Token Generation
- JWT Validation
- Role-Based Authorization
- BCrypt Password Encryption
- PostgreSQL Integration
- Docker & Docker Compose Support
- Swagger/OpenAPI Documentation
- Protected APIs
- Sample Orders API

---

# Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- JWT (JSON Web Token)
- PostgreSQL
- Hibernate / JPA
- Docker
- Docker Compose
- Swagger / OpenAPI
- Gradle

---

# Project Architecture

Client → Authentication Service → JWT Security → PostgreSQL

---

# API Endpoints

## Public APIs

### Health Check

```http
GET /hello
```

### Register User

```http
POST /auth/register
```

Sample Request:

```json
{
  "username": "admin1",
  "password": "1234",
  "role": "ADMIN"
}
```

### Login

```http
POST /auth/login
```

Sample Request:

```json
{
  "username": "admin1",
  "password": "1234"
}
```

---

# Protected APIs

## User APIs

```http
GET /user/profile
```

## Admin APIs

```http
GET /admin/dashboard
```

## Orders APIs

```http
GET /orders
GET /orders/{id}
POST /orders
```

---

# Security

- JWT-based authentication
- Role-based access control
- USER and ADMIN roles supported
- BCrypt password hashing

---

# Docker Setup

## Build Application

```bash
./gradlew clean build
```

## Build Docker Image

```bash
docker build -t authentication-service .
```

## Run Docker Compose

```bash
docker compose up
```

---

# Swagger Documentation

Open:

```text
http://localhost:8081/swagger-ui/index.html
```

---

# Database

PostgreSQL database is fully dockerized using Docker Compose.

Persistent storage is handled using Docker volumes.

---

# Future Enhancements

- Separate Employee Service
- API Gateway
- Kubernetes Deployment
- CI/CD Pipeline
- Redis Caching
- Cloud Deployment

---

# Author

Nikitha Arka Govardhan