<%@page import="ajax.MemberDao"%>
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
		MemberDao md = MemberDao.getInstance();

		int result = md.confirm(id);
		if (result == 0) {
			out.println("사용할 수 있는 ID 입니다.");
		} else {
			out.println("이미 사용중인 ID입니다. 다시 입력해주세요.");
		}
	%>

</body>
</html>