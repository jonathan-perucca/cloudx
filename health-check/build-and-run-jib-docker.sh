#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f app-with-health/pom.xml
mvn compile jib:dockerBuild -f health-notifier/pom.xml

docker run --rm --name app-with-health --network host -d -t cloudx/app-with-health
docker run --rm -e APP_WITH_HEALTH_URL=http://localhost:8000 --name health-notifier --network host -d -t cloudx/health-notifier

docker logs health-notifier -f
