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
	<h2>부서 정보</h2>
	<table width="100%" bgcolor="aqua" border="1">
		<tr bgcolor="pink">
			<th>부서코드</th>
			<th>부서명</th>
			<th>근무지</th>
		</tr>
		<c:forEach var="dept" items="${al }">
			<tr>
				<th>${dept.deptno }</th>
				<th>${dept.dname }</th>
				<th>${dept.loc }</th>
			</tr>
		</c:forEach>
	
	</table>
</body>
</html>