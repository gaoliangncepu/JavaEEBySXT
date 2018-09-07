package com.learn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MySecondServlet
 */
public class MySecondServlet extends HttpServlet {

	/*
	 * servlet ��ʼ������(non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet ��ʼ��");
	}

	/*
	 * Servlet ���ķ��񷽷�(non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������Ϣ�������
		resp.getWriter().write("My second servlet");

		// ������Ϣ����������̨����
		System.out.println("This is my second servlet");
	}

	/*
	 * Servlet ���ٷ���(non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("Servlet ����");
	}

}