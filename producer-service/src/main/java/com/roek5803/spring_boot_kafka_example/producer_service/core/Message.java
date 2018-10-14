package com.roek5803.spring_boot_kafka_example.producer_service.core;

import com.roek5803.spring_boot_kafka_example.events.Envelope;
import com.roek5803.spring_boot_kafka_example.events.MessageChanged;
import com.roek5803.spring_boot_kafka_example.events.MessageCreated;

import java.util.UUID;

public class Message extends AggregateRoot<Envelope> {

    private final String id;
    private String message;

    private Message(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public Message apply() {
        events.add(Envelope.newBuilder()
                .setEventId(UUID.randomUUID().toString())
                .setTimestamp(System.nanoTime())
                .setMessageCreated(MessageCreated.newBuilder()
                        .setId(id)
                        .setMessage(message)
                        .build())
                .build());

        return this;
    }

    public Message changeMessage(String message) {
        events.add(Envelope.newBuilder()
                .setEventId(UUID.randomUUID().toString())
                .setTimestamp(System.nanoTime())
                .setMessageChanged(MessageChanged.newBuilder()
                        .setId(id)
                        .setNewMessage(message)
                        .build())
                .build());

        this.message = message;

        return this;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private String message;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Message build() {
            return new Message(id, message);
        }

    }

}
