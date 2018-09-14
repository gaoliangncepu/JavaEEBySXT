package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Session
 * 	解决：
 * 		同一用户在多次提交的不同请求之间进行数据共享
 * 	原理：
 * 		用户第一次发送请求 并创建session对象时，将需要共享的数据打包在创建的session对象中，
 * 	并将该session对象的唯一标识JSESSIONID使用Cookie技术存储在客户端，保证客户端发起的
 * 	多个不同请求能够根据JSESSIONID获取到同一个session对象，实现数据共享。
 * 	使用：
 * 		HttpSession session = req.getSession();// 创建或获取session对象
 * 			1.如果请求中有JSESSIONID的Cookie信息，则返回其对应的session对象；
 * 			2.如果请求中没有JSESSIONID的Cookie信息，则创建并返回新的session对象，并存储Cookie信息；
 * 			3.如果session对象失效了，也会创建一个session对象返回，并存储JSESSIONID的Cookie信息。
 * 		session.setAttribute(String name, Object value);// 设置存储值
 * 		session.getAttributeNames();
 * 		session.setMaxInactiveInterval(int seconds);// 设置session的有效期限，默认30秒
 * 		session.invalidate();// session 的手动销毁
 * 		Object obj = session.getAttribute(String name);//获取session信息
 * 	特点：
 * 		1.session 的生命周期是一个会话内（从session创建到浏览器关闭或session到期时session销毁）
 * 		2.session 实际创建在服务器端，可供同一用户发起的多次不同的请求共同访问；
 * 		3.session 的默认有效期是30min，在指定时间内session对象没有被获取则到期销毁，否则重新开始计时；
 * 		4.JSESSIONID 存储在浏览器的运行内存中，浏览器关闭则失效；
 * 		5.session信息的存储和获取发生在不同的请求中，存储要先于获取执行；
 * 	时机：
 * 		一般用户在登录web项目时，会将其个人用户信息存储在session中，共后续请求调用。
 * 	总结：
 * 		session 解决了同一个用户的多次不同请求之间的数据共享问题，只有在JSESSIONID不失效和session对象不失效的情况下，
 * 	用户的任意请求都会获取到同一个session对象。（单例模式的应用）
 */
public class SessionServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String msg = "message";
		
		// 创建/获取session
		HttpSession session = req.getSession();
		session.setAttribute("msg", msg);
		
		// 设置session的存储时间
//		session.setMaxInactiveInterval(30*60);
		
		System.out.println(session.getId());
		System.out.println(session.getMaxInactiveInterval());
	}

}
