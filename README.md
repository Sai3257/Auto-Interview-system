# Build the application
.\mvnw.cmd clean install

# Run the application
.\mvnw.cmd spring-boot:run# Build the application
.\mvnw.cmd clean install

# Run the application
.\mvnw.cmd spring-boot:run# Automatic Interview Platform

A comprehensive platform for conducting automated technical interviews, including coding assessments, MCQs, and video interviews.

## Features

1. User Management
   - Role-based access (Admin, Recruiter, Candidate)
   - JWT-based authentication
   - Secure password handling

2. Question Bank
   - MCQ questions
   - Coding questions with test cases
   - Video/Audio questions
   - Difficulty levels
   - Language-specific coding problems

3. Interview Process
   - Automated MCQ tests
   - Coding challenges with Judge0 API integration
   - Video/Audio responses
   - Real-time evaluation

4. Additional Features (Coming Soon)
   - Interview scheduling
   - Calendar integration
   - Result analytics
   - PDF report generation
   - Email/SMS notifications

## Tech Stack

- Backend: Spring Boot 3.1.0
- Security: Spring Security with JWT
- Database: PostgreSQL
- API Documentation: OpenAPI (Swagger)
- Frontend (Planned): React/Angular

## Prerequisites

1. Java 17 or higher
2. PostgreSQL 12 or higher
3. Maven (or use included Maven wrapper)

## Setup Instructions

1. Clone the repository

2. Create PostgreSQL database:
   ```sql
   CREATE DATABASE autointerview;
   ```

3. Update database configuration in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Build the project:
   ```bash
   ./mvnw clean install
   ```

5. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Documentation

Once the application is running, access the Swagger UI at:
- http://localhost:8080/swagger-ui.html

API documentation is available at:
- http://localhost:8080/api-docs

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/autointerview/
│   │       ├── config/          # Configuration classes
│   │       ├── controller/      # REST endpoints
│   │       ├── model/          # Entity classes
│   │       ├── repository/     # Data access layer
│   │       ├── service/        # Business logic
│   │       └── security/       # Security configuration
│   └── resources/
│       └── application.properties
```

- User Management (Admin/Recruiter/Candidate)
- Question Bank Management
- Interview Scheduling
- Live & Automated Interviews
- Code Editor with Compilation
- Automated Evaluation
- Result Analytics
- Email/SMS Notifications

## Tech Stack

### Backend
- Java 17
- Spring Boot 3.1.0
- Spring Security
- MySQL Database
- JPA/Hibernate
- JWT Authentication

### Frontend (Planned)
- React/Angular
- Code Editor Integration (Ace/Monaco)

## Setup Instructions

1. Prerequisites:
   - Java 17 or higher
   - Maven
   - MySQL

2. Database Setup:
   - Create a MySQL database named `autointerview`
   - Update database credentials in `application.properties`

3. Build & Run:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. API Documentation will be available at:
   - http://localhost:8080/swagger-ui.html (after implementation)

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/autointerview/
│   │       ├── config/      # Configuration classes
│   │       ├── controller/  # REST endpoints
│   │       ├── model/       # Entity classes
│   │       ├── repository/  # Data access layer
│   │       ├── service/     # Business logic
│   │       └── security/    # Security configuration
│   └── resources/
│       └── application.properties
```
