package com.example.dodo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {

    public static void main(String[] args) {
        String bootstrapServers  = "172.0.0.1:9092";

        // create properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        //create a producer
        ProducerRecord producerRecord = new ProducerRecord("first-topic","Hello world2");

        // send data
        kafkaProducer.send(producerRecord);

        //flush
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
