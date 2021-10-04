FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
ADD build/libs/RiskFilenetUI-WEB-exec.jar /app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]