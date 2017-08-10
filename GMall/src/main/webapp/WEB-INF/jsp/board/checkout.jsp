<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h2>구매자 정보</h2>
		<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;">
			<tr>
				<th>받는 사람</th>
				<th>연락처</th>
				<th>배송지</th>
				<th>배송지 변경</th>
			</tr>
			
			<tr>
				<td>${member.name }</td>
				<td>${member.tel }</td>
				<td>${member.address }</td>
				<td><input type="text" name="address" value=""></td>
			</tr>	
		</table>
		
		<form action="${path }/board/end.mall?his_no=${his_no}" method="post" name="checkoutForm">
			<h2>구매 목록</h2>
			<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;">
				<tr>
					<th>상호</th>
					<th>상품명</th>
					<th>상품 가격</th>
					<th>수량</th>
					<th>총액</th>
				</tr>
				<c:forEach items="${proList}" var="productSet">
					<tr>
						<td>${productSet.product.bis_name }</td>
						<td>${productSet.product.pro_name}</td>
						<td>${productSet.product.price}원</td>
						<td>${productSet.quantity}개</td>
						<td>${productSet.quantity * productSet.product.price}원</td>
					</tr>
				</c:forEach>
				
				<tr>
					<td colspan="3" align="center">
						<select name="selectCoupon" id="selectCoupon" class="form-control" style="width: 170px; cursor: pointer;">
							<option value="none/none/none">할인 쿠폰</option>
							<c:forEach items="${coupon_history }" var="coupons">
								<option value="${coupons.his_no }/${coupons.bis_no }/${coupons.discount }">${coupons.bis_name } / ${coupons.discount }%</option>
							</c:forEach>
						</select>
						
						<script type="text/javascript">
							$("#selectCoupon").val("${selectCoupon}");
						
							$(document).ready(function()
							{
								$("#selectCoupon").change(function()
								{
									location.href="../board/checkout.mall?&selectCoupon=" + $(this).val();
								});
							});
						</script>
					</td>
					<td colspan="2" align="center">총합: ${totalAmount}원</td>
				</tr>
			</table>
			
			<input type="submit" value="구매하기">&nbsp;
			
			<h2>쿠폰사용</h2>
			<c:forEach items="${coupon}" var="coupon">
				<input type="button" value="${coupon.cop_no}">
			</c:forEach>
		</form>
		<a href="../board/proList.mall">목록보기</a>
	</body>
</html>