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
		String name = "hong";
		Cookie cook = new Cookie("id",name);	//	쿠키생성
		//cook.setValue("hello");
		cook.setMaxAge(60);
		response.addCookie(cook);
		
	%>
	<p>쿠키 저장 완료</p>
	<a href="cookView.jsp">쿠키보기</a>
	
</body>
</html>