FROM openjdk:17-alpine

ARG JAR_FILE=/service-send/build/libs/service-send-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} ./notification-0.0.1.jar

ENTRYPOINT ["java","-jar", "notification-0.0.1.jar"]