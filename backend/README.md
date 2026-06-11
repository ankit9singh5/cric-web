# Backend Microservices

This directory contains all Spring Boot microservices for the Cricket Score Web App.

## Services Overview

### 1. API Gateway
- Entry point for all client requests
- Routes requests to appropriate microservices
- Handles load balancing and request filtering

### 2. Match Service
- Manages cricket matches
- CRUD operations
- Match scheduling

### 3. Player Service
- Manages player information
- Player statistics
- Team management

### 4. Score Service
- Real-time score tracking
- Wicket management
- WebSocket support for live updates

## Building All Services

```bash
# From root directory
cd backend

# Build all services
mvn clean install

# Or build individual service
cd match-service && mvn clean install
```

## Running Services

Each service can be run individually:

```bash
# Match Service
cd match-service && mvn spring-boot:run

# Player Service
cd player-service && mvn spring-boot:run

# Score Service
cd score-service && mvn spring-boot:run

# API Gateway
cd api-gateway && mvn spring-boot:run
```

## Database Configuration

Update `application.yml` in each service:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/cricket_db
    username: cricket_user
    password: cricket_password
```

## Dependencies

All services use:
- Spring Boot 3.1.0
- Spring Data JPA
- PostgreSQL Driver
- SpringDoc OpenAPI (Swagger)
- Spring Cloud Gateway (for API Gateway)

## Documentation

API Swagger docs available at:
- Match Service: http://localhost:8081/swagger-ui.html
- Player Service: http://localhost:8082/swagger-ui.html
- Score Service: http://localhost:8083/swagger-ui.html
- API Gateway: http://localhost:8080/swagger-ui.html
