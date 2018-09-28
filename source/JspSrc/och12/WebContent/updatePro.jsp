<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="memberCheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Process</title>
</head>
<body>
	<jsp:useBean id="member" class="och12.Member"></jsp:useBean>
	<jsp:setProperty property="*" name="member"/>
	<%
		MemberDao md = MemberDao.getInstance();
		int result = md.update(member);
		if(result > 0) {
	%>
		<script type="text/javascript">
			alert("사용자 정보 수정 완료");
			location.href="main.jsp";
		</script>
	<%
		} else {
	%>
		<script type="text/javascript">
			alert("제대로 입력하시요...");
			history.back();
		</script>
	<%
		}
	%>
</body>
</html>