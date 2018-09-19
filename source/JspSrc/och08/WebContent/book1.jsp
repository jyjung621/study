<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="pt" class="och08.Book" scope="request"></jsp:useBean>
	
	// property="*" ==> html에서 name과 java class의 필드 name이 같을경우 *로 사용가능
	<jsp:setProperty property="*" name="pt"/>
	<jsp:forward page="productInfo.jsp"></jsp:forward>
</body>
</html>