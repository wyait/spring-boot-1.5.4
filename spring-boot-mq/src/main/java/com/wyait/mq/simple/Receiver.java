package com.wyait.mq.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @项目名称：spring-boot-mq
 * @类名称：Receiver
 * @类描述：简单模式：消息消费者C
 * @创建人：wyait
 * @创建时间：2017年9月14日 下午3:26:53 
 * @version：
 */
@Component
// 监听“hello”队列
@RabbitListener(queues = "hello")
public class Receiver {

	@RabbitHandler
	// handler注解来指定对消息的处理方法
	public void process(String hello) {
		System.out.println("Receiver:" + hello);
	}
}
