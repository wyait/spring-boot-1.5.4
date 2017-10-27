package com.wyait.boot.controller;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wyait.boot.HelloApplication;

/**
 * 
 * @项目名称：springboot
 * @类名称：HelloControllerTest
 * @类描述：第一个spring boot测试类
 * @创建人：wyait
 * @创建时间：2017年6月26日 上午11:38:28 
 * @version：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class HelloControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testHello() {
		fail("Not yet implemented");
	}

}
