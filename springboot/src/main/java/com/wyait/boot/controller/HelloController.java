package com.wyait.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @项目名称：springboot
 * @类名称：HelloController
 * @类描述：第一个spring Boot Controller类
 * @创建人：wyait
 * @创建时间：2017年6月26日 上午11:35:19 
 * @version：
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		//System.out.println(1/0);
		return "hello spring boot!";
	}
	/**
	 * 
	 * @描述：跳转到thymeleaf页面
	 * @创建人：wyait
	 * @创建时间：2017年6月27日 上午9:30:44
	 * @param map
	 * @return
	 */
	@RequestMapping("/")
	public String toDemo(ModelMap map) {
		map.addAttribute("host", "http://wyait.blog.51cto.com");
		return "demo";
	}
}
