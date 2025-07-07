# Stage 1: Build the WAR file
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Stage 2: Minimal runtime image with only the WAR
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY --from=builder /build/target/*.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]
