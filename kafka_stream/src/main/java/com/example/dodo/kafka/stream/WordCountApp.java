package com.example.dodo.kafka.stream;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KTable;

import java.util.Arrays;
import java.util.Properties;

public class WordCountApp {

    public static void main(String[] args) {

        Properties config = new Properties();
        config.setProperty(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
        config.setProperty(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.setProperty(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        config.setProperty(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        config.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        KStreamBuilder builder = new KStreamBuilder();

        //1 stream from kafka
        KStream<String, String> wordCountInput = builder.stream("word-count-input");

        KTable<String, Long> wordCount = wordCountInput
                //2 - map values to lowercase
                .mapValues( String::toLowerCase )
                // 3 - flatMap values split by space
                .flatMapValues( (lowercasedTextLine) -> Arrays.asList( lowercasedTextLine.split(" ")))
                // 4 - select key to apply a key (we discard the old value)
                .selectKey( (ignoredKey, word) -> word)
                // 5 - group by key
                .groupByKey()
                .count("Count");

        wordCount.to(Serdes.String(), Serdes.Long(), "word-count-output");

        KafkaStreams streams = new KafkaStreams(builder, config);
        streams.start();

        // print the topology
        System.out.println(streams.toString());

        //shutdown hook to close the application properly
        Runtime.getRuntime().addShutdownHook( new Thread(streams::close));

    }
}
