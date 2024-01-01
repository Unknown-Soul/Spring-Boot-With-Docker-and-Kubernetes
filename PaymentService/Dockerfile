FROM openjdk:11

ARG JAR_FILE=build/libs/PaymentService-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} paymentservice.jar

ENTRYPOINT ["java","-jar","/paymentservice.jar"]

EXPOSE 8082