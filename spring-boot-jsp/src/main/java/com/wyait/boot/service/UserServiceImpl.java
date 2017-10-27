package com.wyait.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.wyait.boot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	// 自动注入jdbcTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 添加用户
	@Override
	public int create(int age, String name) {
		String sql = "insert into user(NAME, AGE) values(?, ?)";
		return this.jdbcTemplate.update(sql, name, age);
	}
}
