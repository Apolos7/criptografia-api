FROM openjdk:21
LABEL authors="apolos"

COPY build/libs/criptografia-0.0.1-SNAPSHOT.jar /app/criptografia-0.0.1-SNAPSHOT.jar

COPY /src/main/resources/application.properties  /app/application.properties

WORKDIR /app

EXPOSE 8080

CMD ["java", "-Xmx1024m", "-jar", "criptografia-0.0.1-SNAPSHOT.jar", "--spring.config.location=application.properties"]