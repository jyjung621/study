<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>큰 수 찾기</h2>
	<u:max num2="${param.num1 }" num1="${param.num2 }"/>
	<p>큰 값 : ${maximum }</p>
</body>
</html>