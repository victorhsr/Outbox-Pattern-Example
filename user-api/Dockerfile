# stage:build app in docker
FROM maven:3.5.2-jdk-8 AS build
COPY src /opt/app/src 
COPY pom.xml /opt/app 
RUN mvn -f /opt/app/pom.xml clean package 

# stage:build image
FROM openjdk:8-jre-slim
COPY --from=build /opt/app/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8081