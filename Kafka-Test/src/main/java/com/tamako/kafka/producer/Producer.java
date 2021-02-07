package com.tamako.kafka.producer;

import com.tamako.kafka.config.KafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * <p>
 * 描述：kafka消费者
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/12/24 14:06
 */
@Slf4j
public class Producer {

	private static KafkaProducer<String, String> producer;

	//初始化生产者
	static {
		Properties configs = initConfig();
		producer = new KafkaProducer<>(configs);
	}

	/**
	 * 初始化配置
	 */
	private static Properties initConfig() {
		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConfig.BROKER_HOST);
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		return properties;
	}

	public static void main(String[] args) {

		//消息实体
		ProducerRecord<String, String> record;

		for (int i = 0; i < 1000; i++) {
			record = new ProducerRecord<>(KafkaConfig.TOPIC_NAME, "value" + (int) (10 * (Math.random())));

			//发送消息
			producer.send(record, (recordMetadata, e) -> {
				if (null != e) {
					log.info("send error" + e.getMessage());
				} else {
					System.out.println(String.format("offset:%s,partition:%s", recordMetadata.offset(), recordMetadata.partition()));
				}
			});

		}
		producer.close();

	}

}
