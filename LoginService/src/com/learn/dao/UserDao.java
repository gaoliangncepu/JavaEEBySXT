<<<<<<< HEAD
package com.learn.dao;

import com.learn.pojo.User;

public interface UserDao {
	User checkLoginMsg(String name, String pwd);
}
=======
package com.learn.dao;

import java.util.List;

import com.learn.pojo.User;

public interface UserDao {
	List<User> checkUser(String name, String pwd);
}
>>>>>>> 7855f92e285d962128c4ce3585e9bbfdc96665df
