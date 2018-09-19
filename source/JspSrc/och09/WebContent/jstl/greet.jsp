<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:set var="greet" value="How Are You ?"></c:set>
</head>
<body>
	<h2>인사말</h2>
	<p>원글 : ${greet }</p>
	<p>대문자 : ${fn:toUpperCase(greet) }</p>
	<p>소문자 : ${fn:toLowerCase(greet) }</p>
	<p>Are 위치 : ${fn:indexOf(greet, "Are") }</p>
	<p>Are 변경 : ${fn:replace(greet, "Are", "Were") }</p>
	<p>문자 길이 : ${fn:length(greet) }</p>
</body>
</html>