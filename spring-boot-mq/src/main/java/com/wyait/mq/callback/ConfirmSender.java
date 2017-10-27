package com.wyait.mq.callback;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

/**
 * 
 * @项目名称：spring-boot-mq
 * @类名称：ConfirmSender
 * @类描述：消息回调确认
 * @创建人：wyait
 * @创建时间：2017年9月16日 下午5:31:40 
 * @version：
 */
@Component
public class ConfirmSender implements RabbitTemplate.ConfirmCallback {

	private RabbitTemplate rabbitTemplate;

	/**
	 * 构造方法，注入rabbitTemplate
	 * @param rabbitTemplate
	 */
	public ConfirmSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		// 设置消费回调
		this.rabbitTemplate.setConfirmCallback(this);
	}

	public void send(String msg) {
		String uuid = UUID.randomUUID().toString();
		CorrelationData correlationId = new CorrelationData(uuid);
		System.out.println("=====confirm===send发送消息："
				+ correlationId.toString());
		rabbitTemplate.convertAndSend("topicExchange", "topic.message", msg,
				correlationId);
	}

	public void sendTwo(String msg) {
		String uuid = UUID.randomUUID().toString();
		CorrelationData correlationId = new CorrelationData(uuid);
		System.out.println("========sendTwo发送消息：" + correlationId.toString());
		rabbitTemplate.convertAndSend("topicExchange", "topic.messages", msg,
				correlationId);
	}

	public void confirmSend(String msg) {
		String uuid = UUID.randomUUID().toString();
		CorrelationData correlationId = new CorrelationData(uuid);
		System.out.println("========生产者：confirmSend发送消息："
				+ correlationId.toString());
		rabbitTemplate.convertAndSend("callBackExchange", "callback.msg", msg,
				correlationId);
	}

	/**
	* 消息的回调，主要是实现RabbitTemplate.ConfirmCallback接口
	* 注意，消息回调只能代表成功消息发送到RabbitMQ服务器，不能代表消息被成功处理和接受
	*/
	public void confirm(CorrelationData correlationData, boolean ack,
			String cause) {
		System.out.println("### ConfirmSend确认消息发送到exchange! 回调id:"
				+ correlationData);
		if (ack) {
			System.out.println("### ConfirmSend确认消息发送到exchange! 消息成功消费");
		} else {
			System.out.println("### ConfirmSend确认消息发送到exchange! 消息消费失败:"
					+ cause + "\n重新发送");
		}
	}

}
