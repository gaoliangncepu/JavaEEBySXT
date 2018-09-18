<%@ page language="java" import="java.util.*,java.lang.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page session="true" %>
<%@ page errorPage="error.jsp" %>
<%@ page extends="java.lang.Object" %>
<%@ page isErrorPage="true" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%-- 
Jsp学习
	1、Jsp的三种注释
		Jsp原生注释：不转译，仅当前Jsp文件中有效;
		Java注释：转译至Servlet类中，不发送;
		前端语言注释：转译至Servlet类中，发送至浏览器;
	2、Jsp的核心指令
		page:
			作用：设置Jsp文件转译时属性
			使用：
				<%@ page 属性名="属性值" 属性名="属性值" ...%>
			language="java":声明Jsp转译目标语言；
			pageEncoding="utf-8":指明当前Jsp文件的编码格式；
			contentType="text/html; charset=utf-8":指明发送和接收浏览器信息的编码格式；
			import:转译生成的Servlet类引入包，不同的包用逗号分隔；
			extends:转译生成的Servlet类继承类；
			session:设置转译生成的Servlet类是否支持session，默认开启；
			errorPage:指定发生运行时异常时跳转的错误提示页面；
			isErrorPage:设置转译生成的Servlet类是否支持exception；
		include:
			作用：引入其他Jsp文件
			使用：
				静态引入：<%@ include file="目标Jsp的相对路径">
				动态引入：<jsp:include page="目标Jsp的文件路径"></jsp:include>
		taglib:
			
	3、Jsp的资源路径
		相对路径：以当前文件所在路径为基础进行索引；"../"——上一级目录
		绝对路径：以路径开头的"/"表示项目的根目录，相当于："localhost:8080/"
			/虚拟项目名/Jsp文件路径
		全局路径：Jsp文件中声明的path和basePath预先定义了资源路径的前缀
			String path = request.getContextPath();//即"/虚拟项目名"
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";//即"http://ip:port/虚拟项目名/"
			<base href="<%=basePath%>">
			作用：给Jsp资源前面自动加上项目前缀
	4、Jsp的编程技术
		4.1 局部代码块
			作用：给静态的界面显示代码中添加逻辑判断
			特点：局部代码块中编写的Java代码会被转译到Servlet的_JspService方法体中
				代码在页面显示过程中被执行，无需调用
				代码中声明的变量均为局部变量
			使用：<% Java代码 %>
			缺点：使用局部代码块在Jsp中进行逻辑处理，书写麻烦，阅读困难。
		4.2 全局代码块
			作用：定义业务方法，该方法独立于_JSPService方法体之外
			特点：声明的Java代码作为全局代码转译到对应的Servlet类中
			使用：<%! Java全局代码 %>
			注意：需要通过局部代码块调用
		4.3 脚本段语句
			作用：获取Java代码中声明的变量或方法的返回值，作为数据响应给浏览器
			使用：<%=变量名/方法名%>
			注意：中间不要使用分号";"
			位置：除Jsp语法要求以外的任意位置
		4.4 静态引入
			作用：引入其他Jsp文件的代码，处理后，合并显示
			使用：<%@ include file="要引入的Jsp文件的相对路径" %>
			特点：被引入的Jsp文件不会进行转译，只是合并到当前Jsp中一并转译生成当前Jsp对应的servlet的Java文件；
				显示效果合并；
			注意：两个Jsp文件中不允许声明同名的局部变量。
		4.5 动态引入
			作用：动态引入其他Jsp文件的代码，处理后，合并显示
			使用：<jsp:include page="要引入的Jsp文件的相对路径"></jsp:include>
			特点：要引入的Jsp文件单独转译，在当前Jsp转译生成的Servlet Java文件中调用引入的Jsp对应的转译文件；
				显示合并效果；
			注意：动态引入中允许两个Jsp文件中声明同名的变量。
	5、请求转发：forward标签
		作用：实现一次请求中的请求转发操作
		使用：<jsp:forward page="目标Jsp文件相对路径">
				<jsp:param name="参数名" value="参数值" />
			</jsp:forward>
		特点：一次请求，地址栏URL不变
		注意：<jsp:param>标签用于传递过程参数，会将数据以？的方式拼接在URL中（请求行），可以没有
			<jsp:forward>标签中不能有其他任何内容，包括空格
	6、Jsp的九大内置对象
		内置对象：
			Jsp在转译成其对应的Servlet Java文件时，自动声明并创建的几个对象，在Jsp代码文件中可以直接使用
		注意：
			只能在局部代码块或脚本段中使用，不能在全局代码块中使用。
		具体：
			pageContext:页面上下文对象，封装了其他内置对象；一个Jsp文件对应一个pageContext对象，生命周期是当前页面。
			request:请求信息对象，由服务器创建，封装了请求数据、Cookie、过程参数。
			session:会话对象，由服务器创建，用于实现同一用户的不同请求之间的数据共享，生命周期是本次回话。
			application:即ServletContext对象，用户实现不同用户的请求之间的数据共享，生命周期是整个项目。
			response:响应对象，响应请求处理结果给浏览器。设置重定向。
			out:响应对象，Jsp内部使用。带有缓冲区的响应对象，效率更高。
			page:this，代表当前Jsp的对象。
			exception:异常对象，存储了当前的异常信息。使用此对象，需要指定isErrorPage="true"
			config:即ServletConfig对象，用于获取web.xml文件中的Servlet配置信息。
	7、四个作用域对象
		作用：数据流转
		pageContext：当前页面
		request：一次请求
		session：一次会话
		application：项目内
 --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP '2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
