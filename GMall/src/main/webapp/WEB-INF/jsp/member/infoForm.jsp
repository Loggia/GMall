<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
$(document).ready(function(){
		$(".list_1st a").mouseover(function(){
        	$(".list_1st a").css("color", "#12d8fa");
    	});
   	 	$(".list_1st a").mouseout(function(){
        	$(".list_1st a").css("color", "black");
    	});
   	 	
	    $(".list_2nd a").mouseover(function(){
	        $(".list_2nd a").css("color", "#12d8fa");
	    });
	    $(".list_2nd a").mouseout(function(){
	        $(".list_2nd a").css("color", "black");
	    });
	    
	    $(".list_3th a").mouseover(function(){
	        $(".list_3th a").css("color", "#12d8fa");
	    });
	    $(".list_3th a").mouseout(function(){
	        $(".list_3th a").css("color", "black");
	    });
	
	
});
</script>
<style type="text/css">
body {
	background-color: #f4f4f4;
}

.container-fluid {
	padding-top: 0 !important;
}

.info_content {
	border: 1px solid #e5e5e5;
	height: 1500px;
	margin: 30px auto 30px auto;
	padding: 0px;
	background: #fff;
	font-family: '나눔고딕', NanumGothic, '맑은고딕', MalgunGothic, '돋움', Dotum,
		Helvetica, sans-serif;
}

.my_left {
	position: absolute;
	width: 250px;
	height: 1500px;
}

.my_right {
	position: relative;
	width: 1157.61px;
	padding: 40px 40px 120px 40px;
	height: 1500px;
	margin-left: 250px;
	border-left: 1px solid #e5e5e5;
}

.left_prof {
	width: 250px;
	height: 240px;
	background-color: #bbbfc3;
	border-bottom: 1px solid #e5e5e5;
}

.left_list {
	width: 250px;
	height: 800px;
	padding-top: 40px;
	padding-left: 40px;
	padding-right: 40px;
	padding-bottom: 20px;
	text-align: left;
}
.left_list ul {
	text-align: left;
	padding: 0px;
	margin: 0px;
	font-size: 20px;
}
.list_1st {
	border-bottom: 1px solid #e5e5e5;
	margin-top: 20px;
	margin-bottom: 20px;
	padding-bottom: 20px;
}
.list_2nd {
	border-bottom: 1px solid #e5e5e5;
	margin-top: 20px;
	margin-bottom: 20px;
	padding-bottom: 20px;
}
.list_3th {
	margin-top: 20px;
	margin-bottom: 20px;
}

.list_1st a{
	text-decoration: none;
	color: black;
}
.list_2nd a{
	text-decoration: none;
	color: black;
}
.list_3th a{
	text-decoration: none;
	color: black;
}

.menu_delv {
	text-align: center;
	float: left;
	border-right: 1px solid #e5e5e5;
	padding-top: 40px;
	padding-bottom: 45px;
	padding-left: 50px;
	padding-right: 100px;
}

.menu_coup {
	text-align: center;
	float: left;
	border-right: 1px solid #e5e5e5;
	padding-top: 40px;
	padding-bottom: 45px;
	padding-left: 110px;
	padding-right: 110px;
}

.menu_money {
	text-align: center;
	float: left;
	border-right: 1px solid #e5e5e5;
	padding-top: 40px;
	padding-bottom: 45px;
	padding-left: 110px;
	padding-right: 110px;
}

.menu_talk {
	text-align: center;
	float: left;
	padding-top: 40px;
	padding-bottom: 45px;
	padding-left: 110px;
}
.panel {
	width: 450px;
}

.form-control {
	width: 300px;
}
</style>
</head>
<body>
	<div class="container-fluid"
		style="padding-left: 0px; padding-right: 0px;">

		<div class="col-xs-2"></div>

		<div class="col-xs-8 info_content">
			<div class="my_left">
				<div class="left_prof">
					<div style="text-align: center;"><img style="margin-top: 30px;" src="../img/sanaprof.PNG" class="img-circle" width="150px" height="150px"></div>
					<a href="${path }/member/infoForm.mall"><img style="position: absolute; margin-left: 150px; margin-top: 18px;" src="../img/option.png"></a>
					<br>
					<div style="text-align: center;">사나</div>
				</div>
				<div class="left_list">
					<ul>
						<c:if test="${member.type == 1 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">관심 사업장</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">구매 목록</a></li>
						<li class="list_3th"><a href="${path }/member/cs.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 2 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">내사업장</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">판매 목록</a></li>
						<li class="list_3th"><a href="${path }/member/cs.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 3 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">사이트 관리</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">회원 거래 목록</a></li>
						<li class="list_3th"><a href="${path }/member/cs.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.id == sana }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">찌릿찌릿</a></li>
						<li class="list_2nd"><a href="">샤샤샤</a></li>
						<li class="list_3th"><a href="">낙낙!</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="my_right">
				<div class="panel panel-info">
				<div class="panel-heading">
							<h3 class="panel-title">회원 정보 수정</h3>
						</div>
					<div class="panel-body">

						<div class="form-group">
							<label class="control-label">아이디:</label> <input disabled
								name="id" type="text" class="form-control"
								placeholder="${member.id }">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">비밀번호:</label> <input
								name="pass" type="password" class="form-control"
								id="message-text" placeholder="비밀번호를 입력해주세요">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">비밀번호 확인:</label>
							<input name="passfirm" type="password" class="form-control"
								id="message-text" placeholder="비밀번호 한번 더  입력해주세요">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">이름:</label> <input
								name="name" type="text" class="form-control" id="recipient-name"
								placeholder="이름을 입력해주세요">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">닉네임:</label> <input
								name="nickname" type="text" class="form-control"
								id="message-text" placeholder="닉네임을 입력해주세요">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="control-label">성별:&nbsp;&nbsp;</label>
							<label class="radio-inline-lg" style="cursor: pointer;">
								<input type="radio" name="gender" value="1"
								style="cursor: pointer;">남자
							</label> &nbsp;&nbsp; <label class="radio-inline-lg"
								style="cursor: pointer;"> <input type="radio"
								name="gender" value="2" style="cursor: pointer;">여자
							</label>
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">연락처:</label> <input
								name="tel" type="text" class="form-control" id="message-text"
								placeholder="연락처를 입력해주세요">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">주소:</label> <input
								name="address" type="text" class="form-control"
								id="message-text" placeholder="주소를 입력해주세요">
						</div>
						<div class="form-group">
							<label for="sel1">관심 상품:</label> <select name="interest"
								class="form-control" id="sel1"
								style="width: 100px; cursor: pointer;">
								<option>육류</option>
								<option>해산물</option>
								<option>과일</option>
								<option>채소</option>
								<option>곡류</option>
								<option>견과류</option>
							</select>
						</div>
						<c:if test="${member.type == 2 }">
							<div class="form-group">
								<label for="message-text" class="control-label">사업자 번호:</label>
								<input name="bis_no" type="text" class="form-control" id="message-text" placeholder="사업자 번호를 입력해주세요">
							</div>
							<div class="form-group">
								<label for="message-text" class="control-label">상호:</label>
								<input name="bis_name" type="text" class="form-control" id="message-text" placeholder="상호를 입력해주세요">
							</div>
						</c:if>
						<button type="button" class="btn btn-info">수정</button>
					</div> <!-- 패널 바디 -->
				</div> <!-- 패널  -->
				
				<hr>
	
				<div class="panel panel-danger">
					<div class="panel-heading">
						<h3 class="panel-title">회원 탈퇴</h3>
					</div>
					<form>
					<div class="panel-body">
						<div class="form-group">
							<label for="message-text" class="control-label">비밀번호:</label> <input
								name="pass" type="password" class="form-control"
								id="message-text" placeholder="비밀번호를 입력해주세요">
						</div>
						<button type="button" class="btn btn-danger">회원 탈퇴</button>
					</div>
					</form>
				</div>
			</div> <!-- my right end -->
		</div>

		<div class="col-xs-2"></div>
	</div>
</body>
</html>