# Spring boot kafka example

> This is an example how to use Spring Boot together with Kafka as a event bus and protobuf as protocol.

- Spring boot
- Kafka Producer
- Kafka Consumer
- Protobuf
- Eventsourcing

## Try it out locally

Build the jars and docker images.
```bash
mvn clean install -P docker
```

Start up the system with docker-compose
```bash
docker-compose up -d
```

Confirm that the services has been started
```bash
docker ps -a
```

Create a message
```bash
curl -X POST \
  http://localhost:8080/producer-service/api/v1/message/createMessage \
  -H 'Content-Type: application/json' \
  -d '{
	"message": "HELLO WORLD!"
}'
```

Take the id from the previous response and change that message
```bash
curl -X POST \
  http://localhost:8080/producer-service/api/v1/message/changeMessage \
  -H 'Content-Type: application/json' \
  -d '{
	"id": "<ID_YOU_WANT_TO_CHANGE>",
	"message": "YET ANOTHER HELLO WORLD!"
}'
```

Fetch all the messages that we have consumed in the consumer service.
```bash
curl -X GET http://localhost:8081/consumer-service/api/v1/message
```