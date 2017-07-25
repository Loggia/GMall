<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/jspHeader.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>나의 사업장 관리</title>
</head>

<body>
<table border="2" align="center">
<tr><td onclick="location.href='categoryCheck.mall?category=육류'">육류</td>
    <td onclick="location.href='categoryCheck.mall?category=해산물'">해산물</td>
    <td onclick="location.href='categoryCheck.mall?category=과일'">과일</td>
    <td onclick="location.href='categoryCheck.mall?category=채소'">채소</td>
    <td onclick="location.href='categoryCheck.mall?category=곡류'">곡류</td>
    <td onclick="location.href='categoryCheck.mall?category=견과류'">견과류</td>
    <td onclick="location.href='categoryCheck.mall?category=조미료'">조미료</td>
 </tr></table>
<br>
<br>

<table border="1">
 <tr><th align="center" width="80">상품 카테고리</th>
     <th align="center" width="320">상품이름</th>
     <th align="center" width="100">가격</th>
     <th align="center" width="80">등록일자</th>

  <c:forEach items="${myBis_list}" var="product">
  <tr><td align="center">${product.category }</td>
  <td align="left">${product.pro_name }</td>
  <td align="right">${product.pro_name }원</td>
  <td align="right"><f:formatDate value="${product.date }" pattern="yy-MM-dd"/></td></tr>
  </c:forEach>
</table>
</body>
</html>
