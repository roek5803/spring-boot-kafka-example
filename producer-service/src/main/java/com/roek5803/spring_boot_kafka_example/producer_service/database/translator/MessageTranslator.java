package com.roek5803.spring_boot_kafka_example.producer_service.database.translator;

import com.roek5803.spring_boot_kafka_example.producer_service.database.entities.Message;

public final class MessageTranslator {

    public static Message translate(com.roek5803.spring_boot_kafka_example.producer_service.core.Message message) {
        return Message.builder()
                .withId(message.getId())
                .withMessage(message.getMessage())
                .build();
    }

    public static com.roek5803.spring_boot_kafka_example.producer_service.core.Message translate(Message message) {
        return com.roek5803.spring_boot_kafka_example.producer_service.core.Message.builder()
                .withId(message.getId())
                .withMessage(message.getMessage())
                .build();
    }

}
