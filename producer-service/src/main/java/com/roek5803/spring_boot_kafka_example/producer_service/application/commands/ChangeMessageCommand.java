package com.roek5803.spring_boot_kafka_example.producer_service.application.commands;

public class ChangeMessageCommand {

    public final String id;
    public final String newMessage;

    private ChangeMessageCommand(String id, String newMessage) {
        this.id = id;
        this.newMessage = newMessage;
    }

    @Override
    public String toString() {
        return "ChangeMessageCommand{" +
                "id='" + id + '\'' +
                ", newMessage='" + newMessage + '\'' +
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

        public ChangeMessageCommand build() {
            return new ChangeMessageCommand(id, message);
        }

    }

}
