FROM openjdk:17
RUN mkdir /opt/app
COPY commande-webapp/target/commande-webapp-0.0.1-SNAPSHOT.jar /opt/app
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=secure", "/opt/app/commande-webapp-0.0.1-SNAPSHOT.jar"]
