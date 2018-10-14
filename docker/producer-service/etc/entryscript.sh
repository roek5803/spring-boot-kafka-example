#!/bin/bash

LOG_FILE=${SERVICE_LOG_DIR}/server.log

echo "Starting ${SPRING_APPLICATION_HOME}producer-service-${SERVICE_VERSION}.jar with log_file: ${LOG_FILE}"

cd ${SPRING_APPLICATION_HOME}

java -Dlogging.file=$LOG_FILE -jar producer-service-${SERVICE_VERSION}.jar