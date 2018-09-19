<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<fmt:formatNumber value="10000" groupingUsed="true"></fmt:formatNumber><br>
		<fmt:formatNumber value="3.1415923" pattern="#.###"></fmt:formatNumber><br>
		<fmt:formatNumber value="3.1" pattern="#.##"></fmt:formatNumber><br>
		<fmt:formatNumber value="3.1" pattern="#.00"></fmt:formatNumber><br>
		<fmt:formatNumber value="121434323453." pattern="##,###.00"></fmt:formatNumber><br>
		<fmt:formatNumber value="3.1415923" pattern="#.###"></fmt:formatNumber><br>
		<!-- 	currency : 화폐단위	\\ : 원단위  \$ : 달러 -->
		<fmt:formatNumber value="250000" type="currency" currencySymbol="\\"></fmt:formatNumber><br>
		<fmt:formatNumber value="0.75" type="percent"></fmt:formatNumber>
	</div>

</body>
</html>