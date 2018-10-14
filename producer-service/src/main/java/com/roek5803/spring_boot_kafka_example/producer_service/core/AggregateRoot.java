package com.roek5803.spring_boot_kafka_example.producer_service.core;

import java.util.ArrayList;
import java.util.List;

public class AggregateRoot<T> {

    protected List<T> events;

    AggregateRoot() {
        this.events = new ArrayList<>();
    }

    public List<T> getEvents() {
        return events;
    }

    public void clear() {
        events.clear();
    }
}
