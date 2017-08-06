<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 관리자 권한 글 삭제</title>
</head>
<body>
<form action="qnaadde.mall" name="addeform"  method="post">  
  <input type="hidden" name="num" value="${param.num}">
  <input type="hidden" name="pro_no" value="${param.pro_no}">
  <input type="hidden" name="pageNum" value="${param.pageNum}">
    <table border="1">
      <tr><td>삭제 확인</td>
        <td>글을 삭제 하시겠습니까?</td>
      </tr>
        <tr><td colspan="2" align="center">
        <a href="javascript:document.addeform.submit()">[삭제]</a>
        <a href="productDetail.mall?pro_no=${param.pro_no}&pageNum=${param.pageNum}">[목록]</a>
        </td></tr>
    </table>    
</form>
</body>
</html>