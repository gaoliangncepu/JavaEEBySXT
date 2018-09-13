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
