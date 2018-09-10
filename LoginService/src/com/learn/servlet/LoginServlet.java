package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.service.impl.CheckUserServiceImpl;

/**
 * 登录业务处理及响应 Servlet 
 * 设置请求编码格式 
 * 设置响应编码格式
 * 获取请求数据信息 
 * 业务逻辑处理
 * 生成响应数据信息
 * 设置请求编码格式：
 *  ①.new String(req.getParameter("uname").getBytes("iso8859-1"), "utf-8");
 *  ②.post方式的请求：req.setCharacterEncoding("utf-8")
 *  ③.get方式的请求：req.setCharacterEncoding("utf-8") + Tomcat/server.xml：useBodyEncodingForURI = "true" 
 * 设置响应编码格式：
 * 	resp.setContentType("text/html;charset=utf-8") 
 * 业务逻辑处理： 
 * 	MVC基本原则 
 * 请求转发
 * 	同一个请求需要多个Servlet处理时，从当前Servlet将请求传递至另一个Servlet；
 * 	req.getRequestDispather("目标Servlet的别名").forward(req, resp);
 * 	所有Servlet的请求数据都是同一个req，因此浏览器显示的请求URL不会变；
 * 	请求转发后直接return即可。
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		String uname;
		String pwd;
//		uname = new String(req.getParameter("uname").getBytes("iso8859-1"), "utf-8");
//		System.out.println(uname);
		req.setCharacterEncoding("utf-8");// post请求够了；get请求需要设置tomcat配置文件server.xml中配置：useBodyEncodingForURI="true"

		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");

		// 获取用户请求数据信息
		System.out.println(uname = req.getParameter("uname"));
		System.out.println(pwd = req.getParameter("pwd"));

		// 业务逻辑处理
		boolean status = new CheckUserServiceImpl().checkUser(uname, pwd);

		// 生成响应数据信息
		if (status) {
			resp.getWriter().write("登录成功");
		} else {
			// 请求转发
			req.getRequestDispatcher("Page").forward(req, resp);
		}

	}

}
