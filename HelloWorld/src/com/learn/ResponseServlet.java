package com.learn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成响应信息
 * 1.设置编码格式
 */
public class ResponseServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码格式
//		resp.setHeader("content-type", "text/html;charset=utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// resp.setContentType("text/xml;charset=utf-8");
		// resp.setContentType("text/plain;charset=utf-8");//普通文本

		// 设置响应行——设置状态码与状态描述信息
		// resp.sendError(404, "Not Found");

		// 设置响应头
		resp.setHeader("mouse", "band1");
		resp.setHeader("mouse", "band2");// 相同键值，新值替换旧值
		resp.addHeader("keyboard", "band3");
		resp.addHeader("keyboard", "band4");// 相同键值，直接添加，不会覆盖
		
		// 设置响应体
		resp.getWriter().write("<b>加粗的中文</b><br />");

	}
	

}
