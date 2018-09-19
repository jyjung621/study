
<%@page import="java.util.ArrayList"%>
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
	<%
		ArrayList<Emp> al = (ArrayList<Emp>)request.getAttribute("al");
	%>
	<table width="100%" bgcolor="aqua" border="1">
		<tr bgcolor="pink">
			<th>사번</th>
			<th>이름</th>
			<th>업무</th>
			<th>급여</th>
		</tr>
	<%
		for(int i=0; i<al.size(); i++) {
			out.println("<tr><th>" + al.get(i).getEmpno() + "</td>");
			out.println("<th>" + al.get(i).getEname() + "</td>");
			out.println("<th>" + al.get(i).getJob() + "</td>");
			out.println("<th>" + al.get(i).getSal() + "</td></tr>");
		}
	%>
		
	</table>
</body>
</html>