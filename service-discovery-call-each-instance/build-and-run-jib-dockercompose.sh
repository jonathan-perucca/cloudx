#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-session-each-instance/pom.xml
mvn compile jib:dockerBuild -f gamer-center-each-instance/pom.xml

docker-compose up -d
docker-compose logs -f gamer-center