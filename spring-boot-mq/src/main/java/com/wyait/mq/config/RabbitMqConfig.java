package com.wyait.mq.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @项目名称：spring-boot-mq
 * @类名称：RabbitMqConfig
 * @类描述：rabbitMQ配置类
 * @创建人：wyait
 * @创建时间：2017年9月14日 下午3:16:30 
 * @version：
 */
@Configuration
//@EnableRabbit  
//@EnableConfigurationProperties(RabbitProperties.class) 
public class RabbitMqConfig {

	/**
	 * 
	 * @描述：指定消息格式转化器（jackson）
	 * @创建人：wyait
	 * @创建时间：2017年9月21日 上午10:42:14
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(new Jackson2JsonMessageConverter());
		return template;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
			ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(new Jackson2JsonMessageConverter());
		return factory;
	}

	/**
	 * 
	 * @描述：simple模式
	 * @创建人：wyait
	 * @创建时间：2017年9月14日 下午5:37:31
	 * @return
	 */
	@Bean
	public Queue helloQueue() {
		return new Queue("hello");
	}

	/**
	 * 
	 * @描述：work模式
	 * @创建人：wyait
	 * @创建时间：2017年9月14日 下午5:37:31
	 * @return
	 */
	@Bean
	public Queue workQueue() {
		return new Queue("workQueues");
	}

	// ******************subscribe订阅模式**********Start****************
	/**
	 * 
	 * @描述：subscribe订阅模式的队列A;
	 * @创建人：wyait
	 * @创建时间：2017年9月15日 下午3:24:31
	 * @return
	 */
	@Bean
	public Queue subscribeQueueA() {
		return new Queue("fanout.A");
	}

	/**
	 * 
	 * @描述：subscribe订阅模式的队列B;
	 * @创建人：wyait
	 * @创建时间：2017年9月15日 下午3:24:31
	 * @return
	 */
	@Bean
	public Queue subscribeQueueB() {
		return new Queue("fanout.B");
	}

	/**
	 * 
	 * @描述：subscribe订阅模式的队列C;
	 * @创建人：wyait
	 * @创建时间：2017年9月15日 下午3:24:31
	 * @return
	 */
	@Bean
	public Queue subscribeQueueC() {
		return new Queue("fanout.C");
	}

	/**
	 * 
	 * @描述：fanoutExchange交换机
	 * @创建人：wyait
	 * @创建时间：2017年9月15日 下午3:34:41
	 * @return
	 */
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}

	/**
	 * 
	 * @描述：subscribeQueue绑定fanoutExchange交换机
	 * @创建人：wyait
	 * @创建时间：2017年9月15日 下午3:41:10
	 * @param subscribeQueue
	 * @param fanoutExchange
	 * @return
	 */
	@Bean
	Binding bindingExchangeA(Queue subscribeQueueA,
			FanoutExchange fanoutExchange) {
		// 绑定队列A到fanoutExchange交换机，也可以使用：bind(subscribeQueueA())进行绑定;
		return BindingBuilder.bind(subscribeQueueA).to(fanoutExchange);
	}

	@Bean
	Binding bindingExchangeB(Queue subscribeQueueB,
			FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(subscribeQueueB).to(fanoutExchange);
	}

	@Bean
	Binding bindingExchangeC(Queue subscribeQueueC,
			FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(subscribeQueueC).to(fanoutExchange);
	}

	// ******************subscribe订阅模式**********End****************

	// ******************routing路由模式**********Start****************
	/**
	 * 
	 * @描述：routing路由模式的队列A;
	 * @创建人：wyait
	 * @创建时间：2017年9月15日 下午3:24:31
	 * @return
	 */
	@Bean
	public Queue routingQueueA() {
		return new Queue("routing.A");
	}

	/**
	 * 
	 * @描述：routing路由模式的队列B;
	 * @创建人：wyait
	 * @创建时间：2017年9月15日 下午3:24:31
	 * @return
	 */
	@Bean
	public Queue routingQueueB() {
		return new Queue("routing.B");
	}

	/**
	 * 
	 * @描述：DirectExchange交换机
	 * @创建人：wyait
	 * @创建时间：2017年9月15日 下午3:34:41
	 * @return
	 */
	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange("directExchange");
	}

	/**
	 * 
	 * @描述：routingQueue绑定directExchange交换机
	 * @创建人：wyait
	 * @创建时间：2017年9月15日 下午3:41:10
	 * @param routingQueue
	 * @param directExchange
	 * @return
	 */
	@Bean
	Binding bindingDirectExchangeA(Queue routingQueueA,
			DirectExchange directExchange) {
		// 绑定routing队列A到directExchange交换机,并指定routing路由规则;
		return BindingBuilder.bind(routingQueueA()).to(directExchange())
				.with("info");
	}

	@Bean
	Binding bindingDirectExchangeB(Queue routingQueueB,
			DirectExchange directExchange) {
		// 绑定routing队列A到directExchange交换机,并指定routing路由规则;
		return BindingBuilder.bind(routingQueueB()).to(directExchange())
				.with("error");
	}

	// ******************routing路由模式**********End******************

	// ******************topic通配符模式**********Start******************
	/**
	 * 
	 * @描述：topic通配符模式配置
	 * @创建人：wyait
	 * @创建时间：2017年9月16日 下午3:29:05
	 * @return
	 */
	@Bean
	public Queue topicQueueA() {
		return new Queue("topic.queueA", true); // true表示持久化该队列
	}

	@Bean
	public Queue topicQueueB() {
		return new Queue("topic.queueB", true);
	}

	// 声明交互器
	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange("topicExchange");
	}

	// 绑定
	@Bean
	public Binding bindingA() {
		return BindingBuilder.bind(topicQueueA()).to(topicExchange())
				.with("topic.message");
	}

	@Bean
	public Binding bindingB() {
		return BindingBuilder.bind(topicQueueB()).to(topicExchange())
				.with("topic.#");
	}

	// ******************topic通配符模式**********End******************

	// ******************配置消息监听和消息回调确认**********Start******************

	@Autowired
	private ConnectionFactory connectionFactory;

	/**
	 * 
	 * @描述：接受消息的监听，这个监听会接受消息队列topic.queueA的消息
	 * 针对消费者配置  
	 * @创建人：wyait
	 * @创建时间：2017年9月16日 下午4:00:23
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer messageContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(
				connectionFactory);
		container.setQueues(topicQueueA());
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(10);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // 设置确认模式手工确认
		container.setMessageListener(new ChannelAwareMessageListener() {

			public void onMessage(Message message,
					com.rabbitmq.client.Channel channel) throws Exception {
				byte[] body = message.getBody();
				System.out.println("*********** MessageListenerContainer-TopicQueueA 收到消息 : " + new String(body));
				channel.basicAck(message.getMessageProperties()
						.getDeliveryTag(), false); // 确认消息成功消费

			}

		});
		return container;
	}

	/**
	 * 
	 * @描述：接受消息的监听，这个监听会接受消息队列topic.queueB的消息
	 * 针对消费者配置  
	 * @创建人：wyait
	 * @创建时间：2017年9月16日 下午4:00:23
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer messageContainerB() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(
				connectionFactory);
		container.setQueues(topicQueueB());
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(10);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // 设置确认模式手工确认
		container.setMessageListener(new ChannelAwareMessageListener() {
			public void onMessage(Message message,
					com.rabbitmq.client.Channel channel) throws Exception {
				byte[] body = message.getBody();
				System.out.println("###### MessageListenerContainer-TopicQueueB 收到消息 : " + new String(body));
				channel.basicAck(message.getMessageProperties()
						.getDeliveryTag(), false); // 确认消息成功消费

			}

		});
		return container;
	}
	
	//****************************消息回调****************************//
	@Bean
	public Queue queue() {
		return new Queue("call.back.msg", true);
	}

	// 声明交互器
	@Bean
	TopicExchange callBacktopicExchange() {
		return new TopicExchange("callBackExchange");
	}

	// 绑定
	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(callBacktopicExchange())
				.with("callback.*");
	}
	
	/**
	 * 
	 * @描述：监听call.back.msg队列是否进入路由队列
	 * 针对消费者配置  
	 * @创建人：wyait
	 * @创建时间：2017年9月16日 下午4:00:23
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer queueMessageContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(
				connectionFactory);
		container.setQueues(queue());
		container.setExposeListenerChannel(true);
		//容器最大的消费者数目
		container.setMaxConcurrentConsumers(10);
		//Message Listener Container创建时创建的消费者数目
		container.setConcurrentConsumers(5);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // 设置确认模式手工确认
		container.setMessageListener(new ChannelAwareMessageListener() {
			public void onMessage(Message message,
					com.rabbitmq.client.Channel channel) throws Exception {
				byte[] body = message.getBody();
				System.out.println("###### returnCallBack 确认路由是否收到消息！消息内容 msg : " + new String(body));
				channel.basicAck(message.getMessageProperties()
						.getDeliveryTag(), true); // 手动确认消息成功消费

			}

		});
		return container;
	}

}
