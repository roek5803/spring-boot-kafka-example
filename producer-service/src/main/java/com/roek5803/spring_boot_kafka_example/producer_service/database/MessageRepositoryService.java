package com.roek5803.spring_boot_kafka_example.producer_service.database;

import com.roek5803.spring_boot_kafka_example.producer_service.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.roek5803.spring_boot_kafka_example.producer_service.database.translator.MessageTranslator.translate;

@Service
public class MessageRepositoryService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageRepositoryService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void save(Message message) {
        messageRepository.save(translate(message));
    }

}
