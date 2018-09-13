package com.learn;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解析客户端请求信息
 * 1.获取请求行的信息
 * 	getMethod()——获取请求方式
 * 	getSchema()——获取协议（http、https、ftp）
 * 	getProtocol()——获取协议版本
 * 	getRequestURL()——获取URL
 * 	getRequestURI()——获取URI
 * 2.获取请求头的信息（不存在查询的key时，不会报错，返回null）
 * 	getHeader("key_name")
 * 	getHeaderNames()
 * 3.获取请求体的信息（不存在查询的key时，不会报错，返回null）
 * 	getParameter("key_name")
 * 	getParameterNames()
 */
public class RequestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("RequestServlet");

		// 请求行的信息
		System.out.println("Request method:" + req.getMethod());
		System.out.println("Request URL:" + req.getRequestURL());
		System.out.println("Request URI:" + req.getRequestURI());
		System.out.println("Schema:" + req.getScheme());
		System.out.println("Protocol:" + req.getProtocol());

		// 请求头的信息
		System.out.println("获取指定键的值:" + "Content-Type" + ":" + req.getHeader("Content-Type"));
		Enumeration<String> headerKeys = req.getHeaderNames();
		while (headerKeys.hasMoreElements()) {
			String headerName = (String) headerKeys.nextElement();
			System.out.println(headerName + ":" + req.getHeader(headerName));
		}

		// 请求体的信息
		System.out.println("获取指定键的值:" + "uname:" + req.getParameter("uname"));
		System.out.println("获取指定键的值:" + "un:" + req.getParameter("un"));
		Enumeration<String> keys = req.getParameterNames();
		while (keys.hasMoreElements()) {
			String name = (String) keys.nextElement();
			System.out.println(name + ":" + req.getParameter(name));

		}
		// 相同的键对应多个取值时
		String[] favourites = req.getParameterValues("like");// 不存在键值时不会报错，返回null，因此下文操作必须判断是否为null
		if (null != favourites) {
			for (String string : favourites) {
				System.out.println(string);
			}
		}
	}
}
