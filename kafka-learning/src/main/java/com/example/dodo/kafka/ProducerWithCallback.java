package com.example.dodo.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerWithCallback {


    public static void main(String[] args) {
        String bootstrapServers  = "127.0.0.1:9092";
        final Logger logger = LoggerFactory.getLogger(ProducerWithCallback.class);

        // create properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);
        //create a producer
        ProducerRecord producerRecord = new ProducerRecord("first-topic","Hello world3");

        // send data
        kafkaProducer.send(producerRecord, new Callback() {


            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(e != null){
                    System.out.println(recordMetadata);
                    /**
                    logger.info("Topic: "+recordMetadata.topic()+"\n" +
                            "Partition: "+recordMetadata.partition()+"\n"+
                            "Offset: "+recordMetadata.partition() + "\n"+
                            "Timestamp: "+recordMetadata.timestamp());
                     */
                }else {
                    logger.error(e.getMessage());
                }
            }
        });

        //flush
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
