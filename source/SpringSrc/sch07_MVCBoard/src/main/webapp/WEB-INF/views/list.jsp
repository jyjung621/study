<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
    request.setCharacterEncoding("UTF-8");
%>

</head>
<body>
	<h2>스프링 게시판</h2>
	<table>
		<tr>
			<td>번호1</td><td>이름1</td><td>제목</td><td>날짜</td><td>히트</td>
		</tr>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td>
					<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
					<a href="content_view?bId=${dto.bId}">${dto.bTitle}</a>
				</td>
				<td>${dto.bDate}</td>
				<td>${dto.bHit}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view">글작성</a></td>
		</tr>
	</table>
</body>
</html>