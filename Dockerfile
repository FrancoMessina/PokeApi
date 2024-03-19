FROM amazoncorretto:18-alpine-jdk

COPY POKEDEX/target/POKEDEX-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
