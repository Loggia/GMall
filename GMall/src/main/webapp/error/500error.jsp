<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Anton|Karla" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Anton|Fredoka+One|Karla" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Anton|Fredoka+One|Karla|Luckiest+Guy" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Anton|Fredoka+One|Karla|Luckiest+Guy|Zilla+Slab+Highlight" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Anton|Fredoka+One|Karla|Luckiest+Guy|Monofett" rel="stylesheet">

<style type="text/css">
.error_code {
	font-size: 65px;
	color: #1266FF;
	font-family: 'Monofett', cursive;
}
.error_content {
	font-size: 40px;
	font-family: 'Luckiest Guy', cursive;
	color: #747474;
}
</style>
</head>
<body>
<div class="container-fluid">
	<div class="col-xs-2"></div>
	<div class="col-xs-8">
		<div class="error_main" style="text-align: center;" align="center">
			<a href="${path}/board/main.mall" style="cursor: pointer;"><img src="../img/logo.png" style="margin: 100px auto; width: 600px; height: 260px; display: block;"></a>
			
			<span class="error_code">500</span>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<span class="error_content">Page Error</span>
			
		</div>
	</div>
	<div class="col-xs-2"></div>
</div>
</body>
</html>