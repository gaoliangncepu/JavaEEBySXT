package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.service.impl.LoginServiceImpl;

/**
 * 登录服务Servlet
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");

		// 处理用户请求
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");

		// 业务逻辑
		boolean state = new LoginServiceImpl().checkLogin(name, pwd);
		if (state) {
			resp.getWriter().write("登录成功！");
		} else {
			resp.getWriter().write("登录失败！");
		}
	}

}
