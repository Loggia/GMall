<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>

		<body>
	<h1>장바구니</h1>
	<hr>
		<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;">
			<tr>
				<td colspan="4">
					<font color="red">장바구니 상품은 다음과 같습니다</font>
				</td>
			</tr>
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
		
		<a href="../board/proList.shop">상품목록보기</a>
		<a href="../board/checkout.mall">계산하기</a>
	</body>
</html>