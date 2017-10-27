package com.wyait.mq.simple;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @项目名称：spring-boot-mq
 * @类名称：Sender
 * @类描述：简单模式，消息生成者P
 * @创建人：wyait
 * @创建时间：2017年9月14日 下午3:23:54 
 * @version：
 */
@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitMQTemplate;

	/**
	 * 
	 * @描述：简单模式
	 * @创建人：wyait
	 * @创建时间：2017年9月14日 下午5:51:33
	 */
	public void send() {
		String context = "hello :" + new Date();
		System.out.println("Sender : " + context);
		this.rabbitMQTemplate.convertAndSend("hello", context);
	}

}
