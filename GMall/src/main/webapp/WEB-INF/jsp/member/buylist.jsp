<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
$(document).ready(function(){
	
	    $(".list_fav a").mouseover(function(){
	        $(".list_fav a").css("color", "#12d8fa");
	    });
	    $(".list_fav a").mouseout(function(){
	        $(".list_fav a").css("color", "black");
	    });
	    $(".list_cs a").mouseover(function(){
	        $(".list_cs a").css("color", "#12d8fa");
	    });
	    $(".list_cs a").mouseout(function(){
	        $(".list_cs a").css("color", "black");
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
	padding: 0px 40px 120px 40px;
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
.list_fav{
	border-bottom: 1px solid #e5e5e5;
	margin-top: 20px;
	margin-bottom: 20px;
	padding-bottom: 20px;
}
.list_buylist{
	border-bottom: 1px solid #e5e5e5;
	margin-top: 20px;
	margin-bottom: 20px;
	padding-bottom: 20px;
}
.list_cs{
	margin-top: 20px;
	margin-bottom: 20px;
}

.list_fav a{
	text-decoration: none;
	color: #12d8fa;
}
.list_buylist a{
	text-decoration: none;
	color: black;
}
.list_cs a{
	text-decoration: none;
	color: black;
}

.right_menu {
	position: relative;
	width: 100%;
	height: 240px;
	padding: 35px 0px 35px 0px;
	border-bottom: 1px solid #e5e5e5;
}

.right_menu ul {
	list-style: none;
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

.right_cont {
	
}

.home_group {
	margin-top :20px;
	border-top: 1px solid #e5e5e5;
}
.bus_list {
	margin-top: 20px;
	border-bottom: 1px solid #e5e5e5;
}
.bus_cont {
	margin-top: 20px;
	margin-bottom: 20px;
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
					<a href=""><img style="position: absolute; margin-left: 143px; margin-top: 18px;" src="../img/option.png"></a>
					<br>
					<div style="text-align: center;">사나</div>
				</div>
				<div class="left_list">
					<ul>
						<li class="list_fav"><a href="mypage.mall">관심 사업장</a></li>
						<li class="list_buylist"><a class="on" href="buylist.mall">구매 목록</a></li>
						<li class="list_cs"><a href="cs.mall">고객 센터</a></li>
					</ul>
				</div>
			</div>
			<div class="my_right">
				<div class="right_menu">
					<ul>
						<li class="menu_delv"><a href="delvpage.mall"><img
								src="../img/truck2_color.png" width="64px" height="64px"><br>배송 정보</a></li>
						<li class="menu_coup"><a href="couppage.mall"><img
								src="../img/coupon_color.png"><br>보유 쿠폰</a></li>
						<li class="menu_money"><a href="moneypage.mall"><img
								src="../img/money_color.png"><br>보유 금액</a></li>
						<li class="menu_talk"><a href="talkpage.mall"><img
								src="../img/talk_color.png"><br>구디 톡톡!</a></li>
					</ul>
				</div>
				<div class="left_cont">
					<br><br>
					<h3>
						<strong>구매 목록</strong>
					</h3>
					<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;">
						<thead>
							<tr>
								<th>거래코드</th><th>거래 물품</th><th>구매 금액</th><th>상호명</th><th>일자</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach>
							<tr>
								<td>넣</td>
								<td>으</td>
								<td>셈</td>
								<td>뿌</td>
								<td>잉</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<br><br>
				</div>
			</div>
		</div>

		<div class="col-xs-2"></div>
	</div>
</body>
</html>