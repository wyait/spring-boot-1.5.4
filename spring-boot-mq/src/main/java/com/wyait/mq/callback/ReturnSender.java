package com.wyait.mq.callback;

import java.util.UUID;

import org.springframework.amqp.core.Message;
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
public class ReturnSender implements RabbitTemplate.ReturnCallback {

	private RabbitTemplate rabbitTemplate;

	/**
	 * 构造方法，注入rabbitTemplate
	 * @param rabbitTemplate
	 */
	public ReturnSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		// 设置消费回调
		this.rabbitTemplate.setReturnCallback(this);
		//this.rabbitTemplate.setMandatory(true);
	}

	public void confirmSend(String msg) {
		String uuid = UUID.randomUUID().toString();
		CorrelationData correlationId = new CorrelationData(uuid);
		System.out
				.println("========生产者：returnedMessage发送消息：" + correlationId.toString());
		rabbitTemplate.convertAndSend("callBackExchange", "callback.msg", msg,
				correlationId);
	}

	@Override
	public void returnedMessage(Message message, int replyCode,
			String replyText, String exchange, String routingKey) {
		System.out
				.println("^^^^^^ returnedMessage确认消息发送到routingKey! routingKey:"
						+ routingKey + ",message=" + message.toString());
	}
}
