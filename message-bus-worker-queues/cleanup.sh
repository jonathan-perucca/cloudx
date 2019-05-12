#!/bin/bash

docker stop gamer-creator-worker-queues
docker stop gamer-emailer-worker-queues1
docker stop gamer-emailer-worker-queues2
docker stop dev-rabbit
docker container prune -f
