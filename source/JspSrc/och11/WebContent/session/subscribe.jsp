<%@page import="util.MemberDto"%>
<%@page import="util.MemberDao"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String chk ="";
	String agree =  request.getParameter("agree");
	if(agree.equals("y")) {
		/*
			저장해둔 세션의 값을 가져와서 사용
			.setAttribute() ==> .getAttribute()
		*/
		String id = (String)session.getAttribute("id");
		String password = (String)session.getAttribute("password");
		String name = (String)session.getAttribute("name");
		
		MemberDao md = new MemberDao();
		MemberDto member = new MemberDto();
		/* DTO 에  각 컬럼별로 값 세팅 */
		member.setId(id);
		member.setName(name);
		member.setPassword(password);
		
		/* DAO 를 통하여 한번에 삽입 */
		int result = md.insert(member);
		if(result > 0) {
			chk = "success";
		} else {
			chk = "fail";
		}
	} else {
		chk = "fail";
	}
	
	session.invalidate();
	out.println("invalidate() 적용후에도 " + session.getId() + "<br>");
	response.sendRedirect("result.jsp?chk=" + chk);
	
%>