<<<<<<< HEAD
package com.learn.dao.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learn.dao.UserDao;
import com.learn.pojo.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements UserDao {

	@Override
	public User checkLoginMsg(String name, String pwd) {
		User user = null;
		// JDBC 访问数据库
		// 导包
		// 初始化连接参数
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// 建立连接
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/web_test", "root", "");
			// 拼接SQL
			String sql = "select * from tb_user where name = ? and pwd = ?";
			// 创建preparedStatement
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			// 填充占位符
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pwd);
			// 获取查询结果集
			resultSet = preparedStatement.executeQuery();

			if (null != resultSet) {
				while (resultSet.next()) {
					user = new User();
					user.setName(resultSet.getString(1));
					user.setPwd(resultSet.getString(2));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("数据库连接失败！");
			e.printStackTrace();
		} finally {
			// 关闭连接
			if (null != resultSet) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return user;
	}

}
=======
package com.learn.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learn.dao.UserDao;
import com.learn.pojo.User;

public class UserDaoImpl implements UserDao {

	/*
	 * 鐢↗DBC瀹炵幇鏁版嵁搴撹闂�
	 * 
	 * @see com.learn.dao.UserDao#countUser(java.lang.String, java.lang.String)
	 */
	@Override
	public List<User> checkUser(String name, String pwd) {
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		List<User> users = null;

		try {
			// 鍔犺浇鏁版嵁搴撻┍鍔ㄥ櫒
			Class.forName("com.mysql.jdbc.Driver");
			// 鑾峰彇杩炴帴
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_test", "root", "Gl556313");
			String sql = new String("SELECT * FROM tb_user WHERE uname=? AND pwd = ?");
			pStatement = (PreparedStatement) conn.prepareStatement(sql);
			// 璁剧疆鍗犱綅绗﹀弬鏁�
			pStatement.setString(1, name);
			pStatement.setString(2, pwd);
			// 鑾峰彇缁撴灉闆�
			resultSet = pStatement.executeQuery();
			// 澶勭悊缁撴灉闆�
			if (null != resultSet) {
				users = new ArrayList<User>();
				while (resultSet.next()) {
					User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
					users.add(user);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != resultSet) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != pStatement) {
				try {
					pStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return users;
	}

}
>>>>>>> 7855f92e285d962128c4ce3585e9bbfdc96665df
