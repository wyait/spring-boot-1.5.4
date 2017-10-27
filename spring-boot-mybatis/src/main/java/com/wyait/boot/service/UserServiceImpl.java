package com.wyait.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyait.boot.dao.UserMapper;
import com.wyait.boot.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUser(String name) {
		return this.userMapper.findUser(name);
	}

	@Override
	@Transactional
	public List<User> findPageUser(Integer pageNum, Integer pageSize) {
		User user = new User();
		user.setId(1L);
		user.setAge(28);
		int num = this.userMapper.update(user);
		User u = new User();
		u.setId(2L);
		u.setAge(37);
		int num1 = this.userMapper.update(u);
		//手动异常，测试事务是否可用。可用！！！
		//System.out.println(1 / 0);
		User uu = new User();
		uu.setId(2L);
		uu.setAge(37);
		int num2 = this.userMapper.update(uu);
		PageHelper.startPage(pageNum, pageSize);
		List<User> users = this.userMapper.findAllUser();
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		return pageInfo.getList();
	}

}
