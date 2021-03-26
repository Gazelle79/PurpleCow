FROM openjdk:11
ARG JAR_FILE=out/artifacts/PurpleCow_jar/PurpleCow.jar
COPY ${JAR_FILE} app.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","/app.jar"]
