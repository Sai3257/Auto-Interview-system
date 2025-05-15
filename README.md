# Auto Interview System

A comprehensive platform for conducting automated and live technical interviews. The system supports multiple question types, automated evaluation, and detailed reporting.

## Features

- **User Management**
  - Admin, Recruiter, and Candidate roles
  - JWT-based authentication
  - Role-based access control

- **Question Bank**
  - Multiple Choice Questions (MCQs)
  - Coding Problems
  - Video/Audio Questions
  - Question tagging and difficulty levels
  - Question bank organization

- **Interview Management**
  - Schedule interviews
  - Auto-conducted tests
  - Live interviews
  - Pre-recorded video/audio questions
  - Real-time evaluation
  - Detailed feedback and scoring

## Tech Stack

- **Backend**
  - Java 17
  - Spring Boot 3.1.0
  - Spring Security with JWT
  - JPA/Hibernate
  - PostgreSQL

## Prerequisites

- Java 17 or higher
- PostgreSQL 12 or higher
- Maven 3.6 or higher

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/auto-interview-system.git
   cd auto-interview-system
   ```

2. Configure the database:
   - Create a PostgreSQL database named `autointerview`
   - Update `src/main/resources/application.yml` with your database credentials

3. Configure email settings:
   - Update `src/main/resources/application.yml` with your email credentials

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

The application will be available at `http://localhost:8080`

## API Documentation

Once the application is running, you can access the API documentation at:
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI Docs: `http://localhost:8080/api-docs`

## API Endpoints

### Authentication
- POST `/api/v1/auth/register` - Register a new user
- POST `/api/v1/auth/login` - Login and get JWT tokens
- POST `/api/v1/auth/refresh-token` - Refresh access token
- POST `/api/v1/auth/logout` - Logout and invalidate tokens

### Question Banks
- POST `/api/v1/question-banks` - Create a question bank
- GET `/api/v1/question-banks` - Get all question banks
- GET `/api/v1/question-banks/{id}` - Get a specific question bank
- PUT `/api/v1/question-banks/{id}` - Update a question bank
- DELETE `/api/v1/question-banks/{id}` - Delete a question bank

### Questions
- POST `/api/v1/questions` - Create a question
- GET `/api/v1/questions` - Get all questions
- GET `/api/v1/questions/{id}` - Get a specific question
- PUT `/api/v1/questions/{id}` - Update a question
- DELETE `/api/v1/questions/{id}` - Delete a question

### Interviews
- POST `/api/v1/interviews` - Schedule an interview
- GET `/api/v1/interviews` - Get all interviews
- GET `/api/v1/interviews/{id}` - Get a specific interview
- PUT `/api/v1/interviews/{id}` - Update an interview
- DELETE `/api/v1/interviews/{id}` - Cancel an interview
- POST `/api/v1/interviews/{id}/start` - Start an interview
- POST `/api/v1/interviews/{id}/end` - End an interview
- POST `/api/v1/interviews/{id}/feedback` - Submit interview feedback

## Security

The application uses JWT (JSON Web Tokens) for authentication and authorization. All endpoints except `/api/v1/auth/**` require a valid JWT token in the Authorization header:

```
Authorization: Bearer your_jwt_token_here
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
