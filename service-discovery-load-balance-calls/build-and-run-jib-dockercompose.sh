#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-session-load-balanced/pom.xml
mvn compile jib:dockerBuild -f gamer-center-load-balanced/pom.xml

docker-compose up -d
docker-compose logs -f gamer-center