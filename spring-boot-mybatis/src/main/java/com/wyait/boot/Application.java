package com.wyait.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @项目名称：spring-boot-mybatis
 * @类名称：Application
 * @类描述：Springboot启动类
 * @创建人：wyait
 * @创建时间：2017年6月29日 上午11:03:12 
 * @version：
 */
// 这是一个配置Spring的配置类
@Configuration
// @SpringBootApplication：Spring Boot项目的核心注解，主要目的是开启自动配置，自动扫描该类同级包以及子包。
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// 启动spring boot应用
		SpringApplication sa = new SpringApplication(Application.class);
		// 禁用devTools热部署
		System.setProperty("spring.devtools.restart.enabled", "false");
		// 禁用命令行更改application.properties属性
		sa.setAddCommandLineProperties(false);
		sa.run(args);
	}
}
