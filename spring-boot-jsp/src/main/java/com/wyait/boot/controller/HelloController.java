package com.wyait.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyait.boot.pojo.User;
import com.wyait.boot.service.UserService;

/**
 * 
 * @项目名称：springboot
 * @类名称：HelloController
 * @类描述：Controller类
 * @创建人：wyait
 * @创建时间：2017年6月27日10:40:07 
 * @version：
 */
@Controller
public class HelloController {

	/**
	 * 
	 * @描述：跳转到thymeleaf页面
	 * @创建人：wyait
	 * @创建时间：2017年6月27日10:40:22
	 * @param map
	 * @return
	 */
	@RequestMapping("/hello")
	public String toDemo(ModelMap map) {
		User user = new User();
		user.setId(5L);
		user.setAge(27);
		user.setName("张三123456");
		map.addAttribute("user", user);
		return "hello";
	}

	/**
	 * 
	 * @描述：跳转到thymeleaf页面
	 * @创建人：wyait
	 * @创建时间：2017年6月27日10:40:22
	 * @param map
	 * @return
	 */
	@RequestMapping("/hello1")
	public String toDemo1(ModelMap map) {
		User user = new User();
		user.setId(5L);
		user.setAge(27);
		user.setName("张三556");
		map.addAttribute("user", user);
		return "hello";
	}

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @描述：添加用户
	 * @创建人：wyait
	 * @创建时间：2017年6月27日10:40:22
	 * @param map
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(ModelMap map) {
		int num = this.userService.create(27, "李四");
		return num == 1 ? "ok" : "fail";
	}

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@RequestMapping("/setRedis")
	@ResponseBody
	public String setRedis() {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("token:aaa", "111");
		return "ok";
	}

}