# Read Me First
# Assigment  with Springboot,PostgreSQL,and Docker

## STEPS FOR THIS SPRING BOOT APP
- Define dependencies in pom.xml
- Modify application.properties, for database connection
- Build

## BUILD the application
./mvnw clean install -DskipTests

## BUILD AND UP Docker Compose
docker compose up -d
docker logs container_ID

## API DOCUMENTATION
http://localhost:8080/swagger-ui/index.html