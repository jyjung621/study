<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String agree =  request.getParameter("agree");
	String result = null;
	if(agree.equals("y")) {
		/*
			저장해둔 세션의 값을 가져와서 사용
			.setAttribute() ==> .getAttribute()
		*/
		String id = (String)session.getAttribute("id");
		String password = (String)session.getAttribute("password");
		String name = (String)session.getAttribute("name");
		
		PrintWriter writer = null;
		
		try {
			String filePath = application.getRealPath("/WEB-INF/test/" + id + ".txt");
			System.out.println("filePath -> " + filePath);
			writer = new PrintWriter(filePath);
			writer.println("아이디 : " + id);
			writer.println("패스워드 : " + password);
			writer.println("이름 : " + name);
			result = "success";
		} catch (IOException e) {
			result = "fail";
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				
			}
		}
	} else {
		result = "fail";
	}
	
	session.invalidate();
	response.sendRedirect("result2.jsp?result=" + result);
	
%>