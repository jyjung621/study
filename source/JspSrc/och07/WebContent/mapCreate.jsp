<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	HashMap<String, String> map = new HashMap<>();
	map.put("Park", "목동");
	map.put("박", "박목동");
	map.put("Jasica", "크라이스 처치");
	map.put("Susan", "시드니");
	
	request.setAttribute("ADDRESS", map);
	RequestDispatcher rd = request.getRequestDispatcher("mapView.jsp?NAME=Park");
	rd.forward(request, response);
%>