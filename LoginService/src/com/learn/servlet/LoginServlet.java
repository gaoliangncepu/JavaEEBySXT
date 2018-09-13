package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.learn.service.impl.LoginServiceImpl;
=======
import com.learn.pojo.User;
import com.learn.service.impl.CheckUserServiceImpl;
>>>>>>> 7855f92e285d962128c4ce3585e9bbfdc96665df

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
 *  所有Servlet的请求数据都是同一个req，因此浏览器显示的请求URL不会变；
 * 	req.getRequestDispather("目标Servlet的别名或URI").forward(req, resp);
 * 	请求转发后直接return即可。
 * 六、req作用域
 * 	解决Select之间，逻辑处理过程数据的传递。
 * 	req.setAttribute(String name, String value);
 * 七、重定向
 * 	解决当前Servlet无法处理请求，需要将其转交给其他Servlet时；
 * 	解决使用请求转发会造成表单重复提交的问题；
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

<<<<<<< HEAD
		// �����û�����
		String name = req.getParameter("uname");
		String pwd = req.getParameter("pwd");

		// ҵ���߼�
		boolean state = new LoginServiceImpl().checkLogin(name, pwd);
		if (state) {
			resp.getWriter().write("��¼�ɹ���");
		} else {
			resp.getWriter().write("��¼ʧ�ܣ�");
		}
=======
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

>>>>>>> 7855f92e285d962128c4ce3585e9bbfdc96665df
	}

}
