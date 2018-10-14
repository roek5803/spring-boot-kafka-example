package com.roek5803.spring_boot_kafka_example.events.commons;

import com.roek5803.spring_boot_kafka_example.events.Envelope;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoSerializer extends Adapter implements Serializer<Envelope> {

    private static final Logger logger = LoggerFactory.getLogger(ProtoSerializer.class);

    @Override
    public byte[] serialize(final String topic, final Envelope data) {
        logger.debug("Serialize ... {}", data.toString());
        return data.toByteArray();
    }

}