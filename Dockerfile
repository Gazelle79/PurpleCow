FROM openjdk:11
COPY target/PurpleCow-0.0.1-SNAPSHOT.jar PurpleCow.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","/PurpleCow.jar"]