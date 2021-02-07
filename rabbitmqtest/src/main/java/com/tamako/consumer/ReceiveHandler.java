package com.tamako.consumer;

import com.rabbitmq.client.Channel;
import com.tamako.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 描述：监听rabbitmq消息的消费者
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/12/23 14:54
 */
@Component
public class ReceiveHandler {

	@RabbitListener(queues = {RabbitConfig.QUEUE_INFORM_EMAIL})
	public void receiveEmail(String msg, Message message, Channel channel) {
		System.out.println("QUEUE_INFORM_EMAIL:");
		System.out.println(msg);
	}

	@RabbitListener(queues = {RabbitConfig.QUEUE_INFORM_SMS})
	public void receiveSms(String msg, Message message, Channel channel) {
		System.out.println("QUEUE_INFORM_SMS:");
		System.out.println(msg);
	}

}
