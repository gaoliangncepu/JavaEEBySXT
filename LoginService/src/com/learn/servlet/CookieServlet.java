package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learn.pojo.User;
import com.learn.service.impl.CheckUserServiceImpl;

/**
 * Servlet cookie缓存
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		User user = null;
		Cookie[] cookies = req.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if ("uid".equals(cookie.getName())) {
					user = new CheckUserServiceImpl().checkUser(cookie.getValue());
					break;
				}
			}
			if (null != user) {
				// 将用户信息存入session
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				
				// 设置统计递增
				int nums = (int) this.getServletContext().getAttribute("nums");
				nums += 1;
				this.getServletContext().setAttribute("nums", nums);
				
				// Cookie校验成功，重定向到主页面
				resp.sendRedirect("main");
				return;
			} else {
				// Cookie校验不通过，重定向到登陆界面
				req.getRequestDispatcher("login").forward(req, resp);
				return;
			}
		} else {
			// 没有存Cookie信息，转到登录验证Servlet
			req.getRequestDispatcher("login").forward(req, resp);
			return;
		}
	}

}
