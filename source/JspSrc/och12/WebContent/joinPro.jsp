<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Process</title>
</head>
<body>
	<jsp:useBean id="member" class="och12.Member"></jsp:useBean>
	<jsp:setProperty property="*" name="member" />
	<%
		/* 
			1. HTML 에서 사용할 경우
				<jsp:useBean id="member" class="och12.Member"></jsp:useBean>
				<jsp:setProperty property="*" name="member"/>
			
			2. Java 로 사용할 경우
				Member member = new Member();		
		*/
		MemberDao md = MemberDao.getInstance();
		int result = md.insert(member);
		if (result > 0) {
	%>
	<script type="text/javascript">
		alert("회원가입 축하!! 이제 수고해!!");
		location.href = "loginForm.jsp";
	</script>
	<%
		} else {
	%>
	<script type="text/javascript">
		alert("실패야... 왜그랬어...");
		location.href = "joinForm.jsp";
	</script>
	<%
		}
	%>
</body>
</html>