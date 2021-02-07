package com.tamako.send;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;

public class NewTask {

	private static final String TASK_QUEUE_NAME = "task_queue";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("47.111.66.93");
		factory.setUsername("guest");
		factory.setPassword("zyzt0919");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

		String message = getMessage(new String[]{"你好", "世界", "都是时辰的错", "哈哈哈哈哈哈", "木大木大"});

		channel.basicPublish("", TASK_QUEUE_NAME,
				MessageProperties.PERSISTENT_TEXT_PLAIN,
				message.getBytes(StandardCharsets.UTF_8));
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
	}

	private static String getMessage(String[] strings) {
		if (strings.length < 1) {
			return "Hello World!";
		}
		return joinStrings(strings);
	}

	private static String joinStrings(String[] strings) {
		int length = strings.length;
		if (length == 0) {
			return "";
		}
		StringBuilder words = new StringBuilder(strings[0]);
		for (int i = 1; i < length; i++) {
			words.append(" ").append(strings[i]);
		}
		return words.toString();
	}
}