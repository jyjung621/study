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
	String[] color={"red", "orange", "yellow", "green", "blue", "navy", "violet"};
	request.setAttribute("color", color);
%>
<%-- <jsp:forward page="colorResult.jsp"></jsp:forward> --%>
<jsp:forward page="colorResult2.jsp"></jsp:forward>
</body>
</html>