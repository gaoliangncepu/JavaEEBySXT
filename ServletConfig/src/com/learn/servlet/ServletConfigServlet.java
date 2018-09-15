package com.learn.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig 学习
 * 		获取当前Servlet在web.xml中的独立配置参数
 * 		
 * 		ServletConfig sc = this.getServletConfig();
 * 		String value = sc.getInitParameter(String name)
 * 		Enumeration<String> initParameterNames = sc.getInitParameterNames();
 */
public class ServletConfigServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig sc = this.getServletConfig();
		System.out.println(sc.getInitParameter("charset"));
		Enumeration<String> initParameterNames = sc.getInitParameterNames();
	}

}
