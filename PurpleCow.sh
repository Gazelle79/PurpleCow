#!/bin/bash

# get the project base directory
BASE_DIR=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )

# set default for port
PORT=3000

# if there's an argument, use that as the port
if [ -n "$1" ]
  then
    PORT=$1
fi


cat > ${BASE_DIR}/Dockerfile << EOF
FROM openjdk:11
COPY target/PurpleCow-0.0.1-SNAPSHOT.jar PurpleCow.jar
EXPOSE ${PORT}
ENTRYPOINT ["java","-jar","/PurpleCow.jar","--server.port=${PORT}"]
EOF


# build project and docker image, then run it
cd ${BASE_DIR}
docker stop purplecow >/dev/null 2>&1
mvn clean package && \
   sudo docker build -t purplecow . && \
   sudo docker run -d --rm --name purplecow -p ${PORT}:${PORT} purplecow



