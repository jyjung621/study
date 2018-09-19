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
		try {
			int num = Integer.parseInt(request.getParameter("num"));
			if(num > 9 || num < 2) {
	%>
		<script type="text/javascript">
			alert("여기가 인도냐!");
			// history.go(-1); => 이전으로 다시 보냄
			history.go(-1);
		</script>
	<%
			}
			out.println("<h2>구구단 " + num + "단</h2>");
			for(int i=1; i<=9; i++) {
				out.println(num + " x " + i + " = " + num*i + "<br>");
			}
		} catch(Exception e) {
	%>
		<script type="text/javascript">
			alert("숫자도 몰라?!?!?");
			history.go(-1);
		</script>
	<%
		}
	%>
</body>
</html>