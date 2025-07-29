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
- Stateless session management (`SessionCreationPolicy.STATELESS`)
- CSRF protection disabled for APIs
- HTTP Basic authentication enabled
- In-memory users for testing:
    - Username: `honey`, Password: `123456`, Role: `USER`
    - Username: `admin`, Password: `1234`, Role: `ADMIN`

To access secured endpoints, use one of the above credentials.

## License
This project is licensed under the MIT License.
