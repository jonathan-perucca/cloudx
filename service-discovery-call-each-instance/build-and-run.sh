#!/bin/bash

./cleanup.sh

mvn clean package -DskipTests -f gamer-session/pom.xml
mvn clean package -DskipTests -f gamer-center/pom.xml

docker build gamer-session/ -t cloudx/gamer-session
docker build gamer-center/ -t cloudx/gamer-center

docker run --rm --name dev-consul --network host -d -t consul:1.4.4
docker run --rm --name gamer-session1 --network host -e SERVER_PORT=8002 -d -t cloudx/gamer-session
docker run --rm --name gamer-session2 --network host -e SERVER_PORT=8003 -d -t cloudx/gamer-session
docker run --rm --name gamer-session3 --network host -e SERVER_PORT=8004 -d -t cloudx/gamer-session
docker run --rm --name gamer-session4 --network host -e SERVER_PORT=8005 -d -t cloudx/gamer-session
docker run --rm --name gamer-session5 --network host -e SERVER_PORT=8006 -d -t cloudx/gamer-session
docker run --rm --name gamer-center --network host -e SERVER_PORT=8001 -d -t cloudx/gamer-center

docker logs gamer-center -f
