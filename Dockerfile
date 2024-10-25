FROM openjdk:17
RUN mkdir /opt/app
COPY commande-webapp/target/informatisation-app-web-0.0.1-SNAPSHOT.jar /opt/app
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=secure", "/opt/app/informatisation-app-web-0.0.1-SNAPSHOT.jar"]
