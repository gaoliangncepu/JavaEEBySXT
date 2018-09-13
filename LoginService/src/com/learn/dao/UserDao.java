package com.learn.dao;

import com.learn.pojo.User;

public interface UserDao {
	User checkLoginMsg(String name, String pwd);
}
