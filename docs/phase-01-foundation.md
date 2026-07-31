# Phase 01 — Foundation

## Objective

Establish a production-ready foundation for the Centralized Counselling System before implementing any business logic.

This phase focuses on project setup, infrastructure, development workflow, CI/CD, documentation, and containerization.

---

# Project

**Project Name**

CentralizedCounsellingSystem

**Description**

Enterprise-grade Counselling Management System for centralized seat allocation.

---

# Technology Stack

| Technology | Version |
|------------|---------|
| Java | 21 |
| Spring Boot | 4.1 |
| Gradle | Latest |
| PostgreSQL | 17 |
| Docker | Latest |
| Spring Data JPA | ✓ |
| Spring Validation | ✓ |
| Spring Boot Actuator | ✓ |
| Swagger / OpenAPI | ✓ |
| Lombok | ✓ |
| GitHub Actions | ✓ |
| SonarQube Plugin | ✓ |

---

# Environment Profiles

Implemented profiles

- Local
- Development
- Production
- Docker

Configuration files

```
application.yml
application-local.yml
application-dev.yml
application-prod.yml
application-docker.yml
```

---

# Infrastructure

Implemented

- Dockerfile
- Docker Compose
- PostgreSQL Container
- Spring Boot Container
- Docker Network

Application and database communicate using Docker networking.

---

# CI/CD

GitHub Actions pipeline performs

- Checkout
- Java Setup
- Gradle Build
- Unit Tests
- PostgreSQL Service
- Artifact Upload

Every push automatically validates the project.

---

# API Documentation

Swagger OpenAPI configured.

Available at

```
/swagger-ui/index.html
```

---

# Monitoring

Spring Boot Actuator configured.

Available endpoints

```
/actuator/health
```

```
/actuator/info
```

```
/actuator/metrics
```

---

# Logging

Spring Boot Logback configured.

Application logging enabled for

```
com.ccs
```

---

# Project Structure

```
src
├── main
│   ├── java
│   │   └── com.ccs
│   │       ├── common
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── enums
│   │       ├── exception
│   │       ├── mapper
│   │       ├── repository
│   │       ├── service
│   │       ├── util
│   │       └── validation
│   └── resources
│       ├── application.yml
│       ├── application-local.yml
│       ├── application-dev.yml
│       ├── application-prod.yml
│       ├── application-docker.yml
│       └── db
│           └── migration
```

---

# Documentation

Created

- README
- LICENSE
- CHANGELOG
- Architecture
- Workflow
- ER Diagram
- Phase Documentation

---

# Verification

Successfully verified

- Spring Boot Application
- PostgreSQL Connection
- Docker Deployment
- Docker Compose
- GitHub Actions
- Swagger
- Actuator Health
- JPA Configuration

---

# Deliverables

Completed

- Production-ready Spring Boot project
- Dockerized PostgreSQL
- Dockerized Application
- CI/CD Pipeline
- API Documentation
- Monitoring
- Logging
- Environment Profiles
- Project Documentation

---

# Phase Status

**Completed**

This phase establishes the engineering foundation required for implementing the Counselling Management System.

Business entities, database schema, allocation engine, repositories, REST APIs, and reports will be implemented in subsequent phases.