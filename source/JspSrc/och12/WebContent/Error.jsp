<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <!-- 
    	ErrorPage 선언 필요
    		isErrorPage="true"
    		response.setStatus(200); 
   	-->
   <% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항...</title>
</head>
<body>
	<h2>공지사항</h2>
	<p>죄송합니다.<br> 더 나은 서비스를 위하여 현재 Page 준비중입니다.</p>
	<%=exception.getMessage() %>
</body>
</html>