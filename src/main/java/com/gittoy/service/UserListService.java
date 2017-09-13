package com.gittoy.service;

import java.util.List;

import com.gittoy.bean.User;
import com.gittoy.dao.UserDao;

/**
 * 用户列表相关的业务功能
 * @author GaoYu
 */
public class UserListService {

	public List<User> getUserList(String name, String mobile, String email, String idcard) {
		UserDao userDao = new UserDao();
		return userDao.getUserList(name, mobile, email, idcard);
	}
}
