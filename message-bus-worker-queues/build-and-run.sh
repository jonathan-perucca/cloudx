#!/bin/bash

./cleanup.sh

mvn clean package -DskipTests -f gamer-creator/pom.xml
mvn clean package -DskipTests -f gamer-emailer/pom.xml

docker build gamer-creator/ -t cloudx/gamer-creator
docker build gamer-emailer/ -t cloudx/gamer-emailer

docker run --rm --name dev-rabbit --network host -d -t rabbitmq:3.7-management
docker run --rm --name gamer-creator --network host -e SERVER_PORT=8002 -d -t cloudx/gamer-creator
docker run --rm --name gamer-emailer1 --network host -e SERVER_PORT=8001 -d -t cloudx/gamer-emailer
docker run --rm --name gamer-emailer2 --network host -e SERVER_PORT=8003 -d -t cloudx/gamer-emailer

docker logs gamer-emailer2 -f
