<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- ==================================================================== -->
<title>ezen mall</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	// Input 항목 유효성 검사
	function isValidLogin() {
		var cid = document.getElementById("cid");
		var pwd = document.getElementById("cpassword");
		var rgx_cid = /^[a-z]+[a-z0-9_]{5,11}$/; // 아이디 정규 표현식
		var rgx_pwd = /^[a-zA-Z0-9!@#$%^*+=-_]{8,20}$/; // 패스워드 정규 표현식

		if (rgx_id.test(uid.value) != true) {
			alert('[ID 입력 오류] 유효한 ID를 입력해 주십시요.');
			uid.focus();
			return false;
		}
		s
		if (rgx_pwd.test(pwd.value) != true) {
			alert('[PWD 입력 오류] 유효한 패스워드를 입력해 주십시요.');
			pwd.focus();
			return false;
		}
		return true;
	}
	
	function noticeId() {
		alert();
	}
</script>
</head>
<body>
	<div class="container">
		<%@include file="../view/common/nav.jspf"%>
	</div>

	<!-- ==============================<nav>=================================================== -->

	<form class="form-horizontal" method="post" action="../control/customer_control.jsp?action=register">
		<fieldset>
			<div class="col-md-offset-2 col-md-8" align="center">
				<h3>회원가입</h3>
				<br> <br>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="name">이 름</label>
				<div class="col-md-4">
					<input name="cName" type="text" placeholder="이름을 입력하세요"
						class="form-control input-md" required>
				</div>
			</div>

			<!-- Password input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="password">비밀번호</label>
				<div class="col-md-4">
					<input name="cPassword" type="password" placeholder="비밀번호를 입력하세요"
						class="form-control input-md" required>

				</div>
			</div>

			<!-- Email input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="email">이메일</label>
				<div class="col-md-4">
					<input name="cEmail" type="email" placeholder="이메일을 입력하세요"
						class="form-control input-md" required>
				</div>
			</div>

			<!-- Tel input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="tel">전화번호</label>
				<div class="col-md-4">
					<input name="cTel" type="tel" placeholder="전화번호를 입력하세요"
						class="form-control input-md" required>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group" align="center">
				<label class="col-md-4 control-label" for="register"></label>
				<div class="col-md-4">
					<button type="submit" class="btn btn-default">회원가입</button>
				</div>
			</div>
		</fieldset>
	</form>

	<!-- ==============================<footer>================================================ -->
	<div class="container">
		<%@include file="../view/common/footer.jspf"%>
	</div>
	<!-- ====================================================================================== -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>