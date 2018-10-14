FROM com.roek5803.spring-boot-kafka-example/base:1.0-SNAPSHOT

#
# Set Build And Environment variables
#
ARG SERVICE_BUILD_DATE
ARG SERVICE_VERSION

ENV SERVICE_VERSION ${SERVICE_VERSION}

#
# Get jar file
#
COPY target/producer-service-${SERVICE_VERSION}.jar         ${SPRING_APPLICATION_HOME}

#
# Get startup scripts
#
COPY etc                                                    /etc
COPY config                                                 ${SPRING_APPLICATION_HOME}config

RUN chmod +x /etc/entryscript.sh

WORKDIR /root

CMD [ "/bin/bash", "-c", "/etc/entryscript.sh" ]