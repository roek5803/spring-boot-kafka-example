package com.roek5803.spring_boot_kafka_example.producer_service.database;

import com.roek5803.spring_boot_kafka_example.producer_service.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static com.roek5803.spring_boot_kafka_example.producer_service.database.translator.MessageTranslator.translate;

@Service
public class MessageQueryService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageQueryService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Optional<Message> get(String messageId) {

        try {
            return Optional.of(translate(messageRepository.getOne(messageId)));
        } catch (EntityNotFoundException ex) {
            return Optional.empty();
        }
    }

}
