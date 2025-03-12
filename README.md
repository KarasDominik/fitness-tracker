## Prerequisites
To run the application locally, ensure you have Docker Compose installed. If you haven't, follow the [Docker Compose installation guide](https://docs.docker.com/compose/install/).

## Getting Started

Having docker compose installed, follow these steps to run the application:

1. Clone the repository
2. Go into <i>devops/docker</i> directory
3. Inside <i>devops/docker</i> directory, run the following command to start the database:
<code> docker compose up </code>
4. Then move back to root directory and run the application with the following command:
<code> mvn spring-boot:run</code>
5. Open your browser and go to: <link>http://localhost:8080</link>
## Architecture
![Image](https://github.com/user-attachments/assets/26dd29af-8f0e-413e-b70e-4079c754c35c)
## Technologies Used:
- **Backend:**
  - Spring Modulith, Spring Data JPA, Spring Security
- **Tests:**
  - Mockito, AssertJ, RestAssured, Testcontainers
- **Database:**
  - PostgreSQL, Flyway
- **Deployment:**
  - Docker
- **CI/CD:**
  - GitHub Actions
## About the project
The project is designed for physically active individuals who want to track their progress through detailed body measurements. 
By providing a structured and efficient way to monitor changes over time, it helps users stay motivated and make informed fitness decisions. 
Built using a modular monolith architecture, the system offers a balanced approach between the simplicity of a monolith and the scalability of microservices. 
This architecture ensures flexibility, maintainability, and the ability to evolve over time without the complexity of full microservices.
