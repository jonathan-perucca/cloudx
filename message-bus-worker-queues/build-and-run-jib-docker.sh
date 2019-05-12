#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f gamer-creator-worker-queues/pom.xml
mvn compile jib:dockerBuild -f gamer-emailer-worker-queues/pom.xml

docker run --rm --name dev-rabbit --network host -d -t rabbitmq:3.7-management
docker run --rm --name gamer-creator-worker-queues --network host -e SERVER_PORT=8002 -d -t cloudx/gamer-creator-worker-queues
docker run --rm --name gamer-emailer-worker-queues1 --network host -e SERVER_PORT=8001 -d -t cloudx/gamer-emailer-worker-queues
docker run --rm --name gamer-emailer-worker-queues2 --network host -e SERVER_PORT=8003 -d -t cloudx/gamer-emailer-worker-queues

docker logs gamer-emailer-worker-queues2 -f
