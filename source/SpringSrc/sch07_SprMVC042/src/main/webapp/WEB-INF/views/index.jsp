<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
</head>
<body>
	<%
		String context = request.getContextPath();
	%>
	
	context		<%=context %><p>
	
	<h5>studentView</h5>
	<form action="<%=context%>/studentView" method="post" >
		<p>이름 : <input type="text" name="name"></p>
		<p>나이 : <input type="text" name="age"></p>
		<p>학년 : <input type="text" name="gradeNum"></p>
		<p>반 : <input type="text" name="classNum"></p>
		<input type="submit" value="전송">
	</form>
	
	<h5>studentView2.jsp</h5>
	<form action="<%=context%>/studentView2" method="post" >
		<p>이름 : <input type="text" name="name"></p>
		<p>나이 : <input type="text" name="age"></p>
		<p>학년 : <input type="text" name="gradeNum"></p>
		<p>반 : <input type="text" name="classNum"></p>
		<input type="submit" value="전송">
	</form>
</body>
</html>