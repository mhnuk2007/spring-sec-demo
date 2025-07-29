# spring-sec-demo

A demo Spring Boot project showcasing basic Spring Security integration.

## Features
- Spring Boot application structure
- Basic Spring Security setup
- Example REST controller

## Getting Started

### Prerequisites
- Java 17 or later
- Maven 3.6+

### Build & Run
```bash
mvn clean install
mvn spring-boot:run
```

The application will start on [http://localhost:8080](http://localhost:8080).

## Project Structure
```
spring-sec-demo/
├── src/main/java/com/learning/springsecdemo/
│   ├── HelloController.java
│   └── SpringSecDemoApplication.java
├── src/main/resources/
│   ├── application.properties
│   ├── static/
│   └── templates/
├── pom.xml
└── README.md
```

## Security Configuration

This project uses Spring Security with the following features:
- Custom `UserDetailsService` backed by a PostgreSQL database.
- User entity (`User`) mapped to a `users` table with fields: `id`, `username`, `password`.
- All endpoints require authentication (HTTP Basic, stateless sessions).
- Example implementation of `UserPrincipal` for Spring Security integration.
- Minimal role support: all users are granted the `USER` role by default.

### Database Setup

Ensure you have a PostgreSQL database running and a `users` table with at least one user. Example schema:

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

Insert a user (for testing, passwords are stored in plain text):
```sql
INSERT INTO users (username, password) VALUES ('honey', '1234');
```

### Configuration

Edit `src/main/resources/application.properties` to match your PostgreSQL settings:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/springsecdemo
spring.datasource.username=postgres
spring.datasource.password=0000
```

### Notes
- **Passwords are stored in plain text for demo purposes.** For production, use a password encoder like BCrypt.
- To add roles or authorities, extend the `User` entity and update `UserPrincipal` accordingly.

## Usage

- Start the application and access any endpoint. You will be prompted for HTTP Basic credentials.
- Use a username/password from your database (e.g., `honey` / `1234`).

## Troubleshooting

- **UserDetailsService bean not found:**
  Ensure `MyUserDetailsService` is annotated with `@Service` and your package structure is covered by component scanning.
- **Cannot connect to database:**
  Double-check your PostgreSQL credentials and that the database is running.
- **Authentication fails:**
  Ensure your `users` table has at least one user and passwords match what is stored (plain text for demo).

## How to Test Authentication

1. Start the application.
2. Use a tool like curl or Postman to make a request to any endpoint:
   ```bash
   curl -u honey:1234 http://localhost:8080/your-endpoint
   ```
   You should receive a response if authentication succeeds, or a 401 error if it fails.

## Future Improvements
- Use `BCryptPasswordEncoder` and store hashed passwords for security.
- Add user registration and password reset endpoints.
- Support multiple roles/authorities per user.
- Implement JWT-based authentication for stateless APIs.

## License
This project is licensed under the MIT License.
