package com.roek5803.spring_boot_kafka_example.events.commons;

import java.util.Map;

public abstract class Adapter {
    public void close() {}
    public void configure(Map<String,?> configs, boolean isKey) {}
}
