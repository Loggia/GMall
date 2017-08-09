<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Q&A 등록</title>
<style type="text/css">
a
{
  color : black;
}
.qaloc
{  
  position:absolute; top:97%; left:20%; overflow:hidden; margin-top:100px; margin-left:100px;
}
.qaloc2
{    
  position:absolute; top:82%; left:14%; overflow:hidden; margin-top:100px; margin-left:100px;
}
.qaloc3
{    
  position:absolute; top:81%; left:18%; overflow:hidden; margin-top:100px; margin-left:100px;
}        
</style>  
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
<div class="container-fluid" style="padding-left: 0px; padding-right: 0px;">
  <div class="col-xs-2"></div>
    <div class="col-xs-8 info_content">
<form:form modelAttribute="board" action="qnawrite.mall" method="post" enctype="multipart/form-data" name="qnainform">
	<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5; width:800px;" align="center">
	<form:hidden path="id" value="${userid}"/>
	<form:hidden path="pro_no" value="${pro_no}"/>
	  <tr align="center" valign="middle">
	    <td colspan="2" align="center"><h2>Q&A 작성</h2></td>
	  </tr>  
	  <tr><td>작성자</td>
	      <td>
	        ${userid}
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
	       <td>
	         <input type="file" class="btn btn-default" name="img1">
	         <input type="file" class="btn btn-default" name="img2">
	         <input type="file" class="btn btn-default" name="img3">
	       </td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center">
	      <button class="btn btn-default"><a href="javascript:document.qnainform.submit()">등록</a></button>
	      <button class="btn btn-default"><a href="productDetail.mall?pro_no=${param.pro_no}">게시물 목록</a></button>
	    </td>
	  </tr>                    
	</table>
	<input class="qaloc" type="checkbox" onclick="openpass(this)"><br>
	<div class="qaloc2">비밀글</div>
    <div class="qaloc3" id="passfunction" style="display:none">
       <div>   
          <table>
          <tr>
          	<td><form:password path="pass" /></td>
	      </tr>
	      </table>
	   </div>
    </div>
</form:form>
  </div>
  <div class="col-xs-2"></div>
</div>
</body>
</html>