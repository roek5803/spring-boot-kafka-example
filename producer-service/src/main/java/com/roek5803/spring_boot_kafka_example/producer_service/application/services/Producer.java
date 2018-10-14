package com.roek5803.spring_boot_kafka_example.producer_service.application.services;

import com.roek5803.spring_boot_kafka_example.events.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    private final KafkaTemplate<String, Envelope> kafkaTemplate;
    private final String topic;

    @Autowired
    public Producer(KafkaTemplate<String, Envelope> kafkaTemplate,
                    @Value("${app.topic.message}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(List<Envelope> events) {
        events.forEach(this::send);
    }

    private void send(Envelope envelope) {
        LOGGER.debug("sending envelope='{}' to topic='{}'", envelope, topic);
        kafkaTemplate.send(topic, envelope);
        kafkaTemplate.flush();
    }

}
