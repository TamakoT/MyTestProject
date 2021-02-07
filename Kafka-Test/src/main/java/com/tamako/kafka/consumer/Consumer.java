package com.tamako.kafka.consumer;

import com.tamako.kafka.config.KafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

@Slf4j
public class Consumer {

	private static KafkaConsumer<String, String> consumer;

	static {
		Properties configs = initConfig();
		consumer = new KafkaConsumer<>(configs);
	}

	private static Properties initConfig() {
		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.BROKER_HOST);
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "0");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		return properties;
	}

	public static void main(String[] args) {
		consumer.subscribe(Collections.singletonList(KafkaConfig.TOPIC_NAME));
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(10);
			for (ConsumerRecord<String, String> record : records) {
				System.out.println(record.toString());
			}
		}
	}
}