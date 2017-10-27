package com.wyait.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wyait.boot.pojo.User;

@Mapper
public interface UserMapperXML {
	public User findUser(@Param("name") String name);

	public List<User> findAllUser();

	/**
	 * 
	 * @描述：更新用户信息
	 * @创建人：wyait
	 * @创建时间：2017年6月29日 下午1:33:09
	 * @param user
	 * @return
	 */
	public int update(User user);
}
