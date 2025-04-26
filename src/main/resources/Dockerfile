# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy your jar file into the container
COPY target/kafka-consumer-data-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on (example: 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]