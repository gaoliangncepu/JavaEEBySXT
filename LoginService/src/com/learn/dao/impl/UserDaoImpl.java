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
		// JDBC ·ÃÎÊÊı¾İ¿â
		// µ¼°ü
		// ³õÊ¼»¯Á¬½Ó²ÎÊı
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			// ½¨Á¢Á¬½Ó
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/web_test", "root", "");
			// Æ´½ÓSQL
			String sql = "select * from tb_user where name = ? and pwd = ?";
			// ´´½¨preparedStatement
			preparedStatement = (PreparedStatement) conn.prepareStatement(sql);
			// Ìî³äÕ¼Î»·û
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pwd);
			// »ñÈ¡²éÑ¯½á¹û¼¯
			resultSet = preparedStatement.executeQuery();

			if (null != resultSet) {
				while (resultSet.next()) {
					user = new User();
					user.setName(resultSet.getString(1));
					user.setPwd(resultSet.getString(2));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Êı¾İ¿âÁ¬½ÓÊ§°Ü£¡");
			e.printStackTrace();
		} finally {
			// ¹Ø±ÕÁ¬½Ó
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
	 * ç”¨JDBCå®ç°æ•°æ®åº“è®¿é—®
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
			// åŠ è½½æ•°æ®åº“é©±åŠ¨å™¨
			Class.forName("com.mysql.jdbc.Driver");
			// è·å–è¿æ¥
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_test", "root", "Gl556313");
			String sql = new String("SELECT * FROM tb_user WHERE uname=? AND pwd = ?");
			pStatement = (PreparedStatement) conn.prepareStatement(sql);
			// è®¾ç½®å ä½ç¬¦å‚æ•°
			pStatement.setString(1, name);
			pStatement.setString(2, pwd);
			// è·å–ç»“æœé›†
			resultSet = pStatement.executeQuery();
			// å¤„ç†ç»“æœé›†
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
