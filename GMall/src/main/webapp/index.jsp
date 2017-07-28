<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>인덱스!</title>
</head>
<body>
	<a href="member/joinForm.mall">&nbsp;&nbsp;&nbsp;JoinForm</a>
	<br>
	<br>
	<a href="board/main.mall">&nbsp;&nbsp;&nbsp;Main</a>
	<br>
	<br>
	<a href="member/adminForm.mall">&nbsp;&nbsp;&nbsp;adminForm</a>
	<br>
	<br>
	<a href="member/mypage.mall">&nbsp;&nbsp;&nbsp;mypage</a>
	<br>
	<br>
	<a href="board/centerAdd.mall">&nbsp;&nbsp;&nbsp;centerAdd</a>
	<br>
	<br>
	<a href="product/productAddForm.mall">&nbsp;&nbsp;&nbsp;productAdd</a>
    <br>
	<br>
	<a href="product/myBusiness.mall">&nbsp;&nbsp;&nbsp;myBis_List</a>
	<br>
	<br>
	<a href="board/centerList.mall">&nbsp;&nbsp;&nbsp;centerList</a>
		<br>
	<br>
	<a href="member/passConfirm.mall">&nbsp;&nbsp;&nbsp;passConfirm</a>
		<br>
	<br>
	<a href="member/primlist.mall">&nbsp;&nbsp;&nbsp;프리미엄</a>
</body>
</html>