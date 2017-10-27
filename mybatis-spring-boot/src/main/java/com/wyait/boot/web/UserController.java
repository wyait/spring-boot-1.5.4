package com.wyait.boot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

import com.wyait.boot.pojo.User;
import com.wyait.boot.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
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
	@ApiIgnore
	@RequestMapping("/findUser")
	@ResponseBody
	public User findUser() {
		User user = this.userService.findUser("李四");
		return user;
	}

	/**
	 * 
	 * @描述：添加用户
	 * @创建人：wyait
	 * @创建时间：2017年6月27日10:40:22
	 * @param map
	 * @return
	 */
	@ApiIgnore
	@RequestMapping("/findPageUser")
	@ResponseBody
	public List<User> findUser(@RequestParam("pageNum") Integer pageNum,
			@RequestParam("pageSize") Integer pageSize) {
		if (null == pageNum) {
			pageNum = 1;
		}
		if (null == pageSize) {
			pageSize = 2;
		}
		List<User> user = this.userService.findPageUser(pageNum, pageSize);
		return user;
	}
}
