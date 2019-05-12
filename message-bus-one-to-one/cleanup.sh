#!/bin/bash

docker stop gamer-creator-one-to-one
docker stop gamer-emailer-one-to-one
docker stop dev-rabbit
docker container prune -f
