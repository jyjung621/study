<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String[] winner = {"홍길동", "김길동", "고길동"};
		
		// .setAttribute("winner", winner);
		//	"winner" -> 보낼때 이름   winner -> 실제 보내지는 변수
		request.setAttribute("winner", winner);
		
		//	"winnerResult.jsp" -> 해당 Page로 이동
		RequestDispatcher rd = request.getRequestDispatcher("winnerResult.jsp");
		rd.forward(request, response);
		
	%>
</body>
</html>