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
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		/* 
			session을 통하여 저장하여 다른곳에서 사용
			.setAttribute() ==> .getAttribute()
		*/
		session.setAttribute("id", id);
		session.setAttribute("password", password);
		session.setAttribute("name", name);
	%>
	<h2>약관 동의</h2>
	<p>
		---------------------------------------------------------------------------<br>
		-- 1. 회원 정보는 웹 사이트의 운영을 위해서만 사용됩니다.<br>
		-- 2. 웹 사이트의 정상 운영을 방해하는 회원은 탈퇴 처리합니다.<br>
		----------------------------------------------------------------------------<br>
	</p>
	<!-- 
		subscribe.jsp  ==>  DAO, DTO 사용
		subscribe2.jsp  ==>  jsp 페이지에서 세션 기술사용
	 -->
<!-- 	<form action="subscribe2.jsp"> -->
	<form action="subscribe.jsp">
		<p>동의<input type="radio" name="agree" value="y"></p>
		<p>거부<input type="radio" name="agree" value="n"></p>
		<input type="submit" value="확인">
	</form>
</body>
</html>