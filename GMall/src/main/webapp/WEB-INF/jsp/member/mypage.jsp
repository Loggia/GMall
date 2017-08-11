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
       
       
        $('.category').on('click', function()
        {
        	var category = $(this).val();
        	location.href = "mypage.mall?category=" + category;
        	// mybis_list(category);
      	}); 
});   

  function mybis_list(category){
          var data = {'category': category};
          var type = ${member.type};
          $.ajax({
             type : "POST",
             url : "bislist.mall",
             data : data,
             success : function(html) {
               var obj = JSON.parse(html);
                var myBislist = obj.myBislist;
                console.log(myBislist);
                var html = "<thead>";
                    html += "<tr>";
                  if(type == 1){
                     html += "<th>상호</th>";
                     html += "<th>연락처</th>";
                     html += "<th>프리미엄 여부</th>";
                  }else if(type == 2){
                     html += "<th>상품 카테고리</th>";
                     html += "<th>상품이름</th>";
                     html += "<th>가격</th>";
                     html += "<th>등록일자</th>";
                  }
                  html += "</tr>";
                  html += "</thead>";
                for(i=0;i<myBislist.length;i++) {
                  html += "<tr>";
                  if(type == 1){
                     html += "<td></td>";
                     html += "<td></td>";
                     html += "<td></td>";
                  }else if(type == 2){
                      html += "<td>" + myBislist[i].category + "</td>";
                      html += "<td>" + myBislist[i].pro_name + "</td>";
                      html += "<td>" + myBislist[i].price + "</td>";
                      html += "<td>" + myBislist[i].date2 + "</td>";
                   }
                  html += "</tr>";
                }
                $('#hd').empty().html(html);
             }
          });
       }  
</script>

<script type="text/javascript">
	function mypageList(pageNum) 
	{		
		location.href = "mypage.mall?pageNum=" + pageNum + "&category=${category}";
	}	
</script>
<!-- 
<c:if test="${member.type == 2 }">
						<button type="button" onclick="location.href='${path}/product/addProduct.mall'" class="btn btn-info">상품 등록</button>
						<div align="center" id="test">
							<c:if test="${pageNum > 1}">
								<a href="javascript:mypageList(${pageNum - 1})">
							</c:if>[이전]&nbsp;
							<c:if test="${pageNum > 1}"></a></c:if>
							<c:forEach var="a" begin="${startpage}" end="${endpage}">
								<c:if test="${pageNum == a}">[${a}]</c:if>
								<c:if test="${pageNum != a}"><a href="javascript:mypageList(${a})">[${a}]</a></c:if>&nbsp;
							</c:forEach>
							<c:if test="${pageNum < maxpage}">
								<a href="javascript:mypageList(${pageNum + 1})">
							</c:if>[다음]&nbsp;
							<c:if test="${pageNum < maxpage}"></a></c:if>
						</div><br><br><br>
					</c:if>


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
.list_1st{
	border-bottom: 1px solid #e5e5e5;
	margin-top: 20px;
	margin-bottom: 20px;
	padding-bottom: 20px;
}
.list_2nd{
	border-bottom: 1px solid #e5e5e5;
	margin-top: 20px;
	margin-bottom: 20px;
	padding-bottom: 20px;
}
.list_3th{
	margin-top: 20px;
	margin-bottom: 20px;
}

.list_1st a{
	text-decoration: none;
	color: #12d8fa;
}
.list_2nd a{
	text-decoration: none;
	color: black;
}
.list_3th a{
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
.my_category ul li{
	float: left;
	margin-right: 5px;
}
.my_category ul li input{
	width: 80px;	
}
</style> -->
<style type="text/css">
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
						<c:if test="${member.picture!=null }">
						<img style="margin-top: 30px;" src="../prof/${member.picture }" class="img-circle" width="150px" height="150px">
						</c:if>
						<c:if test="${member.picture==null }">
								<img style="margin-top: 30px;" class="img-circle updateimg" src="../prof/prof_1.png" width="150px" height="150px">
						</c:if>
					</div>
					<a href="${path }/member/passConfirmForm.mall"><img style="position: absolute; margin-left: 150px; margin-top: 18px;" src="../img/option.png"></a>
						<br>
					<div style="text-align: center;">${member.name }</div>
				</div>	
				<div class="left_list">
					<ul>
						<c:if test="${member.type == 1 }">
						<li class="list_1st"><a class="on" href="${path }/member/mypage.mall">관심 사업장</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">구매 목록</a></li>
						<li class="list_3th"><a href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 2 }">
						<li class="list_1st"><a class="on" href="${path }/member/mypage.mall">내사업장</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">판매 목록</a></li>
						<li class="list_3th"><a href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 3 }">
						<li class="list_1st"><a class="on" href="${path }/member/mypage.mall">사이트 관리</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">회원 거래 목록</a></li>
						<li class="list_3th"><a href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.id == sana }">
						<li class="list_1st"><a class="on" href="${path }/member/mypage.mall">찌릿찌릿</a></li>
						<li class="list_2nd"><a href="">샤샤샤</a></li>
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
					<h3>
						<c:if test="${member.type == 1 }">
							<strong>관심 사업장</strong>
						</c:if>
						<c:if test="${member.type == 2 }">
							<strong>내 사업장 관리</strong>
						</c:if>
						<c:if test="${member.type == 3 }">
							<strong>사이트 관리</strong>
						</c:if>
						<c:if test="${member.id == sana }">
							<strong>TWICE</strong>
						</c:if> 
					</h3>
					
					<c:if test="${member.type == 2 }">
						<div class="my_category pull-right" style="margin-bottom: 25px;">
						<ul>
							<li><input type="button" class="btn btn-default" onclick="location.href='${path }/member/mypage.mall'" value="전체"></li>
							<li><input type="button" class="btn btn-default category" value="육류"></li>
							<li><input type="button" class="btn btn-default category" value="해산물"></li>
							<li><input type="button" class="btn btn-default category" value="과일"></li>
							<li><input type="button" class="btn btn-default category" value="채소"></li>
							<li><input type="button" class="btn btn-default category" value="곡류"></li>
							<li><input type="button" class="btn btn-default category" value="견과류"></li>
							<li><input type="button" class="btn btn-default category" value="조미료"></li>
						</ul>
						</div>
					</c:if>
					
					<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;" id="hd">
						<thead>
							<tr>
								<c:if test="${member.type == 1 }">
									<th>상호</th>
									<th>연락처</th>
									<th>프리미엄 여부</th>
									<th></th>
								</c:if>
								<c:if test="${member.type == 2 }">
									<th>상품 카테고리</th>
									<th>상품이름</th>
									<th>가격</th>
									<th>등록일자</th>
								</c:if>
								<c:if test="${member.type == 3 }">
									<th>상호</th>
									<th>연락처</th>
									<th>프리미엄 여부</th>
								</c:if>
								<c:if test="${member.id == sana }">
									<th>트</th>
									<th>와</th>
									<th>이</th>
									<th>스</th>
								</c:if>
							</tr>
						</thead>
						<tbody>
							<c:if test="${member.type == 1 }">
								<c:forEach var="mark" items="${bookmark }">
									<tr>
										<td>${mark.bis_name }</td>
										<td>${mark.tel }</td>
										<td>${mark.prim }</td>
										<td><a href="${path }/member/deleteBookmark.mall?mark_no=${mark.mark_no}" style="color: red;">해제하기</a></td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${member.type == 2 }">
							   <c:forEach items="${myBis_list}" var="product">
									<tr>
										<td>${product.category }</td>
										<td><a href="${path }/board/productDetail.mall?pro_no=${product.pro_no}&category=${product.category}">${product.pro_name }</a></td>
										<td>${product.price }원</td>
										<td><f:formatDate value="${product.date }" pattern="yy-MM-dd"/></td>
										<td><a href="${path }/product/productDelete.mall?pro_no=${product.pro_no }">삭제하기</a></td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${member.type == 3 }">
								<c:forEach items="">
									<tr>
										<td>관</td>
										<td>리</td>
										<td>자</td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${member.id == sana }">
								<c:forEach items="">
									<tr>
										<td>사</td>
										<td>나</td>
										<td>쨩</td>
										<td>걸</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					<c:if test="${member.type==1 }">
						<br>
						<br>
						<h3>
							<strong>관심사업장 뉴스피드</strong>
						</h3>
						<table class="table table-hover"
							style="border-bottom: 1px solid #e5e5e5;">
							<thead>
								<tr>
									<th>상호</th>
									<th>상품명</th>
									<th>가격</th>
									<th>카테고리</th>
									<th>상세구분</th>
									<th>등록일</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="feed" items="${newsfeed }">
									<tr>
										<td>${feed.bis_name }</td>
										<td>${feed.pro_name }</td>
										<td>${feed.price }원</td>
										<td>${feed.category }</td>
										<td>${feed.favorite }</td>
										<td><f:formatDate value="${feed.date }" pattern="yy-MM-dd"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
					<c:if test="${member.type == 2 }">
						<button type="button" onclick="location.href='${path}/product/addProduct.mall'" class="btn btn-info">상품 등록</button>
						<div align="center">
							<ul class="pagination">
								<c:if test="${pageNum == 1}">
									<li class="disabled">
										<a aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
									</li>
								</c:if>
								<c:if test="${pageNum > 1}">
									<li class="">
										<a href="javascript:mypageList(${pageNum - 1})" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
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
											<a href="javascript:mypageList(${a})">${a}<span class="sr-only"></span></a>
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
										<a href="javascript:mypageList(${pageNum + 1})" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
									</li>
								</c:if>
							</ul>
						</div><br><br><br>
					</c:if>
				</div>
			</div>
		</div>

		<div class="col-xs-2"></div>
	</div>
</body>
</html>