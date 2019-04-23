#!/bin/bash

./cleanup.sh

mvn clean package -DskipTests -f app-with-health/pom.xml
mvn clean package -DskipTests -f health-notifier/pom.xml

docker build app-with-health/ -t cloudx/app-with-health
docker build health-notifier/ -t cloudx/health-notifier

docker run --rm --name app-with-health --network host -d -t cloudx/app-with-health
docker run --rm -e APP_WITH_HEALTH_URL=http://localhost:8000 --name health-notifier --network host -d -t cloudx/health-notifier

docker logs health-notifier -f
