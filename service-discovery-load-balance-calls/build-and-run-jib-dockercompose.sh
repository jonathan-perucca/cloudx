#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-session/pom.xml
mvn compile jib:dockerBuild -f gamer-center/pom.xml

docker-compose up