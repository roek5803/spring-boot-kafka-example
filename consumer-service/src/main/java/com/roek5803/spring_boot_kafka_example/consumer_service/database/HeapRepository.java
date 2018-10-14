package com.roek5803.spring_boot_kafka_example.consumer_service.database;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class HeapRepository implements MessageRepository {

    private final Map<String, String> messageById;

    public HeapRepository() {
        this.messageById = new HashMap<>();
    }

    @Override
    public List<String> getAll() {
        return new ArrayList<>(messageById.values());
    }

    @Override
    public String get(String id) {
        return messageById.get(id);
    }

    @Override
    public void save(String id, String message) {
        messageById.put(id, message);
    }

}
