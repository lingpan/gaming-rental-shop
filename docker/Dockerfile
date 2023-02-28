FROM openjdk:17-jdk-slim-buster

EXPOSE 8080

ENV APP_HOME /usr/src/app

COPY target/gameRental-0.0.2-SNAPSHOT.jar $APP_HOME/app.jar

WORKDIR $APP_HOME

ENTRYPOINT exec java -jar app.jar