package com.wyait.mq.callback;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// 指定消息监听容器工厂，解析数据时使用指定的格式进行转换
 @RabbitListener(queues = "call.back.msg")
//@RabbitListener(queues = "call.back.msg", containerFactory = "simpleMessageListenerContainer")
public class ConfirmReceiver {
	@RabbitHandler
	public void precess(String msg) {
		System.out.println("--------------消费消息msg : " + msg);
	}
}
