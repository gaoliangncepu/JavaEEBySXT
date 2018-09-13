package com.learn.service.impl;

import java.util.List;

import com.learn.dao.impl.UserDaoImpl;
import com.learn.pojo.User;
import com.learn.service.CheckUserService;

public class CheckUserServiceImpl implements CheckUserService {

	@Override
	public User checkUser(String name, String pwd) {
		List<User> users = new UserDaoImpl().checkUser(name, pwd);
		if (null != users && users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	public User checkUser(String uid) {
		User user = new UserDaoImpl().checkUser(Integer.parseInt(uid));
		if (null != user) {
			return user;
		} else {
			return null;
		}
	}

}
