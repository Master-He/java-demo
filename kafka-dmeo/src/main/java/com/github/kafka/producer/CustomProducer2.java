package com.github.kafka.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * @author hewenji
 * @Date 2023/5/27 10:24
 */
public class CustomProducer2 {
    public static void main(String[] args) {
        // 1. 创建producer, 泛型K,V是指键序列化器Serializer<K>， 指序列化器Serializer<V>
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.111:9092,192.168.0.112:9092,192.168.0.113:9092");
        // properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.111:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,  StringSerializer.class.getName());

        // 缓冲区大小 也就是RecordAccumulator双端队里
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 64*1024*1024);
        // 批次大小
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16*1024);
        // linger.ms
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 1);
        // 压缩
        properties.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");

        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(properties);

        // 2. 发送数据
        kafkaProducer.send(new ProducerRecord<>("first", "测试producer的参数优化"));

        // 3. 关闭资源
        kafkaProducer.close();
    }
}
