<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${path }/css/delvpage.css">
<title></title>
<script type="text/javascript">
$(document).ready(function(){
	
	    $(".list_1st a").mouseover(function(){
	        $(".list_1st a").css("color", "#12d8fa");
	    });
	    $(".list_1st a").mouseout(function(){
	        $(".list_1st a").css("color", "black");
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
.disc_sel ul li{
	float: left;
	margin-right: 20px;
}
.disc_sel  ul li input{

}
</style>
</head>
<body>
	<div class="container-fluid"
		style="padding-left: 0px; padding-right: 0px;">
	<div class="hos"></div>

		<div class="col-xs-2"></div>

		<div class="col-xs-8 info_content">
			<div class="my_left">
				<div class="left_prof">
					<div style="text-align: center;"><img style="margin-top: 30px;" src="../img/sanaprof.PNG" class="img-circle" width="150px" height="150px"></div>
					<a href="${path }/member/passConfirmForm.mall"><img style="position: absolute; margin-left: 150px; margin-top: 18px;" src="../img/option.png"></a>
					<br>
					<div style="text-align: center;">${member.name }</div>
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
						<li class="list_1st"><a href="mypage.mall">찌릿찌릿</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">샤샤샤</a></li>
						<li class="list_3th"><a href="">낙낙!</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="right_menu">
					<ul>
						<c:if test="${member.type == 1 }">
							<li class="menu_delv"><a href="${path }/trade/delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>배송 정보</a></li>
							<li class="menu_coup"><a href="${path }/trade/couppage.mall"><img
									src="../img/coupon_color.png"><br>보유 쿠폰</a></li>
							<li class="menu_money"><a href="${path }/member/moneypage.mall"><img
									src="../img/money_color.png"><br>보유 금액</a></li>
							<li class="menu_talk"><a href="${path }/member/talkpage.mall"><img
									src="../img/talk_color.png"><br>구디 톡톡!</a></li>
						</c:if>
						<c:if test="${member.type == 2 }">
							<li class="menu_delv"><a href="${path }/trade/delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>배송 관리</a></li>
							<li class="menu_coup"><a href="${path }/trade/couppage.mall"><img
									src="../img/coupon_color.png"><br>쿠폰관리</a></li>
							<li class="menu_money"><a href="${path }/member/moneypage.mall"><img
									src="../img/money_color.png"><br>보유 금액</a></li>
							<li class="menu_talk"><a href="${path }/member/talkpage.mall"><img
									src="../img/talk_color.png"><br>구디 톡톡!</a></li>
						</c:if>
						<c:if test="${member.type == 3 }">
							<li class="menu_delv"><a href="${path }/member/delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>일반회원 관리</a></li>
							<li class="menu_coup"><a href="${path }/trade/couppage.mall"><img
									src="../img/coupon_color.png"><br>사업자회원 관리</a></li>
							<li class="menu_money"><a href="${path }/member/moneypage.mall"><img
									src="../img/money_color.png"><br>보유 금액</a></li>
							<li class="menu_talk"><a href="${path }/member/talkpage.mall"><img
									src="../img/talk_color.png"><br>구디 톡톡!</a></li>
						</c:if>
						<c:if test="${member.id==sana }"> 
							<li class="menu_delv"><a href="delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>사나</a></li>
							<li class="menu_coup"><a href="couppage.mall"><img
									src="../img/coupon_color.png"><br>샤샤샤</a></li>
							<li class="menu_money"><a href="moneypage.mall"><img
									src="../img/money_color.png"><br>낙낙!</a></li>
							<li class="menu_talk"><a href="talkpage.mall"><img
									src="../img/talk_color.png"><br>오효오효쨩</a></li>
						</c:if>
					</ul>
				</div>
			<div class="my_right">
				
				<div class="right_cont">
				
					<br><br>
					
						<h3>
							<c:if test="${member.type==1 }">
							<strong>보유 쿠폰</strong>
							</c:if>
							<c:if test="${member.type==2 }">
							<strong>쿠폰 목록</strong>
							</c:if>
						</h3>
					
					<div class="disc_sel pull-right" style="margin-bottom: 40px;">
						<ul>
							<li>
								<label style="cursor: pointer;">
									<input style="width: 17px; height: 17px;" type="radio" name="type" value="1" required="required"><span style="vertical-align: top;">5%</span>
								</label>
							</li>
							<li>
								<label style="cursor: pointer;">
									<input style="width: 17px; height: 17px;" type="radio" name="type" value="2" required="required"><span style="vertical-align: top;">10%</span>
								</label>
							</li>
							<li>
								<label style="cursor: pointer;">
									<input style="width: 17px; height: 17px;" type="radio" name="type" value="3" required="required"><span style="vertical-align: top;">15%</span>
								</label>
							</li>
						</ul>
					</div>

					<table class="table table-hover"
							style="border-bottom: 1px solid #e5e5e5;">
							<thead>
								<tr>
									<c:if test="${member.type == 1 }">
									<th>할인율</th>
									<th>발급자</th>
									<th>사용여부</th>
									</c:if>
									<c:if test="${member.type == 2 }">
									<th>할인율</th>
									<th>보유자</th>
									<th>사용 여부</th>
									</c:if>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="">
									<tr>
										<c:if test="${member.type == 2 }">
										<td>넣</td>
										<td>으</td>
										<td>셈</td>
										</c:if>
										<c:if test="${member.type == 2 }">
										<td>넣</td>
										<td>으</td>
										<td>셈</td>
										</c:if>
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