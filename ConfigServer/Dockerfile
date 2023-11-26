# Use the official OpenJDK 11 base image
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app/configserverlatest.jar
COPY build/libs/ConfigServer-0.0.1-SNAPSHOT.jar configserverlatest.jar

# Expose the port that the application will run on
EXPOSE 9296

# Define the default command to run your application
CMD ["java", "-jar", "configserverlatest.jar"]
