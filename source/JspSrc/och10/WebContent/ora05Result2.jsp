<%@page import="och10.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
	tr:hover {
		background-color: red;
	}
	</style>
</head>
<body>
	<table width="100%" bgcolor="aqua" border="1">
		<tr bgcolor="pink">
			<th>사번</th>
			<th>이름</th>
			<th>업무</th>
			<th>급여</th>
		</tr>
	<c:forEach var="emp" items="${al }">
		<tr>
			<th>${emp.empno}</th>
			<th>${emp.ename}</th>
			<th>${emp.job}</th>
			<th>${emp.sal}</th>
		</tr>
	</c:forEach>
	</table>
</body>
</html>