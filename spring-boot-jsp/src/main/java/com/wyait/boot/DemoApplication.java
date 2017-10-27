package com.wyait.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 
 * @项目名称：springboot
 * @类名称：DemoApplication
 * @类描述：我的第一个springboot启动类
 * @创建人：wyait
 * @创建时间：2017年6月27日10:36:31
 * @version：1.0
 */
// 这是一个配置Spring的配置类
@Configuration
// @SpringBootApplication：Spring Boot项目的核心注解，主要目的是开启自动配置。
@SpringBootApplication
//@EnableScheduling//开启定时任务
//@EnableAsync
public class DemoApplication {

	public static void main(String[] args) {
		// 启动spring boot应用
		SpringApplication sa = new SpringApplication(DemoApplication.class);
		// 禁用devTools热部署
		System.setProperty("spring.devtools.restart.enabled", "false");
		// 禁用命令行更改application.properties属性
		sa.setAddCommandLineProperties(false);
		sa.run(args);
	}
}
