package com.github.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author hewenji
 * @Date 2023/5/27 10:24
 */
public class CustomProducerPartition {
    public static void main(String[] args) {
        // 1. 创建producer, 泛型K,V是指键序列化器Serializer<K>， 指序列化器Serializer<V>
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.111:9092,192.168.0.112:9092,192.168.0.113:9092");
        // properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.111:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,  StringSerializer.class.getName());
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        // 2. 发送数据
        // 2.1 不带回调
        // 2.2 带回调
        kafkaProducer.send(new ProducerRecord<>("first", 0,"", "123123"), new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if(exception == null) {
                    System.out.println("主题："+ metadata.topic()+ ", 分区：" + metadata.partition());
                    System.out.println("");
                }
            }
        });

        // 3. 关闭资源
        kafkaProducer.close();
    }
}
