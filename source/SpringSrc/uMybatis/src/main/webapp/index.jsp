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
	String context = request.getContextPath();
	System.out.println("context->" + context);
// 	response.sendRedirect("list.do");
// 	response.sendRedirect("insertEmp.do");  //처음에 생성할때만 한번 실행해줌
// 	response.sendRedirect("listEmp.do");
// 	response.sendRedirect("upLoadFormStart.do");
// 	response.sendRedirect("listEmpAjax2.do");
// 	response.sendRedirect("sample/sendVO.do");
// 	response.sendRedirect("writeDeptCursor.do");
// 	response.sendRedirect("writeDeptIn.do");
// 	response.sendRedirect("upLoadFormStart.do");
	response.sendRedirect("interCepterForm.do");
%>
</body>
</html>