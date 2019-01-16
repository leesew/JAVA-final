<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="shoppingMall.*, java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- ==================================================================== -->
<title>ezen Mall</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<jsp:useBean id="shopDao" scope="request"
	class="shoppingMall.ShoppingDAO" />
<style type="text/css">
.bs-example {
	margin: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<%@include file="../view/common/nav.jspf"%>
	</div>
	<!-- ==============================<nav>=================================================== -->

	<div class="container">
		<div class="row">
			<br>
			<div class="col-md-offset-1 col-md-11">
				<h3>주문 고객 정보조회</h3>
			</div>
			<div class="col-md-12">
				<hr>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="pannel-title">&nbsp;${requestScope.oId}&nbsp;&nbsp;|&nbsp;&nbsp;주문번호</div>
					</div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="col-md-1">&nbsp;&nbsp;&nbsp;&nbsp;주문일자</th>
								<th class="col-md-2">고객ID</th>
								<th class="col-md-2">고객명</th>
								<th class="col-md-1">주문번호</th>
								<th class="col-md-1">주문금액</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="customerList" value="${requestScope.customerList}" />
							<c:forEach var="cDto" items="${customerList}">
								<tr>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;${cDto.oDate }</td>
									<td>${cDto.oCustomerId}</td>
									<td>${cDto.cName}</td>
									<td>${cDto.oId}</td>
									<td>${cDto.oPrice}원</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="4" align="center">총 주문금액 :
									${requestScope.oPrice }원</td>
							</tr>
							<tr align="center">
								<td colspan="4"><input type="button"
									class="btn btn-default" value="주문조회로 돌아가기"
									onclick="history.go(-1);"></td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<!-- ==============================<footer>================================================ -->
	<div class="container">
		<%@include file="../view/common/footer.jspf"%>
	</div>
	<!-- ====================================================================================== -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>