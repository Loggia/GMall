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

<script type="text/javascript">
	function nomalList(pageNum) 
	{	
		location.href = "nomalList.mall?pageNum=" + pageNum;
	}	
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
					<div style="text-align: center;"><img style="margin-top: 30px;" src="../prof/${member.picture }" class="img-circle" width="150px" height="150px"></div>
					<a href="${path }/member/passConfirmForm.mall"><img style="position: absolute; margin-left: 150px; margin-top: 18px;" src="../img/option.png"></a>
					<br>
					<div style="text-align: center;">${member.name }</div>
				</div>
				<div class="left_list">
					<ul>
						<c:if test="${member.type == 1 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">관심 사업장</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">구매 목록</a></li>
						<li class="list_3th"><a href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 2 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">내사업장</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">판매 목록</a></li>
						<li class="list_3th"><a href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 3 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">사이트 관리</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">회원 거래 목록</a></li>
						<li class="list_3th"><a href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.id == sana }">
						<li class="list_1st"><a href="mypage.mall">찌릿찌릿</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">샤샤샤</a></li>
						<li class="list_3th"><a href="">낙낙!</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="right_menu pull-right" style="width: calc(100% - 250px); background-color: #f7f8f8; z-index: 20px;" >
					<ul style="width: 100%; display: block; padding: 0;">
						<c:if test="${member.type == 1 }">
							<li class="menu_delv"><a href="${path }/trade/delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>배송 정보</a></li>
							<li class="menu_delv"><a href="${path }/trade/couppage.mall"><img
									src="../img/coupon_color.png"><br>보유 쿠폰</a></li>
							<li class="menu_delv"><a href="${path }/member/moneypage.mall"><img
									src="../img/money_color.png"><br>보유 금액</a></li>
							<li class="menu_delv"><a href="${path }/member/talkpage.mall"><img
									src="../img/talk_color.png"><br>구디 톡톡!</a></li>
						</c:if>
						<c:if test="${member.type == 2 }">
							<li class="menu_delv"><a href="${path }/trade/delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>배송 관리</a></li>
							<li class="menu_delv"><a href="${path }/trade/couppage.mall"><img
									src="../img/coupon_color.png"><br>쿠폰관리</a></li>
							<li class="menu_delv"><a href="${path }/member/moneypage.mall"><img
									src="../img/money_color.png"><br>보유 금액</a></li>
							<li class="menu_delv"><a href="${path }/member/talkpage.mall"><img
									src="../img/talk_color.png"><br>구디 톡톡!</a></li>
						</c:if>
						<c:if test="${member.type == 3 }">
							<li class="menu_delv"><a href="${path }/member/nomalList.mall"><img
									src="../img/nomal_1.png" width="64px" height="64px"><br>일반회원 관리</a></li>
							<li class="menu_delv"><a href="${path }/member/businessList.mall"><img
									src="../img/busi_1.png"><br>사업자회원 관리</a></li>
							<li class="menu_delv"><a href="${path }/member/moneypage.mall"><img
									src="../img/money_color.png"><br>보유 금액</a></li>
							<li class="menu_delv"><a href="${path }/member/talkpage.mall"><img
									src="../img/talk_color.png"><br>구디 톡톡!</a></li>
						</c:if>
					</ul>
				</div>
			<div class="my_right" style="width: calc(100% - 250px);">
				
				<div class="right_cont">
				
				
					<br><br>

					<c:if test="${member.type == 3 }">
						<h3>
							<strong>일반 회원 관리</strong>
						</h3>
						<table class="table table-hover"
							style="border-bottom: 1px solid #e5e5e5;">
							<thead>
								<tr>
								<th>닉네임</th>
								<th>이름</th>
								<th>성별</th>
								<th>연락처</th>
								<th>주소</th>
							</tr>
							</thead>
							<tbody>
								<c:forEach items="${nomalList}" var="nomal">
								<tr>
								<td><a href="infoForm.mall?id=${nomal.id}">${nomal.nickname}</a></td>
								<td>${nomal.name}</td>
								<td>${nomal.gender}</td>
								<td>${nomal.tel}</td>
								<td>${nomal.address}</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					<div align="center">
						<ul class="pagination">
							<c:if test="${pageNum == 1}">
								<li class="disabled">
									<a aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
								</li>
							</c:if>
								<c:if test="${pageNum > 1}">
								<li class="">
									<a href="javascript:nomalList(${pageNum - 1})" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
								</li>
							</c:if>
		
							<c:forEach var="a" begin="${startpage}" end="${endpage}">
								<c:if test="${pageNum == a}">
									<li class="active">
										<a href="#">${a}<span class="sr-only"></span></a>
									</li>
								</c:if>
								<c:if test="${pageNum != a}">
									<li>
										<a href="javascript:nomalList(${a})">${a}<span class="sr-only"></span></a>
									</li>
								</c:if>
							</c:forEach>
							<c:if test="${pageNum == maxpage}">
								<li class="disabled">
									<a aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
								</li>
							</c:if>
							<c:if test="${pageNum < maxpage}">
								<li>
									<a href="javascript:nomalList(${pageNum + 1})" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
								</li>
							</c:if>
						</ul>
					</div><br><br><br>
				</div>
			</div>
		</div>

		<div class="col-xs-2"></div>
	</div>
</body>
</html>