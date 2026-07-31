# Centralized Counselling System (CCS)

> An enterprise-grade Counselling Management System built with Java and Spring Boot that simulates the complete centralized seat allocation process followed by counselling authorities such as the Karnataka Examinations Authority (KEA).

---

## Overview

The **Centralized Counselling System (CCS)** is a backend application designed to automate the entire counselling lifecycle, from candidate registration and preference submission to multi-round seat allocation and admission reporting.

The project follows enterprise software engineering practices, including layered architecture, RESTful APIs, Dockerized infrastructure, automated testing, API documentation, and CI/CD.

---

## Key Features

### Candidate Management
- Candidate master data
- Rank management
- Category verification
- Eligibility validation

### College Management
- College information
- Course information
- Seat matrix management
- Reservation category support

### Preference Management
- Option entry
- Preference modification
- Preference locking
- Round-wise preference updates

### Seat Allocation Engine
- Merit-based allocation
- Reservation category allocation
- Mock round allocation
- Round 1 allocation
- Round 2 allocation
- Round 3 allocation
- Final round allocation
- Seat matrix updates

### Reporting
- Candidate allotment result
- College-wise cutoff generation
- Remaining seat matrix
- Admission report
- Counselling reports

---

# Counselling Workflow

```text
Create Counselling Session
            │
            ▼
Upload Master Data
            │
            ▼
Candidate Option Entry
            │
            ▼
Preference Locking
            │
            ▼
Round 0 - Mock Allocation
            │
            ▼
Publish Results
            │
            ▼
Preference Modification
            │
            ▼
Round 1 Allocation
            │
            ▼
Candidate Decision
            │
            ▼
Seat Matrix Update
            │
            ▼
Round 2 Allocation
            │
            ▼
Candidate Decision
            │
            ▼
Seat Matrix Update
            │
            ▼
Round 3 Allocation
            │
            ▼
Candidate Decision
            │
            ▼
Final Round Allocation
            │
            ▼
Generate Final Admission Report
            │
            ▼
Close Counselling
```

---

# Technology Stack

| Category | Technology |
|----------|------------|
| Language | Java 21 |
| Framework | Spring Boot |
| Build Tool | Gradle |
| Database | PostgreSQL |
| ORM | Spring Data JPA |
| API Documentation | Swagger / OpenAPI |
| Monitoring | Spring Boot Actuator |
| Testing | JUnit 5 |
| Mocking | Mockito |
| Containerization | Docker |
| Static Code Analysis | SonarQube |
| Version Control | Git |
| CI/CD | GitHub Actions |

---

# Project Architecture

```text
                        Client
                           │
                           ▼
                  REST Controllers
                           │
                           ▼
                    Service Layer
                           │
                           ▼
                Seat Allocation Engine
                           │
                           ▼
                  Repository Layer
                           │
                           ▼
                     PostgreSQL
```

---

# Project Structure

```text
CentralizedCounsellingSystem
│
├── docs
│
├── docker
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.ccs
│   │   │       ├── config
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── exception
│   │   │       ├── mapper
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       ├── util
│   │   │       └── validation
│   │   │
│   │   └── resources
│   │
│   └── test
│
├── docker-compose.yml
├── Dockerfile
├── build.gradle
├── README.md
└── LICENSE
```

---

# Development Roadmap

## Phase A — Foundation

- Spring Boot
- PostgreSQL
- Docker
- Swagger
- Actuator
- SonarQube
- GitHub Actions

---

## Phase B — Database Design

- ER Diagram
- Entity Relationships
- Flyway Migrations

---

## Phase C — Master Data

- Candidate
- College
- Course
- Seat Matrix
- Reservation Category

---

## Phase D — Seat Allocation Engine

- Allocation Algorithm
- Seat Matrix Update
- Cutoff Generation

---

## Phase E — Counselling Rounds

- Mock Round
- First Round
- Second Round
- Third Round
- Final Round

---

## Phase F — Reports

- Candidate Result
- Admission Report
- College Cutoff
- Remaining Seat Matrix

---

## API Documentation

Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI JSON

```
http://localhost:8080/api-docs
```

---

## Monitoring

Spring Boot Actuator

```
http://localhost:8080/actuator
```

Health Endpoint

```
http://localhost:8080/actuator/health
```

---

# Running the Project

### Start PostgreSQL

```bash
docker compose up -d
```

### Run the application

```bash
./gradlew bootRun
```

### Build

```bash
./gradlew clean build
```

### Run Tests

```bash
./gradlew test
```

---

# Future Enhancements

- Authentication & Authorization
- Admin Dashboard
- Candidate Portal
- PDF Generation
- Email Integration
- Audit Logging
- Analytics Dashboard
- Notification System
- Performance Optimization
- Deployment Pipeline

---

# Learning Objectives

This project demonstrates practical experience with:

- Enterprise Java Development
- Spring Boot Architecture
- REST API Design
- PostgreSQL Database Design
- Docker
- GitHub Actions
- CI/CD
- Clean Architecture
- Object-Oriented Design
- Seat Allocation Algorithms
- Software Engineering Best Practices

---

# Author

**Lakshmisagar JM**

Software Engineer | Java Backend Developer

---

# License

This project is licensed under the MIT License.