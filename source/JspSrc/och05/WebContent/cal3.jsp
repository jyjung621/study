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
	%>
		<script type="text/javascript">
			alert("그게 숫자냐");
			/*
			 *	Page 이동 기법
			 *	1. history.go(-1);
			 *	2. history.back();
			 *	3. location.herf="num2.html";
			 */
			history.go(-1);
		</script>
	<%
			// ArithmeticException e  -> 0 예외처리
		} catch(ArithmeticException e) {
	%>
		 <script type="text/javascript">
		 	alert("... 또 0으로 나누냐??? 그러지 좀 마라");
			history.back();
		 </script>
	<%
			
		} catch(Exception e) {
			out.println(e.getMessage());
	%>
		<script type="text/javascript">
			alert("하여튼.. 에러발생이네..");
			location.herf="num2.html";
		</script>
	<%
		}
	%>
</body>
</html>