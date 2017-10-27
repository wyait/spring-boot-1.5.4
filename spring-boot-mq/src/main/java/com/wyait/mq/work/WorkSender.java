package com.wyait.mq.work;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * @项目名称：spring-boot-mq
 * @类名称：Sender
 * @类描述：work模式，消息生成者P
 * @创建人：wyait
 * @创建时间：2017年9月14日 下午3:23:54 
 * @version：
 */
@Component
public class WorkSender {
	@Autowired
	private AmqpTemplate rabbitMQTemplate;

	/**
	 * 
	 * @描述：work模式
	 * @创建人：wyait
	 * @创建时间：2017年9月14日 下午5:51:20
	 */
	public void workSend(String msg) {
		String context = msg + new Date();
		System.out.println("workSender : " + context);
		this.rabbitMQTemplate.convertAndSend("workQueues", context);
	}
}
