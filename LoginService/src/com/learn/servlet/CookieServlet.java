package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet cookie缓存
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		Cookie c1 = new Cookie("uname", uname);
		Cookie c2 = new Cookie("pwd", pwd);
		c1.setMaxAge(3*24*3600);
		resp.addCookie(c1);
		resp.addCookie(c2);
		
	}

}
