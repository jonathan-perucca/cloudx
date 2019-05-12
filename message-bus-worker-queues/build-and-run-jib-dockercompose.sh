#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-creator-worker-queues/pom.xml
mvn compile jib:dockerBuild -f gamer-emailer-worker-queues/pom.xml

docker-compose up -d
docker-compose logs -f gamer-emailer-one-worker-queues gamer-emailer-two-worker-queues