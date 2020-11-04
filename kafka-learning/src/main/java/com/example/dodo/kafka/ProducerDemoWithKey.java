package com.example.dodo.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerDemoWithKey {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String bootstrapServers  = "127.0.0.1:9092";
        final Logger logger = LoggerFactory.getLogger(ProducerDemoWithKey.class);

        // create properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create producer
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        for(int i = 0 ; i<10; i++ ) {
            String topic = "first-topic";
            String value = "Hello World "+Integer.toString(i);
            String key = "id_"+Integer.toString(i);
            //create a producer
            ProducerRecord producerRecord = new ProducerRecord("first-topic", key, value);

            // send data
            kafkaProducer.send(producerRecord, new Callback() {

                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {
                        System.out.println(recordMetadata);
                        /**
                         logger.info("Topic: "+recordMetadata.topic()+"\n" +
                         "Partition: "+recordMetadata.partition()+"\n"+
                         "Offset: "+recordMetadata.partition() + "\n"+
                         "Timestamp: "+recordMetadata.timestamp());
                         */
                    } else {
                        e.printStackTrace();
                        //logger.error(e.getMessage());
                    }
                }
            }).get(); // block the send to make it synchronous
        }
        //topic,
        //                null, timestamp, key, auditorMessage

        //flush
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
