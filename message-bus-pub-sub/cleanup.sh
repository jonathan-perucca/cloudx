#!/bin/bash

docker stop gamer-creator
docker stop gamer-emailer
docker stop gamer-logevent
docker stop dev-rabbit
docker container prune -f
