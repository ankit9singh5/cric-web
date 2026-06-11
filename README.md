# Cricket Score Web Application

A full-stack microservices-based cricket score tracking application built with Java Spring Boot, Angular, and PostgreSQL.

## Project Structure

```
cric-web/
├── backend/                    # Spring Boot Microservices
│   ├── match-service/         # Match management microservice
│   ├── player-service/        # Player management microservice
│   ├── score-service/         # Score tracking microservice
│   └── api-gateway/           # API Gateway (Spring Cloud Gateway)
├── frontend/                  # Angular Application
└── docs/                      # Documentation
```

## Tech Stack

- **Backend:** Java 17, Spring Boot 3.1, Spring Cloud, Spring Data JPA
- **Frontend:** Angular 15+, TypeScript, Bootstrap 5
- **Database:** PostgreSQL 15
- **Build Tool:** Maven
- **API:** RESTful APIs + WebSocket

## Prerequisites

- Java 17+
- Node.js 16+
- PostgreSQL 15+
- Maven 3.6+
- Angular CLI

## Getting Started

### 1. Backend Setup

Navigate to each microservice directory and run:
```bash
mvn clean install
mvn spring-boot:run
```

Services run on:
- API Gateway: http://localhost:8080
- Match Service: http://localhost:8081
- Player Service: http://localhost:8082
- Score Service: http://localhost:8083

### 2. Frontend Setup

```bash
cd frontend
npm install
ng serve
```

Access at http://localhost:4200

### 3. Database Setup

Create PostgreSQL database:
```sql
CREATE DATABASE cricket_db;
CREATE USER cricket_user WITH PASSWORD 'cricket_password';
GRANT ALL PRIVILEGES ON DATABASE cricket_db TO cricket_user;
```

Update `application.yml` in each service with your PostgreSQL credentials.

## Microservices

### 1. API Gateway (Port: 8080)
- Central routing for all requests
- Request forwarding to appropriate services

### 2. Match Service (Port: 8081)
- Manage cricket matches
- CRUD operations for matches
- Match scheduling and status

### 3. Player Service (Port: 8082)
- Player information management
- Player statistics
- Team management

### 4. Score Service (Port: 8083)
- Real-time score tracking
- Wicket management
- Innings tracking
- WebSocket support for live updates

## API Documentation

Each service provides Swagger documentation at:
- `http://localhost:PORT/swagger-ui.html`

## Database Configuration

- Host: localhost
- Port: 5432
- Database: cricket_db
- Username: cricket_user
- Password: cricket_password

## Project Features

- Multi-tier microservices architecture
- Scalable backend services
- Real-time score updates via WebSocket
- RESTful API design
- PostgreSQL with JPA/Hibernate
- Modern Angular frontend with Bootstrap

## Contributing

1. Create feature branches
2. Make your changes
3. Submit pull requests

## License

MIT
