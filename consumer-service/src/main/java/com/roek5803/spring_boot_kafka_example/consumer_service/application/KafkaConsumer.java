package com.roek5803.spring_boot_kafka_example.consumer_service.application;

import com.google.protobuf.InvalidProtocolBufferException;
import com.roek5803.spring_boot_kafka_example.events.Envelope;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    private final EventHandler eventHandler;

    @Autowired
    public KafkaConsumer(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @KafkaListener(topics = "${app.topic.message}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, Envelope> record) throws InvalidProtocolBufferException {
        LOGGER.debug("received record='{}'", record);

        Optional<Envelope> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Envelope envelope = Envelope.parseFrom(kafkaMessage.get().toByteArray());
            LOGGER.debug("received envelope='{}'", envelope);
            eventHandler.handle(envelope);
        }

    }

}
