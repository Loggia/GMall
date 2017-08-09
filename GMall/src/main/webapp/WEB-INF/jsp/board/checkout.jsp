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
<h2>구매자 정보</h2>
<table>
	<tr><td>구매자</td><td>${loginMember.nickname}</td></tr>
	<tr><td>이름</td><td>${loginMember.name}</td></tr>
	<tr><td>연락처</td><td>${loginMember.tel}</td></tr>
	<tr><td>주소</td><td>${loginMember.address}</td></tr>
</table>
	<br><br>
 <form:form modelAttribute="trade" action="end.mall" name="tradeForm">
<h2>배송지 주소</h2>
<table>
	<tr><td>주소</td><td><input name="trd_address"></input></td></tr>
</table>

<h2>쿠폰사용</h2>
	<c:forEach items="${coupon}" var="coupon">
		<input type="button" value="${coupon.cop_no}">
	</c:forEach>

<h2>장바구니 목록</h2>
<table>
<tr>
	<th>상품명</th>
	<th>가격</th>
	<th>수량</th>
	<th>소계</th>
</tr>
	<c:forEach items="${proList}" var="productSet">
		<tr>
			<td>${productSet.product.pro_name}</td>
			<td>${productSet.product.price}원</td>
			<td>${productSet.quantity}개</td>
			<td>${productSet.quantity * productSet.product.price}원</td>
		</tr>
	</c:forEach>
</table>
<br><b>총금액:${totalAmount}원</b>
<br><br><input type="submit" value="구매하기">&nbsp;
</form:form>
<a href="../board/proList.mall">목록보기</a>
</body>
</html>