package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.learn.pojo.User;
import com.learn.service.impl.CheckUserServiceImpl;

/**
 * 登录业务处理及响应 Servlet 
 * 
 * 一、Servlet响应流程：
 * 	1.设置请求编码格式 
 * 	2.设置响应编码格式
 * 	3.获取请求数据信息 
 * 	4.业务逻辑处理
 * 	5.生成响应数据信息
 * 		//直接输出响应
 * 		//请求转发
 * 		//重定向
 * 二、设置请求编码格式：
 *  1.new String(req.getParameter("uname").getBytes("iso8859-1"), "utf-8");
 *  2.post方式的请求：req.setCharacterEncoding("utf-8")
 *  3.get方式的请求：req.setCharacterEncoding("utf-8") + TOMCAT_HOME/cfg/server.xml：useBodyEncodingForURI = "true" 
 * 三、设置响应编码格式：
 * 	resp.setContentType("text/plain;charset=utf-8") 
 * 	resp.setContentType("text/xml;charset=utf-8") 
 * 	resp.setContentType("text/html;charset=utf-8") 
 * 四、业务逻辑处理： 
 * 	MVC基本原则 
 * 五、请求转发
 * 	同一个请求需要多个Servlet处理时，从当前Servlet将请求传递至另一个Servlet；
 *  此过程中涉及的所有Servlet的请求数据都是同一个request，因此浏览器显示的请求URL不会变；
 * 	req.getRequestDispather("目标Servlet的别名或URI").forward(req, resp);
 * 	return;
 * 	请求转发后直接return即可。
 * 六、req作用域
 * 	解决Select之间，过程数据的传递。
 * 	req.setAttribute(String name, String value);
 * 	String value = req.getAttribute(String name);
 * 七、重定向
 * 	解决当前Servlet无法处理请求，需要将其转交给其他Servlet时；
 * 	解决使用请求转发会造成表单重复提交的问题；
 * 	resp.sendRedirect("目标Servlet的别名或URI");
 * 	重定向提交的请求与第一次的请求不同，且不带第一次请求的数据，因此需要Cookie技术进行数据存储的支持。
 * 八、Cookie
 * 	使用重定向或用户发起的多次请求之间，请求数据需要传递或共享时；
 * 	用Cookie对象存储数据，一个Cookie对象只能存储一组键值对，多组数据需要多个Cookie对象；
 * 	Cookie c = new Cookie(String name, String value);
 * 	resp.addCookie(cookie);
 * 	Cookie[] cs = req.getCookies();
 * 	临时存储：存在浏览器运行内存中，浏览器关闭时失效;
	定时存储：设置了Cookie的有效期，存在客户端的硬盘中，在有效期内访问有效路径时附带;
 * 九、session
 * 	解决同一用户的不同请求之间的数据共享问题。
 * 	在服务器端创建存储对象session，在一次会话中单例存在，使所有请求均可访问和修改，浏览器关闭时销毁。
 * 	HTTPSession session = req.getSession();
 * 	session.setAttribute(String name, Object value);
 * 	Object value = session.getAttribute(String name);
 * 	Enumation<String> enum = session.getAttributeNames();
 * 十、Servletcontect
 * 	解决项目中不同用户的不同请求之间数据共享问题。
 * 	在服务器端创建存储对象ServletContext，在整个项目生命周期中单例存在，使所有用户的所有请求均可访问和设置，项目关闭时销毁。
 * 	ServletContext sc = this.getServletContext();
 * 	sc.setAttribute(String name, Object value);
 * 	Object value = sc.getAttribute(String name);
 * 	Enumation<String> enum = sc.getAttributeNames();
 * 	String value = sc.getInitParameter(String name);
 * 	Enumeration<String> initParameterNames = sc.getInitParameterNames();
 * 	String path = sc.getRealPath(String relativePath);
 * 	InputStream resourceAsStream = sc.getResourceAsStream(String relativePath);
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		String uname;
		String pwd;
//		uname = new String(req.getParameter("uname").getBytes("iso8859-1"), "utf-8");
//		System.out.println(uname);
		req.setCharacterEncoding("utf-8");// post请求够了；get请求需要设置tomcat配置文件server.xml中配置：useBodyEncodingForURI="true"

		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");

		// 获取用户请求数据信息
		System.out.println(uname = req.getParameter("uname"));
		System.out.println(pwd = req.getParameter("pwd"));

		// 业务逻辑处理
		User user = new CheckUserServiceImpl().checkUser(uname, pwd);

		// 生成响应数据信息
		if (null != user) {
//			resp.getWriter().write("登录成功")
//			req.getRequestDispatcher("main").forward(req, resp);
//			return;
			
			// 使用Cookie存储用户首次成功登录时的信息，以实现定时免登陆
			Cookie c = new Cookie("uid", user.getUid()+"");
			c.setMaxAge(3*24*3600);
			c.setPath("/LoginService/ck");
			resp.addCookie(c);
			
			// 将用户信息存入session
			HttpSession session = req.getSession();
			session.setAttribute("user", user);
			
			// 统计登陆计数
			ServletContext servletContext = this.getServletContext();
			if (null == servletContext.getAttribute("nums")) {
				servletContext.setAttribute("nums", 0);
			}
			int nums = (int) servletContext.getAttribute("nums");
			nums += 1;
			servletContext.setAttribute("nums", nums);
			
			// 重定向
			resp.sendRedirect("main");
			return;
		} else {
			// request作用域（设置值）
			req.setAttribute("loginState", false);
			// 请求转发
			req.getRequestDispatcher("page").forward(req, resp);
			return;
		}

	}

}
