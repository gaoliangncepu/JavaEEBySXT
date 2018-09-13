package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Cookie创建
 * 
 * Cookie：
 * 	解决：
 * 		1.用户表单数据的客户端（浏览器）存储问题，如：用户名密码存储、免登陆
 * 		2.发送的不同请求之间的数据共享、传递问题
 * 	使用：
 * 		Cookie cookie = new Cookie(String name, String value);
		cookie.setMaxAge(int seconds);
		cookie.setPath(String uri);
		resp.addCookie(cookie);
		Cookie[] cookies = req.getCookies();// 没有Cookie信息时，此处返回null
	注意：
		1.一个Cookie对象只能存储一条信息，存储多条信息需要创建多个Cookie对象
		2.重定向 发送至少两个请求，因此Cookie此时发挥作用
	特点：
		1.Cookie存储在客户端，属于浏览器数据存储技术，分为临时存储和定时存储
		2.临时存储：存在浏览器运行内存中，浏览器关闭时失效
		3.定时存储：设置了Cookie的有效期，存在客户端的硬盘中，在有效期内访问有效路径时附带
		4.默认Cookie信息存好后，每次请求都会附带，除非设置了有效路径
 */
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		resp.getWriter().write("Cookie Learn");
		
		// 添加Cookie信息
		Cookie cookie1 = new Cookie("mouse", "ThinkPad");
		resp.addCookie(cookie1);
		
		// 设置有效期和有效路径
		Cookie cookie2 = new Cookie("keyBoard", "Lenovo");
		cookie2.setMaxAge(3*24*3600);// seconds
		cookie2.setPath("/Cookie/gc");//uri
		resp.addCookie(cookie2);
	}

}
