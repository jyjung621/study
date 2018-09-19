<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>우승자 (EL 표기법)</h2>
	<p>1등 : ${winner[0] }</p>
	<p>2등 : ${winner[1] }</p>
	<p>3등 : ${winner[2] }</p>
	
	<h2>우승자 (전통 표기법)</h2>
	<%
		// String 배열로 변환 해줘야함
		String[] win = (String [])request.getAttribute("winner");
		for(int i=0; i<win.length; i++) {
			out.println("<p>" + (i+1) + "등 : " + win[i] + "</p>");
		}
	%>
</body>
</html>