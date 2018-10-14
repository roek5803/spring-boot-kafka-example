package com.roek5803.spring_boot_kafka_example.producer_service.database;

import com.roek5803.spring_boot_kafka_example.producer_service.database.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
}
