package com.learn.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class NumServlet
 * 将该Servlet在web.xml中配置为<load-on-startup>，则tomcat服务器启动时进行初始化，
 * 并执行init()方法，从项目路径下的文件中读取存储的信息。在tomcat服务器关闭时执行destroy方法，
 * 将信息存储到项目路径下的本地文件中。
 */
public class NumServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		ServletContext servletContext = this.getServletContext();
		
		BufferedReader br = null;
		FileReader fr = null;
		String path = servletContext.getRealPath("/doc/temp.txt");
		
		try {
			fr = new FileReader(new File(path));
			br = new BufferedReader(fr);
			
			int nums = Integer.parseInt(br.readLine());
			
			servletContext.setAttribute("nums", nums);
		} catch (Exception e) {
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				fr.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void destroy() {
		ServletContext servletContext = this.getServletContext();
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		String path = servletContext.getRealPath("/doc/temp.txt");
		
		try {
			fw = new FileWriter(new File(path));
			bw = new BufferedWriter(fw);
			
			int nums;
			if (null == servletContext.getAttribute("nums")) {
				nums = 0;
			} else {
				nums = (int) servletContext.getAttribute("nums");
			}
			
			bw.write(nums);
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
