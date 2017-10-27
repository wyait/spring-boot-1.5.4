package com.wyait.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @项目名称：mybatis-spring-boot
 * @类名称：MyWebMvcConfig
 * @类描述：自定义静态资源映射路径和静态资源存放路径
 * @创建人：wyait
 * @创建时间：2017年6月30日 上午8:48:33 
 * @version：
 */
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations(
				"/images/");
		/*registry.addResourceHandler("/images/**").addResourceLocations(
				"file:D:/images/");*/
		super.addResourceHandlers(registry);
	}
	
	/*//自动注入spring boot默认的上传配置
	@Autowired
	private MultipartConfigElement multipartConfigElement;
	@Autowired
	private DispatcherServlet dispatcherServlet;
	@Bean
	public ServletRegistrationBean apiServlet() {
	    ServletRegistrationBean bean = new ServletRegistrationBean(dispatcherServlet);
	    //注入上传配置到自己注册的ServletRegistrationBean
	    bean.addUrlMappings("/api/*");
	    bean.setMultipartConfig(multipartConfigElement);
	    bean.setName("apiServlet");
	    return bean;
	}*/
}
