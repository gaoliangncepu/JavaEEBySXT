<<<<<<< HEAD
package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet ��¼ҳ��
 */
public class PageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");

		resp.getWriter().write("<form action='Login' method='GET'>");
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("��¼��:<input type='text' name='uname' value=''><br />");
		resp.getWriter().write("����:<input type='password' name='pwd' value=''><br />");
		resp.getWriter().write("<input type='submit' value='��¼'>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		resp.getWriter().write("</form>");
	}

}
=======
package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录界面 Servlet
 * 
 * @author Administrator
 *
 */
public class PageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		// req的作用域（获取值）:未设置值时，此处获取结果返回null
		boolean loginState = (null == req.getAttribute("loginState"))? true : (boolean) req.getAttribute("loginState");
		
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		if (!loginState) {
			resp.getWriter().write("<font color='red' size='20px'>用户名密码错误</font>");
		}
		resp.getWriter().write("<form action='login' method='get'>");
		resp.getWriter().write("用户名：<input type='text' name='uname' value=''><br />");
		resp.getWriter().write("密码：<input type='password' name='pwd' value=''><br />");
		resp.getWriter().write("<input type='submit' value='登录'>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		
	}
}
>>>>>>> 7855f92e285d962128c4ce3585e9bbfdc96665df
