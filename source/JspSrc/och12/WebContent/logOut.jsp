<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
    <%@ include file="memberCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout Process</title>

</head>
<body>
	<%
		// session 값 초기화
		session.invalidate();
	%>
	<script type="text/javascript">
		alert("로그아웃 되었습니다.");
		location.href="loginForm.jsp";
	</script>
</body>
</html>