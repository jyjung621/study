<%@page import="java.io.*"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		String msg = "제목 : " + title + "\r\n";
		msg += "작성자 : " + writer + "\r\n";
		msg += "내용 : " + content + "\r\n";
		
		Date date = new Date();
		long fileName = date.getTime();
		
		String real = application.getRealPath("/WEB-INF/out/" + fileName + ".txt");
		System.out.println(real);
		
		FileWriter fw = new FileWriter(real);
		fw.write(msg);
		fw.close();
		
	%>
	저장성공
</body>
</html>