package com.wyait.boot.service;

import java.util.List;

import com.wyait.boot.pojo.User;

public interface UserService {
	/**
	 * 
	 * @描述：根据名称查找用户信息
	 * @创建人：wyait
	 * @创建时间：2017年6月29日 上午11:28:56
	 * @param string
	 * @return
	 */
	User findUser(String string);

	/**
	 * 
	 * @描述：分页获取用户数据
	 * @创建人：wyait
	 * @创建时间：2017年6月29日 下午1:26:57
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	List<User> findPageUser(Integer pageNum, Integer pageSize);

}
