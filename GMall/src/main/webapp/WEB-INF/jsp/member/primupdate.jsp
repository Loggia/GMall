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
<h1 align="center">업데이트됨</h1>
<table border="1" align="center">
	<tr>
		<td>프리미엄 업데이트</td>
	</tr>
	<c:forEach items="${primList }" var="prim">
	<tr>
		<td>${prim.nickname }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>