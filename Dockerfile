FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk - y
COPY . .

run apt-get install maven -y
run mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/finanzas-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]