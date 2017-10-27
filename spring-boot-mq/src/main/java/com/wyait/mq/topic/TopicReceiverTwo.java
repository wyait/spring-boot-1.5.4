package com.wyait.mq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.queueB", containerFactory = "rabbitListenerContainerFactory")
public class TopicReceiverTwo {
	@RabbitHandler
	public void precess(String msg) {
		System.out.println("TopicReceiverTwoB  : " + msg);
	}
}
