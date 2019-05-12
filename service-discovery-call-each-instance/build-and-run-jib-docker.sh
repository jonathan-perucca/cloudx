#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-session-each-instance/pom.xml
mvn compile jib:dockerBuild -f gamer-center-each-instance/pom.xml

docker run --rm --name dev-consul --network host -d -t consul:1.4.4
docker run --rm --name gamer-session1   --network host -e SERVER_PORT=8002 -d -t cloudx/gamer-session-each-instance
docker run --rm --name gamer-session2   --network host -e SERVER_PORT=8003 -d -t cloudx/gamer-session-each-instance
docker run --rm --name gamer-session3   --network host -e SERVER_PORT=8004 -d -t cloudx/gamer-session-each-instance
docker run --rm --name gamer-session4   --network host -e SERVER_PORT=8005 -d -t cloudx/gamer-session-each-instance
docker run --rm --name gamer-session5   --network host -e SERVER_PORT=8006 -d -t cloudx/gamer-session-each-instance
docker run --rm --name gamer-center     --network host -e SERVER_PORT=8001 -d -t cloudx/gamer-center-each-instance

docker logs gamer-center -f
