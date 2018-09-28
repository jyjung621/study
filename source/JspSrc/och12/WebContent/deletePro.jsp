<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="Error.jsp"%>
    <%@ include file="memberCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Process</title>
</head>
<body>
	<%
		String passwd = request.getParameter("passwd");
		MemberDao md = MemberDao.getInstance();
		System.out.println("DeletePro  id -> " + id);
		int result = md.delete(id, passwd);
		if(result == 1) {
			// session 끊음
			session.invalidate();
	%>
		<script type="text/javascript">
			alert("탈퇴되었습니다. 잘가용~");
			location.href="main.jsp";
		</script>
	<%
		} else if(result == 0) {
	%>
		<script type="text/javascript">
			alert("암호가 틀렸어.. 다시 입력해줘..");
			history.go(-1);
		</script>
	<%
		} else {
	%>
		<script type="text/javascript">
			alert("..?? 에러라고,..??");
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>