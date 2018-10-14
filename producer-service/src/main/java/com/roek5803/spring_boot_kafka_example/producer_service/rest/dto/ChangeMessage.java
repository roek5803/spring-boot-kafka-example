package com.roek5803.spring_boot_kafka_example.producer_service.rest.dto;

public class ChangeMessage {

    private String id;
    private String message;

    public ChangeMessage() {}

    public ChangeMessage(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChangeMessage{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
