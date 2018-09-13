package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.pojo.User;

/**
 * Servlet 主界面
 */
public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		User user = (User)req.getSession().getAttribute("user");
		
		resp.getWriter().write("<hrml>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("<h1>欢迎用户：" + user.getUserName() + "登录系统</h1>");
		resp.getWriter().write("<hr />");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</hrml>");
		
	}

}
