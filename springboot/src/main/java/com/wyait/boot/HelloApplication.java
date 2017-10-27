package com.wyait.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @项目名称：springboot
 * @类名称：HelloApplication
 * @类描述：我的第一个springboot启动类
 * @创建人：wyait
 * @创建时间：2017年6月26日 上午11:28:57 
 * @version：1.0
 */
@Configuration//这是一个配置Spring的配置类
//@SpringBootApplication：Spring Boot项目的核心注解，主要目的是开启自动配置。
@SpringBootApplication(exclude={RedisAutoConfiguration.class})
public class HelloApplication {
	
	public static void main(String[] args) {
		//启动spring boot应用
		SpringApplication.run(HelloApplication.class, args);
	}
}
