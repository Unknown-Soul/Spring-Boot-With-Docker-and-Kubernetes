FROM openjdk:11

ARG JAR_FILE=build/libs/ServiceRegistry-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} serviceregistry.jar

ENTRYPOINT ["java","-jar","/serviceregistry.jar"]

EXPOSE 8761