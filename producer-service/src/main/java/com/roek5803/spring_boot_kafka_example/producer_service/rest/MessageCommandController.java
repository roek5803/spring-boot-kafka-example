package com.roek5803.spring_boot_kafka_example.producer_service.rest;

import com.roek5803.spring_boot_kafka_example.producer_service.application.CommandHandler;
import com.roek5803.spring_boot_kafka_example.producer_service.application.commands.ChangeMessageCommand;
import com.roek5803.spring_boot_kafka_example.producer_service.application.commands.CreateMessageCommand;
import com.roek5803.spring_boot_kafka_example.producer_service.rest.dto.ChangeMessage;
import com.roek5803.spring_boot_kafka_example.producer_service.rest.dto.CreateMessage;
import com.roek5803.spring_boot_kafka_example.producer_service.rest.dto.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.roek5803.spring_boot_kafka_example.producer_service.rest.translator.MessageTranslator.translate;

@RestController
@RequestMapping(path = "/producer-service/api/v1/message")
public class MessageCommandController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageCommandController.class);

    private final CommandHandler commandHandler;

    @Autowired
    public MessageCommandController(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PostMapping(path = "/createMessage", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Message> createMessage(@Valid @RequestBody CreateMessage request) {
        LOGGER.debug("received: {}", request);

        return ResponseEntity.ok()
                .body(translate(commandHandler.handle(CreateMessageCommand.builder()
                        .withMessage(request.getMessage())
                        .build())));
    }

    @PostMapping(path = "/changeMessage", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Message> changeMessage(@Valid @RequestBody ChangeMessage request) throws Exception {
        LOGGER.debug("received: {}", request);

        commandHandler.handle(ChangeMessageCommand.builder()
                .withId(request.getId())
                .withMessage(request.getMessage())
                .build());

        return ResponseEntity.ok().build();
    }

}
