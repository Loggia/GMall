<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인</title>
<script src="${path }/dist/sweetalert-dev.js"></script>
<link rel="stylesheet" type="text/css" href="${path }/dist/sweetalert.css">

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<!-- 부트스트랩 css, cdn -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부트스트랩 js, cdn -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	background-color: #f4f4f4
}
.mask {
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	display: block;
	overflow: hidden;
	border: 1px solid #ced2d7
}
</style>
</head>
<body>
<div class="mask" style="margin: 0 auto; margin-top: 350px; background-color: white; width: 500px; height: 400px; text-align: center">
	<a href="${path }/board/main.mall">
		<img style="width: 300px; height: 100px; margin-top: 30px;" class="rotatey" id="logo" src="../img/logo.png">
	</a>
		<form>
		<div class="form-group" align="center" style="margin-top: 50px;">
			<label for="message-text" class="control-label">비밀번호를 입력하세요</label>
			<input style="width: 300px; margin-bottom: 60px;" name="pass" type="password" class="form-control" id="message-text" placeholder="비밀번호" required="required">
		</div>
		<button class="btn btn-info">확인</button>
		</form>
	</div>
</body>
</html>