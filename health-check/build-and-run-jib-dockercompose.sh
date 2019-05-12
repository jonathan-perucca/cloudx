#!/bin/bash

./cleanup.sh

mvn compile jib:dockerBuild -f app-with-health/pom.xml
mvn compile jib:dockerBuild -f health-notifier/pom.xml

docker-compose up -d
docker-compose logs -f health-notifier