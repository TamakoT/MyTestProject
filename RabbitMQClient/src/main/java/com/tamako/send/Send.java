package com.tamako.send;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {
	private final static String QUEUE_NAME = "hello";

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("47.111.66.93");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("zyzt0919");
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel();) {
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String message = "Hello World!";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}
	}
}