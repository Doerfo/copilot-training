# backend/README.md

# Copilot Training Backend

## Description

This backend project is part of the Copilot Training full stack application. It is built using Java with the Spring framework and provides RESTful APIs for managing cat profiles.

## Project Structure

- `src/main/java/com/example/copilottraining`: Contains the main application code.
  - `CopilotTrainingApplication.java`: The entry point of the Spring Boot application.
  - `controller`: Contains controllers for handling HTTP requests.
    - `CatProfileController.java`: Manages cat profile-related requests.
  - `model`: Contains the data model classes.
    - `CatProfile.java`: Represents the cat profile entity.
  - `repository`: Contains interfaces for data access.
    - `CatProfileRepository.java`: Provides CRUD operations for cat profiles.
  - `service`: Contains business logic.
    - `CatProfileService.java`: Implements the service layer for cat profiles.
- `src/main/resources`: Contains configuration and static resources.
  - `application.properties`: Configuration properties for the application.
  - `static`: Directory for serving static files.
- `src/test/java/com/example/copilottraining`: Contains test cases for the application.
  - `CopilotTrainingApplicationTests.java`: Tests for the application context.
- `pom.xml`: Maven configuration file for dependencies and build settings.

## Getting Started

To run the backend application, ensure you have Java and Maven installed. Navigate to the backend directory and use the following command:

```bash
mvn spring-boot:run
```

This will start the Spring Boot application, and you can access the APIs at `http://localhost:8080`.

## Dependencies

This project uses the following dependencies:

- Spring Boot Starter Web
- Spring Data JPA
- PostgreSQL Driver

## License

This project is licensed under the MIT License.