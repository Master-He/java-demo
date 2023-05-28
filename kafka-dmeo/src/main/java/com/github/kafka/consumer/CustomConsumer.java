package com.github.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author hewenji
 * @Date 2023/5/27 23:53
 */
public class CustomConsumer {
    public static void main(String[] args) {

        // 0 配置
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.111:9092,192.168.0.112:9092,192.168.0.113:9092");
        // 反序列化
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        // 必须分配消费组id
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-01");

        // 1 创建一个消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // 2. 订阅主题 first
        List<String> topics = new ArrayList<>();
        topics.add("first");
        consumer.subscribe(topics);

        // 3. 消费数据
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record);
                System.out.println(record.value());
            }
        }
    }
}
