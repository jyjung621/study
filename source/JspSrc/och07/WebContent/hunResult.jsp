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
		String sum = request.getAttribute("sum").toString();
	%>
	<h2>1부터 100까지 합</h2>
	
	<%-- 1. Expression  <%= %> --%>
	<p>1. Expression  =>  <%=sum %></p>
	
	<%-- 2. Expression Language ${ } --%>
	<p>2. Expression  Language (EL)  =>  ${sum1 }</p>
	
</body>
</html>