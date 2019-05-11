FROM adoptopenjdk/openjdk11:jdk-11.0.2.9

VOLUME /tmp

ENV JAR_NAME=gamer-creator
ENV SERVER_PORT=8000
ARG JAR_FILE=target/${JAR_NAME}*.jar

RUN mkdir -p /opt/cloudx-app

WORKDIR /opt/cloudx-app

COPY ${JAR_FILE} app.jar

EXPOSE ${SERVER_PORT}

CMD ["java", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-noverify", \
    "-jar", \
    "app.jar"]