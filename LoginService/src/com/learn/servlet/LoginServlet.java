package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learn.service.impl.LoginServiceImpl;

/**
 * ��¼����Servlet
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");

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
	}

}
