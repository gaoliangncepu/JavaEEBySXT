package com.learn;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����ͻ���������Ϣ
 * 1.��ȡ�����е���Ϣ
 * 	getMethod()������ȡ����ʽ
 * 	getSchema()������ȡЭ�飨http��https��ftp��
 * 	getProtocol()������ȡЭ��汾
 * 	getRequestURL()������ȡURL
 * 	getRequestURI()������ȡURI
 * 2.��ȡ����ͷ����Ϣ�������ڲ�ѯ��keyʱ�����ᱨ������null��
 * 	getHeader("key_name")
 * 	getHeaderNames()
 * 3.��ȡ���������Ϣ�������ڲ�ѯ��keyʱ�����ᱨ������null��
 * 	getParameter("key_name")
 * 	getParameterNames()
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
		// ��ͬ�ļ���Ӧ���ȡֵʱ
		String[] favourites = req.getParameterValues("like");// �����ڼ�ֵʱ���ᱨ������null��������Ĳ��������ж��Ƿ�Ϊnull
		if (null != favourites) {
			for (String string : favourites) {
				System.out.println(string);
			}
		}
	}
}
