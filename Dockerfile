FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY target/*.jar take-home.jar
ENTRYPOINT ["java","-jar","/take-home.jar"]