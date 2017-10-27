package com.wyait.boot.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

import com.wyait.boot.demo.Task;
import com.wyait.boot.pojo.Cat;
import com.wyait.boot.properties.ParamProperties;
import com.wyait.boot.redis.RedisService;
import com.wyait.boot.service.CatService;

@Controller
@RequestMapping("/cat")
public class CatController {
	@Autowired
	private CatService catService;
	@Autowired
	private ParamProperties paramProperties;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CatController.class);

	@ApiIgnore
	@RequestMapping("/wyait")
	@ResponseBody
	public String getMsg(HttpServletResponse response) {
		LOGGER.debug("===========debug信息>>>>" + paramProperties);
		LOGGER.info("===========info信息>>>>" + paramProperties);
		LOGGER.trace("I am trace log.");
		LOGGER.debug("I am debug log.");
		LOGGER.warn("I am warn log.");
		LOGGER.error("I am error log.");
		// 手动异常
		System.out.println(1 / 0);
		// 会有中文乱码问题 TODO
		return paramProperties.getWyaitName() + " 正在写"
				+ paramProperties.getWyaitTitle() + "!总结："
				+ paramProperties.getWyaitMessage();
	}

	/**
	 * 
	 * @描述：查询cat数据
	 * @创建人：wyait
	 * @创建时间：2017年6月27日 下午3:54:20
	 * @return
	 */
	@ApiOperation(value = "获取猫数据", notes = "根据猫名称获取猫数据")
	@RequestMapping(value = "/findCat", method = RequestMethod.POST)
	@ResponseBody
	public Cat findUser(@RequestParam("name") String name) {
		Cat c = this.catService.findCat(name);
		return c;
	}

	/**
	 * 
	 * @描述：查询cat数据
	 * @创建人：wyait
	 * @创建时间：2017年6月27日 下午3:54:20
	 * @return
	 */
	@ApiOperation(value = "查询", notes = "根据name获取cat数据")
	@ApiImplicitParam(name = "name", value = "猫名称", required = true, dataType = "String")
	@RequestMapping(value = "/findByName", method = RequestMethod.GET)
	@ResponseBody
	public Cat findByName(@RequestParam("name") String name) {
		System.out.println("=================请求参数name:" + name);
		Cat c = this.catService.findByName(name);
		return c;
	}

	@ApiOperation(value = "更新猫详细信息", notes = "根据url的id来指定更新对象，并根据传过来的cat信息来更新猫详细信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "猫ID", required = true, dataType = "Long"),
			@ApiImplicitParam(name = "cat", value = "猫详细实体cat", required = true, dataType = "Cat") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public String putUser(@PathVariable Long id, Cat cat) {
		System.out.println("=================put请求参数id:" + id);
		// 处理"/cats/{id}"的PUT请求，用来更新cat信息
		this.catService.update(cat);
		return "success";
	}

	@ApiOperation(value = "删除操作", notes = "根据id删除猫数据")
	@ApiImplicitParam(name = "id", value = "猫Id", required = true, dataType = "Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@PathVariable Long id) {
		System.out.println("=================delete请求参数id:" + id);
		// 删除cat
		this.catService.delete(id);
		return "success";
	}

	@Autowired
	private Task task;

	@ApiIgnore
	@RequestMapping("/test")
	public void getTest() {
		try {
			task.doTaskOne();
			task.doTaskTwo();
			task.doTaskThree();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@ApiIgnore
	@RequestMapping("/test1")
	public void getTest1() {
		try {
			long start = System.currentTimeMillis();
			Future<String> task1 = task.doTaskOne();
			Future<String> task2 = task.doTaskTwo();
			Future<String> task3 = task.doTaskThree();
			while (true) {
				if (task1.isDone() && task2.isDone() && task3.isDone()) {
					// 三个任务都调用完成，退出循环等待
					break;
				}
				Thread.sleep(1000);
			}
			long end = System.currentTimeMillis();
			System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Autowired
	private RedisService redisService;

	@RequestMapping("/setCatRedis")
	@ResponseBody
	public String setRedis() {
		try {
			Cat cat = new Cat("小黑", 5);
			redisService.set("token:cat1", cat, 5000L);
			Cat c = new Cat("小花", 6);
			redisService.set("token:cat2", c, 5000L);
			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "fail";
	}

}
