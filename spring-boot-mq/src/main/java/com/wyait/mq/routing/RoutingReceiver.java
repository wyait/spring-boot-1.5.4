package com.wyait.mq.routing;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 
 * @项目名称：spring-boot-mq
 * @类名称：RoutingReceiver
 * @类描述：路由模式：消息消费者
 * @创建人：wyait
 * @创建时间：2017年9月16日 下午2:37:00 
 * @version：
 */
@Component
@RabbitListener(queues = "routing.A")
public class RoutingReceiver {
	@RabbitHandler
	public void precess(String msg) {
		System.out.println("RoutingReceiverA === : " + msg);
	}

}
