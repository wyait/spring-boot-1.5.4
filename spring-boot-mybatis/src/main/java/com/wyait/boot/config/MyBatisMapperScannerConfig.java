package com.wyait.boot.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @项目名称：spring-boot-mybatis
 * @类名称：MyBatisMapperScannerConfig
 * @类描述：MyBatis扫描接口，不配置的话，需要在Mapper接口上添加@Mapper注解
 * @创建人：wyait
 * @创建时间：2017年9月29日 上午9:40:22 
 * @version：
 */
@Configuration
// 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@AutoConfigureAfter(MybatisConfig.class)
public class MyBatisMapperScannerConfig {

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer
				.setSqlSessionFactoryBeanName("sqlSessionFactory");
		mapperScannerConfigurer.setBasePackage("com.wyait.boot.dao");
		return mapperScannerConfigurer;
	}

}