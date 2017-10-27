package com.wyait.mq.subscribe;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.B")
public class SubscribeReceiverB {
	@RabbitHandler
	public void precess(String msg) {
		System.out.println("SubscribeReceiverB  : " + msg);
	}
}
