#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-creator/pom.xml
mvn compile jib:dockerBuild -f gamer-emailer/pom.xml

docker-compose up