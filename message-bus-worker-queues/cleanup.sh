#!/bin/bash

docker stop gamer-creator
docker stop gamer-emailer1
docker stop gamer-emailer2
docker stop dev-rabbit
docker container prune -f
