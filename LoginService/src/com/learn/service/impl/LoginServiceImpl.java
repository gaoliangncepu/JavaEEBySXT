package com.learn.service.impl;

import java.util.List;

import com.learn.dao.impl.UserDaoImpl;
import com.learn.pojo.User;
import com.learn.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean checkLogin(String name, String pwd) {
		List<User> users = null;
		users = new UserDaoImpl().checkUser(name, pwd);

		if (null != users) {
			return true;
		} else {
			return false;
		}
	}

}
