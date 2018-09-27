<%@page import="och12.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogInProcess</title>
</head>
<body>
	<!-- Control 을 jsp에서 같이하는 것 ==> MVC1 모델  -->
	<%
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		MemberDao md = MemberDao.getInstance();
		int result = md.check(id, passwd);
		// id가 존재하면
		if (result == 1) {
			session.setAttribute("id", id);
			response.sendRedirect("main.jsp");
		// id OK, passwd error
		} else if (result == 0) {
	%>
	<script type="text/javascript">
		alert("암호 몰라?! 비밀번호가 안맞네");
		history.go(-1);
	</script>			
	<%
		}else {
	%>	
	<script type="text/javascript">
		alert("아이디 틀렸어.. 너 누구야?!\n처음 왔으면 회원가입 ㄱㄱ");
		history.go(-1);
	</script>
	<%
		}
	%>
</body>
</html>