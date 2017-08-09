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
<form:form modelAttribute="trade" action="" name="tradeForm">
${trade.address}
${trade.buy_id}
${trade.trd_date}
${trade.delivery}
${trade.rv_chk}
${trade.trd_cnt}
${trade.trd_money}
${trade.pro_no}
${trade.sell_id}
<hr>
${trade.trd_code}

<input type="submit" value="사업자 즐겨찾기">
</form:form>
</body>
</html>