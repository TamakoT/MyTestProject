package com.tamako;

import com.tamako.config.RabbitConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * <p>
 * 描述：生产者5
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/12/23 14:49
 */
@SpringBootTest
public class Producer05 {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void sendEmailTest() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		while (!input.equalsIgnoreCase("q")) {
			//参数：1.交换机名称，2.routingKey，3.消息内容
			rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPICS_INFORM, "inform.sms", input);
			input = scanner.nextLine();
		}
	}

}
