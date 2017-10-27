package com.wyait.mq.subscribe;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.C")
public class SubscribeReceiverC {
	@RabbitHandler
	public void precess(String msg) {
		System.out.println("SubscribeReceiverC  : " + msg);
	}
}
