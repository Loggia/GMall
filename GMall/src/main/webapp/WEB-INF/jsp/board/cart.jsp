<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3><font color="red" >장바구니</font></h3>
		<hr>
	<table align="center" border="1">
	
		<tr>
		<td>상품명</td>
		<td>상품이미지</td>
		<td>가격</td>
		<td>수량</td>
		<td>총액</td>
		<td>취소</td>
		</tr>
		<c:set value="${0}" var="tot"/>
		<c:forEach items="${cart.productList}" var="productSet" varStatus="stat">
			<tr>
			<td>${productSet.product.pro_name}</td>
			<td>${productSet.product.main_img}</td>
			<td>${productSet.product.price}</td>
			<td>${productSet.quantity}</td>
			<td>${productSet.quantity * productSet.product.price} 원</td>
			<td><a href="cartDelete.mall?index=${stat.index}">ⓧ</a></td>
		<c:set var="tot" value="${tot+(productSet.quantity * productSet.product.price)}"/>
		</tr>
		</c:forEach>
		<tr><td colspan="6" align="right">
		<font color="green">총구입금액:${tot}원</font>
		</td></tr>
		
		<tr>
		<td colspan="6" align="right">
		<a href="../board/proList.shop">상품목록보기</a>
		<a href="../checkout/checkout.shop">계산하기</a>
		</td>
		</tr>
	</table>
</body>
</html>