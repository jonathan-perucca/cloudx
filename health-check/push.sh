#!/bin/bash

docker tag cloudx/app-with-health under/app-with-health
docker tag cloudx/health-notifier under/health-notifier

docker push under/app-with-health
docker push under/health-notifier