<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String protocol = request.getProtocol();
	String server = request.getServerName();
	int port = request.getServerPort();
	String clientIp = request.getRemoteAddr();
	String clientHost = request.getRemoteHost();
	String methodType = request.getMethod();
	String url = new String(request.getRequestURI());
	String uri = request.getRequestURI();
	String contextPath = request.getContextPath();
	String browser = request.getHeader("User-Agent");
	String mediaType = request.getHeader("Accept");
%>
</head>
<body>
	<h2>Request내장 객체 예제2</h2>
	<div>
		<p>
		프로토콜명 : <%=protocol%><br>
		접속한 서버명 : <%=server%><br>
		접속한 서버의 포트번호 : <%=port%><br>
		클라이언트 IP : <%=clientIp%><br>
		클라이언트 호스트명 : <%=clientHost%><br>
		현재 페이지의 method방식 : <%=methodType%><br>
		요청한 현재 페이지의 경로(URL) : <%=url%><br>
		요청한 현재 페이지의 경로(URI) : <%=uri%><br>
		웹어플리케이션에서의 컨텍스트 경로 : <%=contextPath%><br>
		사용한 웹 브라우저 : <%=browser%><br>
		웹 브라우저가 지원하는 매체(media)의 타입 : <%=mediaType%><br>
		</p>

	</div>

</body>
</html>