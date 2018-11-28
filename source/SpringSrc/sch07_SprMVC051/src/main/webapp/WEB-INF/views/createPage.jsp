<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Done Page</title>
</head>
<body>
	<%
		String context = request.getContextPath();
	%>
	<h5>createPage.jsp 실행...</h5>
	
	<form action="<%=context %>/student/create">
		<p>이름 : <input type="text" name="name" value="${student.name }"></p>
		<p>아이디 : <input type="text" name="id" value="${student.id }"></p>
		<input type="submit" value="전송">
	</form>
</body>
</html>