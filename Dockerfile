FROM openjdk:11
ARG JAR_FILE=out/artifacts/PurpleCow_jar/PurpleCow.jar
COPY ${JAR_FILE} PurpleCow.jar
EXPOSE 3000
ENTRYPOINT ["java","-jar","/PurpleCow.jar"]
