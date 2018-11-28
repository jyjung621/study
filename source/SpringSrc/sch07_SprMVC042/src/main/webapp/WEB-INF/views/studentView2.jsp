<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>studentView2.jsp 실행...</h5>
	
	<%
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String gradeNum = request.getParameter("gradeNum");
		String classNum = request.getParameter("classNum");
	%>
	
	<p>이름 : ${param.name }</p> 
	<p>나이 : ${param.age }</p> 
	<p>학년 : ${param.gradeNum }</p> 
	<p>반 : ${param.classNum }</p> 

</body>
</html>