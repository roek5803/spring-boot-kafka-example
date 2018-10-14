package com.roek5803.spring_boot_kafka_example.producer_service.rest.translator;

import com.roek5803.spring_boot_kafka_example.producer_service.rest.dto.Message;

public final class MessageTranslator {

    public static Message translate(com.roek5803.spring_boot_kafka_example.producer_service.core.Message message) {
        return Message.builder()
                .withId(message.getId())
                .withMessage(message.getMessage())
                .build();
    }

}
