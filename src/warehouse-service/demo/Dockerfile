# ---- Build Stage ----
    FROM maven:3.9.6-eclipse-temurin-17 AS build
    WORKDIR /app
    
    COPY pom.xml .
    COPY src ./src
    
    RUN mvn clean package -DskipTests
    
    # ---- Runtime Stage ----
    FROM gcr.io/distroless/java17-debian11:nonroot
    
    COPY --from=build /app/target/*.jar /app/app.jar

    ENV EUREKA_HOST=localhost
    ENV EUREKA_PORT=8761

    EXPOSE 9090
    
    ENTRYPOINT ["java", "-jar", "/app/app.jar"]
    