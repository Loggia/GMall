<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review 등록</title>
<style type="text/css">
select option
{
  color : #EDD200;
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
<form:form modelAttribute="board" action="reviewwrite.mall" method="post" enctype="multipart/form-data" name="reviewinform">
	<input type="hidden" name="sellid" value="${sellinfo.sell_id}">
	<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5; width:850px;" align="center">
	<form:hidden path="id" value="${userid}"/>
	<form:hidden path="pro_no" value="${pro_no}"/>
	  <tr align="center" valign="middle">
	    <td colspan="2"><h2>Review 작성</h2></td>
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
	  <tr>
	    <td>
	      <h3>평점주기</h3> 
	    </td>
	    <td>        
	        <form:select class="form-control" id="gvalue" onchange='changes(value)' path="grade" style="margin-left: 15px; margin-right: 5px; width: 120px; float:left; color:#EDD200; display:inline-block;">
              <option value="2">★</option>
              <option value="4">★★</option>   
              <option value="6">★★★</option>    
              <option value="8">★★★★</option>
              <option value="10">★★★★★</option>  
            </form:select>
	    </td>
	  </tr>  
	  <tr>
	    <td colspan="2" align="center">
	      <button class="btn btn-default"><a href="javascript:document.reviewinform.submit()">등록</a></button>
	      <button class="btn btn-default"><a href="productDetail.mall?pro_no=${param.pro_no}">리뷰 목록</a></button>
	    </td>
	  </tr>                    
	</table>
</form:form>
  </div>
  <div class="col-xs-2"></div>
</div>
</body>
</html>