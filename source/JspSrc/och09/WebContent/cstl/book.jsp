<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
   <%-- user가 직접 만든 태그 라이브러리 사용 --%>
   <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>좋아하는 책</h2>
	<u:newLine color="red" size="50"/>
	<p>홍길동전</p>
	<p>연개소문전</p>
	<p>김유신전</p>
	<u:newLine color="blue" size="50"/>
</body>
</html>