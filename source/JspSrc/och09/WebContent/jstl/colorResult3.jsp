<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<c:set var="color" value="red,orange,yellow,green,blue,navy,violet"/>
<c:set var="num" value="1,2,3,4,5,6,7"/>
<body>
<c:forTokens var="cnt" items="${num}" delims=",">
	<c:forTokens var="cnt" items="${color}" delims=",">
		<font color="${col}" size="${cnt }">야호</font>	
	</c:forTokens>
	<br>
</c:forTokens>

</body>
</html>