<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<!-- 
	<% %> ==> scriptlet
-->
<% 
	String color = request.getParameter("color"); 
%>

<body bgcolor="<%=color%>">
	색상 바뀌었음??
</body>
</html>