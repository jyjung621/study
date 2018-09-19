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
		request.setCharacterEncoding("utf-8");	
		
		String[] col={"red", "orange", "yellow", "green", "blue", "navy", "violet"};
		// 7 이하의 랜덤 숫자
		int n = (int)(Math.random() * 7);
	
		String pgm = request.getParameter("pgm") + ".jsp";
		/*
		 *	.getRequestDispatcher(pgm);
		 *		=> color1.jsp 요청  rd 인스턴스 생성
		 */
		RequestDispatcher rd = request.getRequestDispatcher(pgm);
		if(pgm.equals("color1.jsp")) {
			request.setAttribute("color", col[n]);
		} 
		else if (pgm.equals("gugu1.jsp")) {
			request.setAttribute("num", n + 2);
		}
		else if (pgm.equals("response.jsp")) {
			
		}
		/*
		 *	rd.forward(request, response);
		 *		-> rd가 가지고 있는 Page로 이동하라
		 */
		rd.forward(request, response);
		
	%>
</body>
</html>