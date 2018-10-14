package com.roek5803.spring_boot_kafka_example.producer_service.application.commands;

public class CreateMessageCommand {

    public final String message;

    private CreateMessageCommand(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CreateMessageCommand{" +
                "message='" + message + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String message;

        public Builder withMessage(String message) {
            this.message = message;

            return this;
        }

        public CreateMessageCommand build() {
            return new CreateMessageCommand(message);
        }

    }

}
