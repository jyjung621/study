<%@page import="och10.Dept"%>
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
		Dept dept = (Dept)request.getAttribute("dept");
	%>
	<h2>부서정보 (Expression 표현)</h2>
	<p>부서코드 : <%=dept.getDeptno() %></p>
	<p>부서명 : <%=dept.getDname() %></p>
	<p>지역 : <%=dept.getLoc() %></p>

	<h2>부서정보 (Expression Language [EL]표현)</h2>
	<p>부서코드 : ${dept.deptno}</p>
	<p>부서명 : ${dept.dname}</p>
	<p>지역 : ${dept.loc }</p>
</body>
</html>