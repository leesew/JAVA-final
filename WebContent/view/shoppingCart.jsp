<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="shoppingMall.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="shopDao" scope="page" class="shoppingMall.ShoppingDAO" />
<jsp:useBean id="shopDto" class="shoppingMall.ShoppingCart" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- ------------------------------------------------------------------------------------------------- -->
<title>cart</title>
<link href="../css/bootstrap.min.css" rel="stylesheet"
	id="bootstrap-css">
<link href="../css/login.css" rel="stylesheet">
<!-- ------------------------------------------------------------------------------------------------- -->
</head>
<body>
	<%
		//System.out.println("shoppingCart.jsp");
	%>
	<div class="container">
		<%@include file="../view/common/nav.jspf"%>
	</div>
	<!-- ------------------------------------------------------------------------------------------------- -->

	<div class="container">
      <div class="row">
         <br>
         <div class="col-md-offset-1 col-md-11">
            <h3>장바구니 조회</h3>
         </div>
         <div class="col-md-12">
            <hr>
         </div>
         <div class="col-md-1"></div>
         <div class="col-md-9">
            <div class="panel panel-default">
               <div class="panel-heading">
                  <div class="pannel-title">&nbsp;${sessionScope.cName}&nbsp;님의장바구니</div>
               </div>
               <table class="table table-striped">
                  <thead>
                     <tr>
                        <th class="col-md-1">상품번호</th>
                        <th class="col-md-3">상품명</th>
                        <th class="col-md-1">단가</th>
                        <th class="col-md-1">수량</th>
                        <th class="col-md-2">금액</th>
                     </tr>
                  </thead>
                  <tbody>
                        <c:set var="shoppingCart" value="${sessionScope.shoppingCart}" />
                        <c:forEach var="cList" items="${shoppingCart}">
                           <tr>
                              <td>${cList.pId}</td>
                              <td>${cList.pName }</td>
                              <td>${cList.unitPrice}원</td>
                              <td>${cList.quantity}</td>
                              <td>${cList.sum}원</td>
                           </tr>
                        </c:forEach>
                           <tr>
                              <td colspan="5" align="center">총금액 : ${requestScope.total}원</td>
                           </tr>
                           <tr align="center">
                              <td colspan="5">
                                 <a href="../control/shop_control.jsp?action=realOrder"><button class="btn btn-primary">주문</button></a>
                                 <button class="btn btn-default" onClick="history.back();">취소</button></a>
                              </td>
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
	<!-- ------------------------------------------------------------------------------------------ -->
	<div class="container">
		<%@include file="../view/common/footer.jspf"%>
	</div>
	<!-- ==================================================================== -->
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>