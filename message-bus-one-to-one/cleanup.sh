#!/bin/bash

docker stop gamer-creator
docker stop gamer-emailer
docker stop dev-rabbit
docker container prune -f
