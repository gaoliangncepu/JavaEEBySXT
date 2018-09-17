package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learn.pojo.User;

/**
 * Servlet implementation class ShowServlet
 */
public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		HttpSession session = req.getSession();
		User user = (User)req.getSession().getAttribute("user");
		
		resp.getWriter().write("<hrml>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("<h1>欢迎用户：" + user.getUserName() + "登录系统</h1>");
		resp.getWriter().write("<hr />");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<table border='1'>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<th>" + "用户名" + "</th>");
		resp.getWriter().write("<td>" + user.getUserName() + "</td>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("<tr>");
		resp.getWriter().write("<th>" + "密码" + "</th>");
		resp.getWriter().write("<td>" + user.getPwd() + "</td>");
		resp.getWriter().write("</tr>");
		resp.getWriter().write("</table>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</hrml>");
	}

}
