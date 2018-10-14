package com.roek5803.spring_boot_kafka_example.producer_service.application;

import com.roek5803.spring_boot_kafka_example.producer_service.application.commands.ChangeMessageCommand;
import com.roek5803.spring_boot_kafka_example.producer_service.application.commands.CreateMessageCommand;
import com.roek5803.spring_boot_kafka_example.producer_service.application.services.Producer;
import com.roek5803.spring_boot_kafka_example.producer_service.core.Message;
import com.roek5803.spring_boot_kafka_example.producer_service.database.MessageQueryService;
import com.roek5803.spring_boot_kafka_example.producer_service.database.MessageRepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommandHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandHandler.class);

    private final MessageRepositoryService messageRepositoryService;
    private final MessageQueryService messageQueryService;
    private final Producer producer;

    @Autowired
    public CommandHandler(MessageRepositoryService messageRepositoryService,
                          MessageQueryService messageQueryService,
                          Producer producer) {
        this.messageRepositoryService = messageRepositoryService;
        this.messageQueryService = messageQueryService;
        this.producer = producer;
    }

    public Message handle(CreateMessageCommand cmd) {
        LOGGER.debug("handle {}", cmd);

        Message message = Message.builder()
                .withId(UUID.randomUUID().toString())
                .withMessage(cmd.message)
                .build()
                .apply();

        messageRepositoryService.save(message);

        producer.send(message.getEvents());

        message.clear();

        return message;
    }

    public void handle(ChangeMessageCommand cmd) throws Exception {
        LOGGER.debug("handle {}", cmd);

        Message message = messageQueryService.get(cmd.id)
                .orElseThrow(() -> new Exception("Could not find Message for given id."));


        message.changeMessage(cmd.newMessage);

        producer.send(message.getEvents());

        message.clear();
    }

}
