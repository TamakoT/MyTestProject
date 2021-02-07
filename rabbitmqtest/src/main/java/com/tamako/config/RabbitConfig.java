package com.tamako.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

/**
 * <p>
 * 描述：RabbitMQ配置类
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/12/23 14:39
 */
public class RabbitConfig {

	/**
	 * 声明交换机和队列
	 */
	public static final String QUEUE_INFORM_EMAIL = "queue_inform_email";
	public static final String QUEUE_INFORM_SMS = "queue_inform_sms";
	public static final String EXCHANGE_TOPICS_INFORM = "exchange_topics_inform";
	public static final String ROUTINGKEY_EMAIL = "inform.#.email.#";
	public static final String ROUTINGKEY_SMS = "inform.#.sms.#";

	/**
	 * 声明TOPICS工作模式的交换机
	 *
	 * @return TOPICS工作模式的交换机
	 */
	@Bean(EXCHANGE_TOPICS_INFORM)
	public Exchange exchangeTopicsInform() {
		// durable(true) 表面重启之后交换机还在
		return ExchangeBuilder.topicExchange(EXCHANGE_TOPICS_INFORM).durable(true).build();
	}

	/**
	 * 声明QUEUE_INFORM_EMAIL队列
	 *
	 * @return QUEUE_INFORM_EMAIL队列
	 */
	@Bean(QUEUE_INFORM_EMAIL)
	public Queue queueInformEmail() {
		return new Queue(QUEUE_INFORM_EMAIL);
	}

	/**
	 * 声明QUEUE_INFORM_SMS队列
	 *
	 * @return QUEUE_INFORM_SMS队列
	 */
	@Bean(QUEUE_INFORM_SMS)
	public Queue queueInformSms() {
		return new Queue(QUEUE_INFORM_SMS);
	}

	/**
	 * 交换机与QUEUE_INFORM_EMAIL队列绑定
	 *
	 * @param queue    QUEUE_INFORM_EMAIL队列
	 * @param exchange TOPICS工作模式的交换机
	 * @return 交换机与QUEUE_INFORM_EMAIL队列绑定
	 */
	@Bean
	public Binding bindingQueueInformEmail(@Qualifier(QUEUE_INFORM_EMAIL) Queue queue,
	                                       @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_EMAIL).noargs();
	}

	/**
	 * 交换机与QUEUE_INFORM_SMS队列绑定
	 *
	 * @param queue    QUEUE_INFORM_SMS队列
	 * @param exchange TOPICS工作模式的交换机
	 * @return 交换机与QUEUE_INFORM_SMS队列绑定
	 */
	@Bean
	public Binding bindingQueueInformSms(@Qualifier(QUEUE_INFORM_SMS) Queue queue,
	                                     @Qualifier(EXCHANGE_TOPICS_INFORM) Exchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTINGKEY_SMS).noargs();
	}

}
