<%@page import="util.MemberDao"%>
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

		MemberDao md = new MemberDao();
		int result = md.check(id, password);
/* 		System.out.println("loginPro result : " + result); */
		if (result == 1) {
			session.setAttribute("id", id);
			response.sendRedirect("sessionMain.jsp");
		} else if (result == 0) {
	%>
		<script type="text/javascript">
			alert("암호가 틀렸어!!! 다시 입력해봐!");
			history.go(-1);
		</script>
	<%
		} else {
	%>
		<script type="text/javascript">
			alert("이건대체 뭐냐... 제대로좀해봐..");
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>