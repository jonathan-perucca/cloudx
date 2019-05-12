#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-creator-pub-sub/pom.xml
mvn compile jib:dockerBuild -f gamer-emailer-pub-sub/pom.xml
mvn compile jib:dockerBuild -f gamer-logevent-pub-sub/pom.xml

docker run --rm --name dev-rabbit --network host -d -t rabbitmq:3.7-management
docker run --rm --name gamer-creator-pub-sub --network host -e SERVER_PORT=8002 -d -t cloudx/gamer-creator-pub-sub
docker run --rm --name gamer-emailer-pub-sub --network host -e SERVER_PORT=8001 -d -t cloudx/gamer-emailer-pub-sub
docker run --rm --name gamer-logevent-pub-sub --network host -e SERVER_PORT=8003 -d -t cloudx/gamer-logevent-pub-sub

docker logs gamer-emailer-pub-sub -f
