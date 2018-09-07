package com.learn;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����ͻ������������е���Ϣ
 */
public class RequestServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("RequestServlet");

		// �����е���Ϣ
		System.out.println("Request method:" + req.getMethod());
		System.out.println("Request URL:" + req.getRequestURL());
		System.out.println("Request URI:" + req.getRequestURI());
		System.out.println("Schema:" + req.getScheme());
		System.out.println("Protocol:" + req.getProtocol());

		// ����ͷ����Ϣ
		System.out.println("��ȡָ������ֵ:" + "Content-Type" + ":" + req.getHeader("Content-Type"));
		Enumeration<String> headerKeys = req.getHeaderNames();
		while (headerKeys.hasMoreElements()) {
			String headerName = (String) headerKeys.nextElement();
			System.out.println(headerName + ":" + req.getHeader(headerName));
		}

		// ���������Ϣ
		System.out.println("��ȡָ������ֵ:" + "uname:" + req.getParameter("uname"));
		System.out.println("��ȡָ������ֵ:" + "un:" + req.getParameter("un"));
		Enumeration<String> keys = req.getParameterNames();
		while (keys.hasMoreElements()) {
			String name = (String) keys.nextElement();
			System.out.println(name + ":" + req.getParameter(name));

		}
	}
}