<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
    request.setCharacterEncoding("UTF-8");
%>

<title>Content View</title>
</head>
<body>
	<h2>게시글 작성</h2>
	
	<form action="write" method="post">
		<table width="500" cellpadding="0" cellspacing="0" border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="bName" size="50"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" name="bContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력">&nbsp;&nbsp;
					<a href="list">목록보기</a>
				</td>
			</tr>
		</table>	
	</form>
</body>
</html>