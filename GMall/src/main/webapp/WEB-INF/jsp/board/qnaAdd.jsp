<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 등록</title>
<script>
 function openpass(check) {
   if(check.checked == true)
   {
	 passfunction.style.display = '';
   }	  
   else
   {
     passfunction.style.display = 'none';
   }
 }
</script>
</head>
<body>
<form:form modelAttribute="board" action="qnawrite.mall" method="post" enctype="multipart/form-data" name="qnainform">
	<table cellpadding="0" cellspacing="0">
	<form:hidden path="id" value="${userid}"/>
	<form:hidden path="pro_no" value="${pro_no}"/>
	  <tr align="center" valign="middle">
	    <td colspan="2">Q&A 글 작성</td>
	  </tr>
	  <tr><td>글쓴이</td>
	      <td>
	      <h3>${userid}</h3>
	      </td>
	  </tr>
	  <tr><td>제목</td>
	      <td><form:input path="subject" />
	      <font color="red"><form:errors path="subject" /></font>
	      </td>
	  </tr>
	  <tr><td>내용</td>
	      <td><form:textarea path="content" cols="67" rows="15"/>
	      <font color="red"><form:errors path="content" /></font>
	      </td>
	  </tr>
	  <tr><td>파일첨부</td>
	       <td><input type="file" name="img1"></td>
	       <td><input type="file" name="img2"></td>
	       <td><input type="file" name="img3"></td>
	  </tr>
	  <tr><td colspan="2" align="center">
	      <a href="javascript:document.qnainform.submit()">[등록]</a>
	      <a href="productDetail.mall?pro_no=${param.pro_no}">[게시물 목록]</a>
	      </td>
	  </tr>                    
	</table>
	<input type="checkbox" onclick="openpass(this)">비밀글
    <div id="passfunction" style="display:none">
       <div>
          <table>
          <tr><td>비밀번호</td>
	          <td><form:password path="pass" /></td>
	      </tr>
	      </table>
	   </div>
    </div>
</form:form>
</body>
</html>