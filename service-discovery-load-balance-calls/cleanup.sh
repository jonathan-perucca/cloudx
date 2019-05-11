#!/bin/bash

docker stop gamer-session1
docker stop gamer-session2
docker stop gamer-session3
docker stop gamer-session4
docker stop gamer-session5
docker stop gamer-center
docker stop dev-consul
docker container prune -f
