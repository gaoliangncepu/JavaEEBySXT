package com.learn.dao;

import java.util.List;

import com.learn.pojo.User;

public interface UserDao {
	List<User> checkUser(String name, String pwd);
	
	User checkUser(int uid);
}
