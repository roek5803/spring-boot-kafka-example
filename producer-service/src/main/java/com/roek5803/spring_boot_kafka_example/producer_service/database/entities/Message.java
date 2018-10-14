package com.roek5803.spring_boot_kafka_example.producer_service.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
public class Message {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "MESSAGE", nullable = false)
    private String message;

    public Message() {}

    public Message(String id, String message) {
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
