package com.wyait.mq.subscribe;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @项目名称：spring-boot-mq
 * @类名称：SubscribeSender
 * @类描述：订阅模式，指定交换机fanoutExchange
 * @创建人：wyait
 * @创建时间：2017年9月15日 下午4:26:38 
 * @version：
 */
@Component
public class SubscribeSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String msg) {
		String sendMsg = msg + new Date();
		System.out.println("---SubscribeSender : " + sendMsg);
		// convertAndSend(String exchange, String routingKey, Object message)
		this.rabbitTemplate.convertAndSend("fanoutExchange", "aaa", sendMsg);
	}

}
