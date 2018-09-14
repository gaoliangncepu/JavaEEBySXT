package com.learn.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextServlet2
 */
public class ServletContextServlet2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取ServletContext对象
		ServletContext sc = this.getServletContext();
		
		// 获取存储的信息
		String value = (String) sc.getAttribute("str");
		System.out.println(value);
		Enumeration<String> enumeration = sc.getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String string = (String) enumeration.nextElement();
			System.out.println(string);
		}
		
		// 获取webroot（根目录）下的资源文件的绝对路径
		String path = sc.getRealPath("/doc/temp.txt");
		System.out.println(path);
		
		// 获取项目公共配置参数
		String value2 = sc.getInitParameter("zhangsan");
		System.out.println(value2);
		Enumeration<String> initParameterNames = sc.getInitParameterNames();
		while (initParameterNames.hasMoreElements()) {
			String string = (String) initParameterNames.nextElement();
			System.out.println(string + ":" +sc.getInitParameter(string));
		}
		
		// 获取webroot(根目录)下资源文件的输入流
		InputStream resourceAsStream = sc.getResourceAsStream("/doc/temp.txt");
		
	}

}
