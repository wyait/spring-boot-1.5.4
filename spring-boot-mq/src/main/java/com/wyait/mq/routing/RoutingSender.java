package com.wyait.mq.routing;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @项目名称：spring-boot-mq
 * @类名称：RoutingSender
 * @类描述：路由模式：消息生产者
 * @创建人：wyait
 * @创建时间：2017年9月16日 下午2:35:43 
 * @version：
 */
@Component
public class RoutingSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String msg) {
		String sendMsg = msg + new Date();
		System.out.println("---RoutingSender : " + sendMsg);
		this.rabbitTemplate.convertAndSend("directExchange", "info", sendMsg);
	}

	public void sendTwo(String msg) {
		String sendMsg = msg + new Date();
		System.out.println("---RoutingSender TWO: " + sendMsg);
		this.rabbitTemplate
				.convertAndSend("directExchange", "infoTwo", sendMsg);
	}

	public void sendError(String msg) {
		String sendMsg = msg + new Date();
		System.out.println("---RoutingSender Error: " + sendMsg);
		this.rabbitTemplate.convertAndSend("directExchange", "error", sendMsg);
	}

	public void sendErrorTwo(String msg) {
		String sendMsg = msg + new Date();
		System.out.println("---RoutingSender ErrorTwo: " + sendMsg);
		this.rabbitTemplate.convertAndSend("directExchange", "errorTwo",
				sendMsg);
	}

}
