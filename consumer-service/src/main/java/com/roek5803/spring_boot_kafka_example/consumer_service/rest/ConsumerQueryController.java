package com.roek5803.spring_boot_kafka_example.consumer_service.rest;


import com.roek5803.spring_boot_kafka_example.consumer_service.database.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/consumer-service/api/v1/message", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ConsumerQueryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerQueryController.class);

    private final MessageRepository messageRepository;

    @Autowired
    public ConsumerQueryController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping()
    public ResponseEntity<List<String>> get() {
        LOGGER.debug("Get all messages");
        return ResponseEntity.ok().body(messageRepository.getAll());
    }

    @GetMapping(path = "{messageId}")
    public ResponseEntity<String> get(@PathVariable("messageId") String messageId) {
        LOGGER.debug("Get all messages");
        return ResponseEntity.ok().body(messageRepository.get(messageId));
    }

}
