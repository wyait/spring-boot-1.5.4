package com.wyait.mq.topic;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @项目名称：spring-boot-mq
 * @类名称：TopicSender
 * @类描述：通配符模式：消息生产者
 * @创建人：wyait
 * @创建时间：2017年9月16日 下午3:19:00 
 * @version：
 */
@Component
public class TopicSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String msg) {
		String sendMsg = msg + new Date();
		System.out.println("---TopicSender : " + sendMsg);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message",
				sendMsg);
	}

	public void sendTwo(String msg) {
		String sendMsg = msg + new Date();
		System.out.println("---TopicSender messages: " + sendMsg);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages",
				sendMsg);
	}

}
