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
	
	<!--  구정연
	             회원거래목록
	  -->
<table border="1" >
	<tr>
		<td>관리자</td>
		<td>일반회원관리</td>
		<td>사업자관리</td>
		<td>수익금</td>
		<td>GMail톡톡</td>
	</tr>
	<tr>
		<td>회원거래목록</td>
		<td>고객센터</td>
		<td colspan="3">
	 <table border="1">
	<tr>
	<th align="center" width="80">거래타입</th>
	<th align="center" width="200">상품목록</th>
	<th align="center" width="100">가격</th>
	<th align="center" width="80">판매자</th>
	<th align="center" width="80">구매자</th>
	<th align="center" width="100">일자</th>
	</tr>

	<c:forEach items="${tradeList}" var="trade">
	<tr>
	<td align="center">
	<c:if test="${trade.trd_type == 1}">
	구입</c:if>
	<c:if test="${trade.trd_type == 2}">
	판매</c:if>
	</td>
	<td align="left"></td>
	<td align="right">
	<f:formatNumber type="CURRENCY"
	currencySymbol="" value="${trade.trd_money}" minFractionDigits="0"/>원</td>
	<td align="center"></td>
	<td align="center"></td>
	<td align="center"></td>
	</tr>
	</c:forEach>
</table> 
		</td>
	</tr>
</table>

</body>
</html>