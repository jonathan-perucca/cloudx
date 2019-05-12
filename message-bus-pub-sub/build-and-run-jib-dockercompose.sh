#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-creator-pub-sub/pom.xml
mvn compile jib:dockerBuild -f gamer-emailer-pub-sub/pom.xml
mvn compile jib:dockerBuild -f gamer-logevent-pub-sub/pom.xml

docker-compose up -d
docker-compose logs -f gamer-emailer-pub-sub gamer-logevent-pub-sub