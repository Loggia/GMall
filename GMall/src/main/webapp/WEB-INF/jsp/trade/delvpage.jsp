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
			<div class="my_right">
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
				<div class="right_cont">
					
					<div class="panel panel-default" style="margin-top: 40px;">
						<div id="delv_chk">
							<ul style="margin: 14px; padding: 0;" >
								<li class="nomal">
									<img src="../img/delv_pro_ready.png">
									<span class="delv_chk_font">${pro_ready }</span>
								</li>
								<li class="nomal">
									<img src="../img/delv_trans_ready.png">
									<span class="delv_chk_font">${del_ready }</span>
								</li>
								<li class="nomal">
									<img src="../img/delv_trans.png">
									<span class="delv_chk_font">${deliverying }</span>
								</li>
								<li class="last">
									<img src="../img/delv_comp.png">
									<span class="delv_chk_font">${del_complete }</span>
								</li>
							</ul>
						</div>
					</div>					
				
					<br><br>

					<c:if test="${member.type == 1 }">
						<h3>
							<strong>배송 목록</strong>
						</h3>
						<table class="table table-hover"
							style="border-bottom: 1px solid #e5e5e5;">
							<thead>
								<tr>
									<th>거래코드</th>
									<th>거래 물품</th>
									<th>구매 금액</th>
									<th>상호명</th>
									<th>일자</th>
									<th>배송현황</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="del" items="${delivery }">
									<tr>
										<td>${del.trd_code }</td>
										<td>${del.pro_name }</td>
										<td>${del.trd_money }</td>
										<td>${del.bis_name }</td>
										<td><f:formatDate value="${del.trd_date }" pattern="yy-MM-dd"/></td>
										<td>${del.delivery }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					
					<c:if test="${member.type == 2 }">
						<h3>
							<strong>배송 목록</strong>
						</h3>
						<table class="table table-hover"
							style="border-bottom: 1px solid #e5e5e5;">
							<thead>
								<tr>
									<th>상품명</th>
									<th>구입자</th>
									<th>결제금액</th>
									<th>거래코드</th>
									<th>배송현황</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${tradeList}" var="list">
									<tr>
										<td>${list.pro_name }</td>
										<td>${list.bis_name }</td>
										<td>${list.trd_money }</td>
										<td>${list.trd_code }</td>
										<td>${list.delivery }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					
					<br><br>
				</div>
			</div>
		</div>

		<div class="col-xs-2"></div>
	</div>
</body>
</html>