FROM maven:3.9.6-eclipse-temurin-21 AS build
LABEL authors="LUISMORENO"
COPY . .
RUN mvn clean package

FROM openjdk:21
EXPOSE 8080
COPY --from=build /target/prestamos-0.0.1-SNAPSHOT.jar prestamos-app.jar
ENTRYPOINT ["java", "-jar", "/prestamos-app.jar"]