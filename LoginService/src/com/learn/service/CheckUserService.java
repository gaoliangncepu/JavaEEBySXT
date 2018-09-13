package com.learn.service;

import com.learn.pojo.User;

public interface CheckUserService {
	User checkUser(String name, String pwd);
	
	User checkUser(String uid);
}
