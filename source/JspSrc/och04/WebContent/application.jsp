<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String info = application.getServerInfo();
		int major = application.getMajorVersion();
		int minor = application.getMinorVersion();
		String path = application.getRealPath("/");
	%>
	<h2>Application 내장객체 예제</h2>
	<div>
		<p>웹 컨테이너의 이름과 버전 : <%=info %></p>
		<p>서블릿의 버전 : <%=major %>.<%=minor %></p>
		<p>웹 어플리케이션 폴더의 로컬 시스템 경로 : <%=path %></p>
			
	</div>
</body>
</html>