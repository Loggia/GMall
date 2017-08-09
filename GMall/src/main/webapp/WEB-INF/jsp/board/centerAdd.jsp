<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 등록</title>
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
<style type="text/css">
.cdloc
{  
  position:absolute; top:97%; left:20%; overflow:hidden; margin-top:100px; margin-left:100px;
}
.cdloc2
{    
  position:absolute; top:82%; left:14%; overflow:hidden; margin-top:100px; margin-left:100px;
}
.cdloc3
{    
  position:absolute; top:81%; left:18%; overflow:hidden; margin-top:100px; margin-left:100px;
}
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
<form:form modelAttribute="board" action="centerwrite.mall" method="post" enctype="multipart/form-data" name="centerinform">
	<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5; width:800px;" align="center">
	<form:hidden path="id" value="${userid}"/>
	  <tr align="center" valign="middle">  
	    <td colspan="2" align="center"><h2>고객센터 글 작성</h2></td>
	  </tr>
	  <tr>
	    <td>작성자</td>
	    <td>${userid}</td>
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
	         <input class="btn btn-default" type="file" name="img1">
	         <input class="btn btn-default" type="file" name="img2">
	         <input class="btn btn-default" type="file" name="img3">
	       </td>
	  </tr>
	  <tr>
	    <td colspan="2" align="center">
	      <button class="btn btn-default"><a href="javascript:document.centerinform.submit()">등록</a></button>
	      <button class="btn btn-default"><a href="centerList.mall">목록</a></button>
	    </td>
	  </tr>                      
	</table>
	<input class="cdloc" type="checkbox" onclick="openpass(this)"><br>
	<div class="cdloc2">비밀글</div>
    <div class="cdloc3" id="passfunction" style="display:none">
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