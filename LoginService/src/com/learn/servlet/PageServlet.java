package com.learn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet ��¼ҳ��
 */
public class PageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");

		resp.getWriter().write("<form action='Login' method='GET'>");
		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("��¼��:<input type='text' name='uname' value=''><br />");
		resp.getWriter().write("����:<input type='password' name='pwd' value=''><br />");
		resp.getWriter().write("<input type='submit' value='��¼'>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</html>");
		resp.getWriter().write("</form>");
	}

}
