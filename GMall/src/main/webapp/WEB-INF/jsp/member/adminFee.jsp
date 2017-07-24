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
<table border="1" cellpadding="0" cellspacing="0" align="center" width="70%">
	<tr>
		<th>사업자</th>
		<th>거래상품</th>
		<th>주문금액</th>
		<th>수수료</th>
		<th>일자</th>
	</tr>
	<tr>
		<c:forEach items="${tradeList}" var="trade">
			<td>${trade.sell_id }</td>
			<td>${trade.pro_name}</td>
			<td><f:formatNumber type="CURRENCY" 
	currencySymbol="" value="${trade.trd_money}" minFractionDigits="0"/>원</td>
			<td>+<f:formatNumber type="CURRENCY" 
	currencySymbol="" value="${trade.trd_money * 1.1 - trade.trd_money}" minFractionDigits="0"/>원</td>
			<td>${trade.trd_date}</td>
		</c:forEach>
	</tr>
</table>
</body>
</html>