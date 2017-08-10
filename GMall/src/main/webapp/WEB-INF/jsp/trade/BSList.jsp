<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="${path }/css/delvpage.css">
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
	    var seq = 0;
 	    $('.coupgive').click(function() {
			seq = $(this).parent().index();
/* 			if ($(this).attr('data-click-state') == 1) {
				$(this).attr('data-click-state', 0);
				$(this).attr('src', './img/mymenu_noclick.png');
			} else {
				$(this).attr('data-click-state', 1);
				$(this).attr('src', './img/mymenu_click.png');
			}
             popover_rtn(seq);
 */			
 			if ($("#coupgive_view"+seq).attr('data-click-state') == 1) {
 				$("#coupgive_view"+seq).attr('data-click-state', 0);
				$("#coupgive_view"+seq).attr('src', './img/mymenu_noclick.png');
			} else {
				$("#coupgive_view"+seq).attr('data-click-state', 1);
				$("#coupgive_view"+seq).attr('src', './img/mymenu_click.png');
			}
 		   popover_rtn(seq);
		})
 });
function popover_rtn(id) {
	var value =  $('.coupgive_Form'+id).html();
	$('#coupgive_view'+id).popover({
		placement : 'bottom',
		html : true,
		content : value
	 });
}
function chck(disc,id) 
{	
	var v = $("#id_"+id).val();
	location.href="${path}/trade/insertCoupon.mall?discount="+disc+"&id="+v;
 }
</script>

<script type="text/javascript">
	function BSList(pageNum) 
	{	
		location.href = "BSList.mall?pageNum=" + pageNum;
	}	
</script>
</head>
<body>
	<div class="container-fluid"
		style="padding-left: 0px; padding-right: 0px;">

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
						<li class="list_2nd"><a class="on" href="${path }/trade/BSList.mall">구매 목록</a></li>
						<li class="list_3th"><a href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 2 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">내사업장</a></li>
						<li class="list_2nd"><a class="on" href="${path }/trade/BSList.mall">판매 목록</a></li>
						<li class="list_3th"><a href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 3 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">사이트 관리</a></li>
						<li class="list_2nd"><a class="on" href="${path }/trade/BSList.mall">회원 거래 목록</a></li>
						<li class="list_3th"><a href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.id == sana }">
						<li class="list_1st"><a href="mypage.mall">찌릿찌릿</a></li>
						<li class="list_2nd"><a class="on" href="${path }/trade/BSList.mall">샤샤샤</a></li>
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
						<c:if test="${member.id==sana }"> 
							<li class="menu_delv"><a href="delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>사나</a></li>
							<li class="menu_delv"><a href="couppage.mall"><img
									src="../img/coupon_color.png"><br>샤샤샤</a></li>
							<li class="menu_delv"><a href="moneypage.mall"><img
									src="../img/money_color.png"><br>낙낙!</a></li>
							<li class="menu_delv"><a href="talkpage.mall"><img
									src="../img/talk_color.png"><br>오효오효쨩</a></li>
						</c:if>
					</ul>
				</div>
			<div class="my_right" style="width: calc(100% - 250px);">
				
				<div class="right_cont">
					<br><br>
					<c:if test="${member.type==1 }">
					<h3>
						<strong>구매 목록</strong>
					</h3>
					<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;">
						<thead>
							<tr>
								<th>거래코드</th><th>구매 물품</th><th>구매 금액</th><th>상호명</th><th>일자</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="trd" items="${trdList }">
							<tr>
								<td>${trd.trd_code }</td>
								<td>${trd.pro_name }</td>
								<td>${trd.trd_money }원</td>
								<td>${trd.bis_name }</td>
								<td><f:formatDate value="${trd.trd_date }" pattern="yy-MM-dd"/></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					</c:if>
					
					<c:if test="${member.type==2 }">
					<h3>
						<strong>판매 목록</strong>
					</h3>
					<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;">
						<thead>
							<tr>
								<th>거래코드</th><th>상품이름</th><th>판매 금액</th><th>구매자</th><th>일자</th>
							</tr>
						</thead>
	                    <tbody>
				
							<c:forEach items="${trdList}" var="trd" varStatus="stat">
			
							<tr> 
								<td>${trd.trd_code }</td>
								<td>${trd.pro_name }</td>
								<td>${trd.trd_money }원</td>
								<td class="coupgive" id="coupgive_view${stat.index}" data-toggle="popover" data-container="body">
								<input type="hidden" id="id_${stat.index}" value="${trd.buy_id }">${trd.buy_id }</td>
								
								<td><f:formatDate value="${trd.trd_date }" pattern="yy-MM-dd"/></td>	
								
								<div class="hide">
								   <ol class="coupgive_Form${stat.index}" >
										<li class="mymemu_list" style="margin: 5px;"><a href="javascript:chck(5, ${stat.index})" style="text-decoration: none;" class="ml" >5% 쿠폰 발급</a></li>
										<li class="mymemu_list" style="margin: 5px;"><a href="javascript:chck(10, ${stat.index})" style="text-decoration: none;" class="ml">10% 쿠폰 발급</a></li>
										<li class="mymemu_list" style="margin: 5px;"><a href="javascript:chck(15, ${stat.index})" style="text-decoration: none;" class="ml">15% 쿠폰 발급</a></li>
								  </ol>
								</div>		
									
							</tr>

					
							</c:forEach>
						</tbody>
					</table>
					</c:if>
					
					<c:if test="${member.type==3 }">
					<h3>
						<strong>회원 거래 목록</strong>
					</h3>
					<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;">
						<thead>
							<tr>
								<th>상품목록</th><th>가격</th><th>판매자</th><th>구매자</th><th>배송현황</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${trdList}" var="trd">
							<tr>
							<td>${trd.pro_name}</td> 
							<td>
							<f:formatNumber type="CURRENCY"
							currencySymbol="" value="${trd.trd_money}" minFractionDigits="0"/>원</td>
							<td>${trd.sell_id}</td>
							<td class="coupgive" data-toggle="popover" data-container="body">${trd.buy_id}</td>
							<td>${trd.delivery}</td>
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
									<a href="javascript:BSList(${pageNum - 1})" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
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
										<a href="javascript:BSList(${a})">${a}<span class="sr-only"></span></a>
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
									<a href="javascript:BSList(${pageNum + 1})" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
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