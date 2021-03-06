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
	 * 用JDBC实现数据库访问
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
			// 加载数据库驱动器
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_test", "root", "");
			String sql = new String("SELECT * FROM tb_user WHERE name=? AND pwd = ?");
			pStatement = (PreparedStatement) conn.prepareStatement(sql);
			// 设置占位符参数
			pStatement.setString(1, name);
			pStatement.setString(2, pwd);
			// 获取结果集
			resultSet = pStatement.executeQuery();
			// 处理结果集
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

	public User checkUser(int uid) {
		Connection conn = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		User user = null;

		try {
			// 加载数据库驱动器
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_test", "root", "");
			String sql = new String("SELECT * FROM tb_user WHERE uid=?");
			pStatement = (PreparedStatement) conn.prepareStatement(sql);
			// 设置占位符参数
			pStatement.setInt(1, uid);
			// 获取结果集
			resultSet = pStatement.executeQuery();
			// 处理结果集
			if (null != resultSet) {
				while (resultSet.next()) {
					user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
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

		return user;
	}

}
