#!/bin/bash

docker stop app-with-health
docker stop health-notifier
docker container prune -f
