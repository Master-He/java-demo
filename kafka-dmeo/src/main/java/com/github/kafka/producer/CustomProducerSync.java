package com.github.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author hewenji
 * @Date 2023/5/27 10:24
 */
public class CustomProducerSync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 创建producer, 泛型K,V是指键序列化器Serializer<K>， 指序列化器Serializer<V>
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.111:9092,192.168.0.112:9092,192.168.0.113:9092");
        // properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.111:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,  StringSerializer.class.getName());
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        // 2. 同步发送数据, 最后面加get()就是同步
        RecordMetadata recordMetadata = kafkaProducer.send(new ProducerRecord<>("first", "我草")).get();

        // 3. 关闭资源
        kafkaProducer.close();
    }
}
