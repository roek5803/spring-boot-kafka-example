package com.roek5803.spring_boot_kafka_example.consumer_service.database;

import java.util.List;

public interface MessageRepository {

    List<String> getAll();

    String get(String id);

    void save(String id, String message);

}
