package com.roek5803.spring_boot_kafka_example.consumer_service.application;

import com.roek5803.spring_boot_kafka_example.consumer_service.database.MessageRepository;
import com.roek5803.spring_boot_kafka_example.events.Envelope;
import com.roek5803.spring_boot_kafka_example.events.MessageChanged;
import com.roek5803.spring_boot_kafka_example.events.MessageCreated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventHandler.class);

    private final MessageRepository messageRepository;

    @Autowired
    public EventHandler(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void handle(Envelope envelope) {
        LOGGER.debug("handle {}", envelope);

        switch (envelope.getPayloadCase()) {
            case MESSAGE_CREATED:
                handle(envelope.getMessageCreated());
                break;
            case MESSAGE_CHANGED:
                handle(envelope.getMessageChanged());
                break;
            default:
                LOGGER.debug(String.format("%s is not implemented...", envelope.getPayloadCase()));
        }

    }

    private void handle(MessageCreated evt) {
        LOGGER.debug("handle event: {}", evt);
        messageRepository.save(evt.getId(), evt.getMessage());
    }

    private void handle(MessageChanged evt) {
        LOGGER.debug("handle event: {}", evt);
        messageRepository.save(evt.getId(), evt.getNewMessage());
    }

}
