package com.roek5803.spring_boot_kafka_example.events.commons;

import com.google.protobuf.InvalidProtocolBufferException;
import com.roek5803.spring_boot_kafka_example.events.Envelope;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtoDeserializer extends Adapter implements Deserializer<Envelope> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProtoDeserializer.class);

    @Override
    public Envelope deserialize(final String topic, byte[] data) {
        LOGGER.debug("Event deserialize ... ");
        try {
            return Envelope.parseFrom(data);
        } catch (final InvalidProtocolBufferException e) {
            LOGGER.error("Received unparseable message", e);
            throw new RuntimeException("Received unparseable message " + e.getMessage(), e);
        }
    }

}
