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
<table border="1" cellpadding="0" cellspacing="0"align="center" width="70%">
	<tr>
		<th>아이디</th>
		<th>닉네임</th>
		<th>패스워드</th>
		<th>이름</th>
		<th>성별</th>
		<th>연락처</th>
	</tr>
	<c:forEach items="${nomalList}" var="nomal">
	<tr>
	<td>${nomal.id}</td>
	<td>${nomal.nickname}</td>
	<td>${nomal.pass}</td>
	<td>${nomal.name}</td>
	<td>${nomal.gender}</td>
	<td>${nomal.tel}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>