<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="customer.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="cDao" scope="page" class="customer.CustomerDAO" />
<jsp:useBean id="cDto" class="customer.Customers" />
<jsp:setProperty name="customer" property="*" />
<%
	String action = request.getParameter("action");

	switch (action) {
	case "join":

		break;
	case "login":
		if (cDao.login(cDto.getcId(), cDto.getcPassword())) {
			session.setAttribute("cid", cDto.getcId());
			Customers cus = cDao.getCustomer(cDto.getcId());
			session.setAttribute("name", cus.getcName());
			response.sendRedirect("main.jsp");
		} else {
			out.println("<script>alert('아이디나 비밀번호가 틀렸습니다.'); history.go(-1);</script>");
		}
		break;
	case "logout":

		break;
	}
%>