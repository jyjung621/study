<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<%
		String result = request.getParameter("result");
	%>
	<h3>회원 가입 결과</h3>
	<%
		if(result.equals("success")) {
			out.println("가입되었습니다.^^");
		} else {
			out.println("가입되지 않았습니다.ㅜㅜ");
		}
	%>
</body>
</html>