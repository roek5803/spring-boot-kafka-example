# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Maintainer
MAINTAINER Robin eklund
LABEL maintainer="robin.eklund23@gmail.com"

# Expose ports
EXPOSE 8080

RUN apk add --no-cache bash
RUN apk add --no-cache nano
RUN apk add --no-cache curl
RUN apk add --no-cache gzip
RUN apk add --no-cache wget

# Set env vaariables
ENV SPRING_HOME                 /opt/spring/
ENV SPRING_APPLICATION_HOME     ${SPRING_HOME}app/
ENV SERVICE_LOG_DIR             /var/log/app
ENV HOME                        /root
ENV DOCKERIZE_VERSION           v0.6.1

# Install dockerize
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm -f dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

# Create config folder
RUN mkdir -p ${SPRING_APPLICATION_HOME}config

