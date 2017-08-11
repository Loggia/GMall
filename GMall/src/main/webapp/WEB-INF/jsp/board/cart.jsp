<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	
		<link rel="stylesheet" type="text/css" href="${path }/css/delvpage.css"> 
		<style type="text/css">
		
		.float {
		 	float: right;
		}
		
		.circle1 {
			 width:100px;
			 height:100px;
			 border-radius:100px;
			 -moz-border-radius : 100px;
			 -webkit-border-radius : 100px;
			 -ms-border-radius :100px;
			 -khtml-border-radius : 100px;
			 -o-border-radius :100px;
			 background:#09F;
			 font:normal 12px/100px "나눔고딕", "돋움", "굴림";
			 color:#fff;
			 text-align:center;
			 display: inline-block;
			}
		.circle2 {
			 width:100px;
			 height:100px;
			 border-radius:100px;
			 -moz-border-radius : 100px;
			 -webkit-border-radius : 100px;
			 -ms-border-radius :100px;
			 -khtml-border-radius : 100px;
			 -o-border-radius :100px;
			 background:#2b68a7;
			 font:normal 12px/100px "나눔고딕", "돋움", "굴림";
			 color:#fff;
			 text-align:center;
			 display: inline-block;
			}
		font {
		font-family : Times New Roman;
		font-weight: bold;
		}
		
		.box {
			width: 100%;
			height: 140px;
			border-radius: 5px;
			background:#dddee0;
			border-bottom: 5px black;
		}
		</style>
	</head>

		<body>
		<div class="container-fluid" style="padding-left: 0px; padding-right: 0px;">
		
		<div class="col-xs-2"></div>

		<div class="col-xs-8 info_content">
		<div class="float">
		<br>
	<p class="circle1"><img src="../img/baguni.png" width="64px" height="64px"></p> <font >BASKET</font>
		<img src="../img/arrow.png" width="30px" height="30px;">
	<P class="circle2"><img src="../img/daller.png" width="64px" height="64px"></p> <font >PAYMENT</font>
	<img src="../img/arrow.png" width="30px" height="30px;">
	<P class="circle2"><img src="../img/order.png" width="64px" height="64px"></p> <font >COMPLETE</font>
		<br>
		</div>
		<p class="box"><font><br><br><br><font size="10px">장바구니</font></p>
			<br><br><br>
		<table class="table table-hover" style="border-bottom: 5px solid #e5e5e5;" width="80%;">
			<tr>
			
				<th>상호</th>
				<th>상품명</th>
				<th>가격</th>
				<th>수량</th>
				<th>총액</th>
			</tr>
			
			<c:set value="${0}" var="tot"/>
			<c:forEach items="${cart.productList}" var="productSet" varStatus="stat">
				<tr>
					<td>${productSet.product.bis_name }</td>
					<td>${productSet.product.pro_name}</td>
					<td>${productSet.product.price}</td>
					<td>${productSet.quantity}</td>
					<td>${productSet.quantity * productSet.product.price} 원
						<a href="cartDelete.mall?index=${stat.index}">ⓧ</a>
					</td>
					<c:set var="tot" value="${tot+(productSet.quantity * productSet.product.price)}"/>
				</tr>
			</c:forEach>
			
			<tr>
				<td colspan="5" align="right">
					<font color="green">총구입금액:${tot}원</font>
				</td>
			</tr>
		</table>
			<div class="float">
		 <input id="loc5" type="button" class="btn btn-success" value="목록보기" onclick="location.href='proList.mall?category=${category}'">
		<input id="loc5" type="button" class="btn btn-success" value="구매하기" onclick="location.href='../board/checkout.mall'">
			</div>
		</div>
			<div class="col-xs-2"></div>
			</div>
			
	</body>
</html>