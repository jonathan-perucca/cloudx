## app-with-health
- running on port **8000**
- exposing healthcheck on **/actuator/health**

## health-notifier
- running on port **8001**
- logging healthcheck status from app-with-health
- has a strong dependency on where is located app-with-health

## container mode
- both containers are exposed on host network