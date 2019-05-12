#!/bin/bash

docker stop gamer-creator-pub-sub
docker stop gamer-emailer-pub-sub
docker stop gamer-logevent-pub-sub
docker stop dev-rabbit
docker container prune -f
