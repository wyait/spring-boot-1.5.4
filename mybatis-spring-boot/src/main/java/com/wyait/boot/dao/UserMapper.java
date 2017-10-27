package com.wyait.boot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.wyait.boot.pojo.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USER WHERE NAME = #{name}")
	public User findUser(@Param("name") String name);

	@Select("SELECT * FROM USER")
	public List<User> findAllUser();

	/**
	 * 
	 * @描述：更新用户信息
	 * @创建人：wyait
	 * @创建时间：2017年6月29日 下午1:33:09
	 * @param user
	 * @return
	 */
	@Update("update user set age=#{age} where id=#{id}")
	public int update(User user);
}
