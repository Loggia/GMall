<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 글 삭제</title>
<style type="text/css">
a
{
  color : black;
}
</style>  
</head>
<body>
<div class="container-fluid" style="padding-left: 0px; padding-right: 0px;">
  <div class="col-xs-2"></div>
    <div class="col-xs-8 info_content">
<form action="qnadelete.mall" name="deleteform"  method="post">
  <input type="hidden" name="num" value="${param.num}">
  <input type="hidden" name="pageNum" value="${param.pageNum}">
  <input type="hidden" name="pro_no" value="${param.pro_no}">
    <table class="table table-hover" style="border-bottom: 1px solid #e5e5e5; width:500px;" align="center">
      <tr>
        <td align="center">게시글 비밀번호</td>  
        <td><input type="password" name="pass"></td>
      </tr>  
      <tr>
        <td colspan="2" align="center">
          <button class="btn btn-default"><a href="javascript:document.deleteform.submit()">삭제</a></button>
          <button class="btn btn-default"><a href="productDetail.mall?pro_no=${param.pro_no}&pageNum=${param.pageNum}">목록</a></button>
        </td>
     </tr>
    </table>    
</form>
  </div>
  <div class="col-xs-2"></div>
</div>
</body>
</html>