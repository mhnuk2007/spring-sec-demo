# spring-sec-demo

A Spring Boot 3.5.x demo showcasing Spring Security with JWT authentication, PostgreSQL integration, and secure password handling.

## 🚀 Features

- ✅ Spring Boot REST API
- ✅ JWT-based stateless authentication
- ✅ Spring Security integration
- ✅ BCrypt password hashing
- ✅ PostgreSQL database integration
- ✅ Role-based authority setup (default `USER`)
- ✅ Example endpoints: `/hello`, `/students`, `/register`, `/login`

## 🧰 Prerequisites

- Java 17 or later
- Maven 3.6+
- PostgreSQL (configured in `application.properties`)

## 📦 Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

## 🗃️ Project Structure

```
spring-sec-demo/
├── controller/
├── config/
├── model/
├── service/
├── dao/
├── application.properties
├── pom.xml
└── README.md
```

## 🔐 Security Setup

- Uses Spring Security with a custom `UserDetailsService`
- Passwords are hashed using BCrypt (strength 12)
- Stateless JWT authentication configured with a custom filter
- JWT is signed using HMAC-SHA256 with a dynamically generated secret key

## 📦 Database Setup

```sql
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);
```

### Example User Insert (hashed password auto-generated on registration)

```
POST /register
Content-Type: application/json

{
  "username": "honey",
  "password": "1234"
}
```

## ✅ Authentication

- Register using `/register` endpoint
- Login using `/login` to receive a JWT token
- Use the token in `Authorization` header for secured endpoints

```bash
curl -H "Authorization: Bearer <your_token>" http://localhost:8080/hello
```

## 🛠️ Troubleshooting

- Ensure PostgreSQL is running and credentials match
- Passwords are encrypted—plaintext login won’t work unless hashed properly
- For CSRF token: call `/csrf-token` if enabled in future stateful security mode

## 🔐 Password Security

- Passwords are never stored or transmitted in plain text
- BCrypt encoder used with Spring Security configuration

## 📌 Notes

- Extend role/authority setup as needed using User and UserPrincipal
- Secret key is generated at runtime for demo purposes (you can persist it in production)

## 📄 License

MIT License.