FROM openjdk:11
#ARG JAR_FILE=target/*.jar
ARG JAR_FILE=out/artifacts/PurpleCow_jar/PurpleCow.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]