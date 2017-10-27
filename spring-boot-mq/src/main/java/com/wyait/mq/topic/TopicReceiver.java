package com.wyait.mq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// 指定消息监听容器工厂，解析数据时使用指定的格式进行转换
@RabbitListener(queues = "topic.queueA")
public class TopicReceiver {
	@RabbitHandler
	public void precess(String msg) {
		System.out.println("TopicReceiverA  : " + msg);
	}
}
