package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext 学习
 * 	解决：
 * 		不同用户的不同请求之间的数据共享问题。
 * 	方式：
 * 		在服务器端创建用于存放用户数据的ServletContext对象，此对象是一个全局单例对象，一个项目的生命周期中只能创建一个
 * 	ServletContext对象，且ServletContext对象的生命周期是从项目启动到项目停止。所有用户均有访问和修改ServletContext
 * 	对象信息的权限。
 * 	使用：
 * 		// 获取ServletContext对象的三种方式
		ServletContext sc1 = this.getServletContext();
		ServletContext sc2 = this.getServletConfig().getServletContext();
		ServletContext sc3 = req.getServletContext();
		ServletContext sc4 = req.getSession().getServletContext();
		// 获取存储的信息
		String value = (String) sc.getAttribute(String name);
		Enumeration<String> enumeration = sc.getAttributeNames();
		// 获取webroot（根目录）下的资源文件的绝对路径
		String path = sc.getRealPath(String relativePath);
		// 获取项目公共配置参数
		String value = sc.getInitParameter(String name);
		Enumeration<String> initParameterNames = sc.getInitParameterNames();
		// 获取webroot(根目录)下资源文件的输入流
		InputStream resourceAsStream = sc.getResourceAsStream(String relativePath);
 *
 */
public class ServletContextServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		// 获取ServletContext对象的三种方式
		ServletContext sc1 = this.getServletContext();
		ServletContext sc2 = this.getServletConfig().getServletContext();
		ServletContext sc3 = req.getServletContext();
		ServletContext sc4 = req.getSession().getServletContext();
		System.out.println(sc1 == sc2);
		System.out.println(sc1 == sc3);
		System.out.println(sc4 == sc2);
		
		// 设置存储信息
		sc1.setAttribute("str", "message");
	}
}
