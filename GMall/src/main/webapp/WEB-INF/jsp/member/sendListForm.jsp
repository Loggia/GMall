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
.msgWrap {
	
}

.msgListHead {
	padding: 0px;
}

.msgList {
	padding: 0px;
}

.msgListHead li {
	float: left;
	height: 25px;
	background-color: #f9f9f9;
	border: 1px solid #e4e5e7;
	border-right: none;
	padding-left: 7px;
}

.msgListHead li:last-child {
	float: left;
	height: 25px;
	background-color: #f9f9f9;
	border: 1px solid #e4e5e7;
	padding-left: 7px;
}

.msgList li {
	float: left;
	height: 30px;	
	border-bottom: 1px solid #e4e5e7;
	width: 100%;
}
.msgList li div {
	float: left;
	height: 30px;	
	padding-left: 7px;
	padding-top :2px;
	border-bottom: 1px solid #e4e5e7;
}

.msgList :hover {
	background-color: #f5f5f5;
}

.msgList li a {
	cursor: pointer;
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
					<div style="text-align: center;">
						<img style="margin-top: 30px;" src="../prof/${member.picture }"
							class="img-circle" width="150px" height="150px">
					</div>
					<a href="${path }/member/passConfirmForm.mall"><img
						style="position: absolute; margin-left: 150px; margin-top: 18px;"
						src="../img/option.png"></a> <br>
					<div style="text-align: center;">${member.name }</div>
				</div>
				<div class="left_list">
					<ul>
						<c:if test="${member.type == 1 }">
							<li class="list_1st"><a href="${path }/member/mypage.mall">관심
									사업장</a></li>
							<li class="list_2nd"><a href="${path }/trade/BSList.mall">구매
									목록</a></li>
							<li class="list_3th"><a
								href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 2 }">
							<li class="list_1st"><a href="${path }/member/mypage.mall">내사업장</a></li>
							<li class="list_2nd"><a href="${path }/trade/BSList.mall">판매
									목록</a></li>
							<li class="list_3th"><a
								href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 3 }">
							<li class="list_1st"><a href="${path }/member/mypage.mall">사이트
									관리</a></li>
							<li class="list_2nd"><a href="${path }/trade/BSList.mall">회원
									거래 목록</a></li>
							<li class="list_3th"><a
								href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.id == sana }">
							<li class="list_1st"><a href="mypage.mall">찌릿찌릿</a></li>
							<li class="list_2nd"><a href="${path }/trade/BSList.mall">샤샤샤</a></li>
							<li class="list_3th"><a href="">낙낙!</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="right_menu pull-right"
				style="width: calc(100% - 250px); background-color: #f7f8f8; z-index: 20px;">
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
			<div class="my_right" style="width: calc(100% - 250px); padding-top: 40px;">
				<div class="msgWrap" style="font-family: 'KoPub Dotum';">
				<button type="button" class="btn btn-default" onclick="location.href='${path }/member/talkpage.mall'">받은쪽지</button>
				<button type="button" class="btn btn-default" onclick="location.href='${path }/member/sendListForm.mall'">보낸쪽지</button>
				<button type="button" class="btn btn-default" onclick="location.href='${path }/member/msgWriteForm.mall'">쪽지 쓰기</button>
				
				<div style="display: block; margin: 10px 0px;">
					<span style="font-family: 'Patrick Hand', cursive; font-size: 25px;">
						<span style="color: #1DDB16;">Send</span> List
					</span>
				</div>
				
				<ul class="msgListHead" style="margin-top: 10px;">
					<li style="width: 12%">받는사람</li>
					<li style="width: 64%">내용</li>
					<li style="width: 12%">날짜</li>
					<li style="width: 12%"></li>
				</ul>
				
					<c:if test="${not empty sendList}">
					<ol class="msgList">
					<c:forEach items="${sendList }" var="sendList">
						<li>
							<input type="hidden" value="${reciveList.msg_no }">
							<div style="width: 12%"><a>${sendList.rec_id }</a></div>
							<div style="width: 64%"><a href="${path }/member/msgDetail.mall?msg_no=${sendList.msg_no }">${sendList.msg_content }</a></div>
							<div style="width: 12%"><span><fmt:formatDate value="${sendList.msg_date }" pattern="yyyy-MM-dd"/></span></div>
							<div style="width: 12%"><a href="${path }/member/msgDelete.mall?msg_no=${sendList.msg_no }">삭제</a></div>
						</li>
					</c:forEach>
					</ol>
						<div align="center">
							<ul class="pagination">
								<c:if test="${pageNum == 1}">
									<li class="disabled">
										<a aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
									</li>
								</c:if>
								<c:if test="${pageNum > 1}">
									<li class="">
										<a href="javascript:reciveList(${pageNum - 1})" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
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
											<a href="javascript:reciveList(${a})">${a}<span class="sr-only"></span></a>
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
										<a href="javascript:reciveList(${pageNum + 1})" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
									</li>
								</c:if>
							</ul>
						</div><br><br><br>
					</c:if>
					<c:if test="${empty sendList}">
					<br><br><br>
					<span style="font-size: 100px; color: rgba(0,0,0,0.4);">/(o_o)/</span>
					<br>
					<span style="font-size: 40px; color: rgba(0,0,0,0.4);">No Message!</span>
					<br><br>
					<hr>
					</c:if>
				</div>
			</div>
		</div>
		<div class="col-xs-2"></div>
	</div>
</body>
</html>