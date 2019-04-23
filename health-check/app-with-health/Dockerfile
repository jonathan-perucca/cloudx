FROM adoptopenjdk/openjdk11:jdk-11.0.2.9

VOLUME /tmp

ENV JAR_NAME=app-with-health
ENV SERVER_PORT=8000
ARG JAR_FILE=target/${JAR_NAME}*.jar

RUN mkdir -p /opt/cloudx-app

WORKDIR /opt/cloudx-app

COPY ${JAR_FILE} app.jar

EXPOSE 8000

CMD ["java", \
    "-Djava.security.egd=file:/dev/./urandom", \
    "-jar", \
    "app.jar"]