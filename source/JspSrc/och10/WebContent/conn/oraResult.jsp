<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>사원번호 : ${emp.empno }</p>
	<p>사원이름 : ${emp.ename }</p>
	<!-- groupingUsed ==> 3자리마다 쉼표 표시 한다는 뜻 -->
	<p>급여 : <fmt:formatNumber value="${emp.sal }"  groupingUsed="true" type="currency" currencySymbol="\\"/></p>
	<p>입사일 : <fmt:formatDate value="${emp.hiredate }" pattern="yyyy/MM/dd"/></p>
</body>
</html>