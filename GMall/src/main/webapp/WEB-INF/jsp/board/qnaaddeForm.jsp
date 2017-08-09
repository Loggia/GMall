<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 관리자 권한 글 삭제</title>
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
<form action="qnaadde.mall" name="addeform"  method="post">  
  <input type="hidden" name="num" value="${param.num}">
  <input type="hidden" name="pro_no" value="${param.pro_no}">
  <input type="hidden" name="pageNum" value="${param.pageNum}">
    <table class="table table-hover" style="border-bottom: 1px solid #e5e5e5; width:800px;" align="center">
      <tr>
        <br>
        <td align="center">삭제 확인</td>
      </tr>
      <tr>     
        <td align="center">글을 삭제 하시겠습니까?</td>
      </tr>  
      <tr>
        <td colspan="2" align="center">
          <button class="btn btn-default"><a href="javascript:document.addeform.submit()">삭제</a></button>
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