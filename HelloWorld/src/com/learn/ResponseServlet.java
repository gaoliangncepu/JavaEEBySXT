package com.learn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ������Ӧ��Ϣ
 * 1.���ñ����ʽ
 */
public class ResponseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���ñ����ʽ
//		resp.setHeader("content-type", "text/html;charset=utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// resp.setContentType("text/xml;charset=utf-8");
		// resp.setContentType("text/plain;charset=utf-8");//��ͨ�ı�

		// ������Ӧ�С�������״̬����״̬������Ϣ
		// resp.sendError(404, "Not Found");

		// ������Ӧͷ
		resp.setHeader("mouse", "band1");
		resp.setHeader("mouse", "band2");// ��ͬ��ֵ����ֵ�滻��ֵ
		resp.addHeader("keyboard", "band3");
		resp.addHeader("keyboard", "band4");// ��ͬ��ֵ��ֱ����ӣ����Ḳ��
		
		// ������Ӧ��
		resp.getWriter().write("<b>�Ӵֵ�����</b><br />");

	}
	

}
