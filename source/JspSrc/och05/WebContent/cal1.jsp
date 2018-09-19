<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>연산결과</h2>
	<%
		try {
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			
			out.println(num1 + " + " + num2 + " = " + (num1+num2) + "<p>");
			out.println(num1 + " - " + num2 + " = " + (num1-num2) + "<p>");
			out.println(num1 + " * " + num2 + " = " + (num1*num2) + "<p>");
			out.println(num1 + " / " + num2 + " = " + (num1/num2) + "<p>");
		} catch(NumberFormatException e) {
			out.println("그게 숫자임?");
			// ArithmeticException e  -> 0 예외처리
		} catch(ArithmeticException e) {
			out.println("... 왜 0으로 나누냐!!!");
		} catch(Exception e) {
			out.println(e.getMessage());
		}
	%>
</body>
</html>