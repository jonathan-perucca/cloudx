FROM adoptopenjdk/openjdk11:jdk-11.0.2.9

VOLUME /tmp

ENV JAR_NAME=health-notifier
ENV SERVER_PORT=8001
ENV APP_WITH_HEALTH_URL=""
ARG JAR_FILE=target/${JAR_NAME}*.jar

RUN mkdir -p /opt/cloudx-app

WORKDIR /opt/cloudx-app

COPY ${JAR_FILE} app.jar

EXPOSE 8001

CMD ["java", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-DAPP_WITH_HEALTH_URL=$APP_WITH_HEALTH_URL", \
    "-jar", \
    "app.jar"]