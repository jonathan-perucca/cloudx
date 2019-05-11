#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-creator/pom.xml
mvn compile jib:dockerBuild -f gamer-emailer/pom.xml

docker run --rm --name dev-rabbit --network host -d -t rabbitmq:3.7-management
docker run --rm --name gamer-creator --network host -e SERVER_PORT=8002 -d -t cloudx/gamer-creator
docker run --rm --name gamer-emailer --network host -e SERVER_PORT=8001 -d -t cloudx/gamer-emailer

docker logs gamer-emailer -f
