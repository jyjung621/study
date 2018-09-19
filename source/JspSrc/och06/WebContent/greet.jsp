<%@page import="java.io.FileWriter"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		JSP에서 선언하는 방법
			<%!  ==>  이렇게 사용
	--%>
	<%!
		private PrintWriter pw;
		String date;
		
		public void jspInit() {
			GregorianCalendar gc = new GregorianCalendar();
			date = String.format("%TF %TT", gc, gc);
			//	파일명에 : 들어가면 안되서 바꿔주는 것
			String fileName = "c:/DevEnv/JSP/log/" + date.replaceAll(":", "") + ".log";
			
			try {
				pw = new PrintWriter(new FileWriter(fileName, true));
			} catch (Exception e) {
				System.out.println("대박! 으이그");
			}
		}
	%>
	<%
		String name = request.getParameter("name");
		String msg = name + "님 반가워";
		
		out.println(msg + "<p> 현재시간 : " + date);
		pw.println(msg + "\r\n 현재시간 : " + date + "\r\n");
				
	%>
	<%!
		public void jspDestroy() {
			if(pw != null) {
				pw.close();
			}
	}
	%>
</body>
</html>