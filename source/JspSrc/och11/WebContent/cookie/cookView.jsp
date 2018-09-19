<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cooks[] = request.getCookies();
		if(cooks != null) {
			for(int i=0; i<cooks.length; i++) {
				if(cooks[i].getName().equals("id")) {
					out.println("쿠키 이름 : " + cooks[i].getName() + "<p>");
					out.println("쿠키 값 : " + cooks[i].getValue() + "<p>");
				}
			}
		}
	%>
</body>
</html>