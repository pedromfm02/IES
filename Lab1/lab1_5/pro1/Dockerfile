FROM openjdk:11
LABEL mainteiner="Pedro Matos <pedromfm02@ua.pt>"
COPY target/docker-java-jar-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]