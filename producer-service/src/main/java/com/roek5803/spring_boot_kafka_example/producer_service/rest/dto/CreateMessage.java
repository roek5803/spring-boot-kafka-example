package com.roek5803.spring_boot_kafka_example.producer_service.rest.dto;

public class CreateMessage {

    private String message;

    public CreateMessage() {}

    public CreateMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CreateMessage{" +
                "message='" + message + '\'' +
                '}';
    }

}
