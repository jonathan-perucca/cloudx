#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-creator-one-to-one/pom.xml
mvn compile jib:dockerBuild -f gamer-emailer-one-to-one/pom.xml

docker-compose up -d
docker-compose logs -f gamer-emailer-one-to-one