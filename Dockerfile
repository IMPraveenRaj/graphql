# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the project jar file to the container
COPY target/spring-graphql-0.0.1-SNAPSHOT.jar spring-graphql-0.0.1-SNAPSHOT.jar

# Expose the port that your application will run on
EXPOSE 9191

# Run the jar file
ENTRYPOINT ["java", "-jar", "spring-graphql-0.0.1-SNAPSHOT.jar"]
