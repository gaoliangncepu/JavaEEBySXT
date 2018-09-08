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
	 * servlet 初始化方法(non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("Servlet 初始化");
	}

	/*
	 * Servlet 核心服务方法(non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 返回信息至浏览器
		resp.getWriter().write("My second servlet");

		// 返回信息至服务器后台界面
		System.out.println("This is my second servlet");
	}

	/*
	 * Servlet 销毁方法(non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("Servlet 销毁");
	}

}
