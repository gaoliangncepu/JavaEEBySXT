package com.learn;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 解析客户端请求数据中的信息
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
	}
}
