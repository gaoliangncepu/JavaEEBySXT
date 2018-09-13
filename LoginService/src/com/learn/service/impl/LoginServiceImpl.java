package com.learn.service.impl;

import com.learn.dao.impl.UserDaoImpl;
import com.learn.pojo.User;
import com.learn.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean checkLogin(String name, String pwd) {
		User user = null;
		user = new UserDaoImpl().checkLoginMsg(name, pwd);

		if (null != user) {
			return true;
		} else {
			return false;
		}
	}

}
