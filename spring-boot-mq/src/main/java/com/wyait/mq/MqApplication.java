package com.wyait.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
//@EnableAutoConfiguration(exclude = RabbitAutoConfiguration.class)
public class MqApplication {
	public static void main(String[] args) {
		SpringApplication.run(MqApplication.class, args);
	}
}
