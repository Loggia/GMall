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
</style>
</head>
<body>
<form:form modelAttribute="board" action="reviewwrite.mall" method="post" enctype="multipart/form-data" name="reviewinform">
	<input type="hidden" name="sellid" value="${sellinfo.sell_id}">
	<table cellpadding="0" cellspacing="0">
	<form:hidden path="id" value="${userid}"/>
	<form:hidden path="pro_no" value="${pro_no}"/>
	  <tr align="center" valign="middle">
	    <td colspan="2">Review 글 작성</td>
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
	  <tr>
	    <td>
	      <h3>평점주기</h3><br>
	        <form:select class="form-control" id="gvalue" onchange='changes(value)' path="grade" style="margin-left: 15px; margin-right: 5px; width: 120px; float:left; color:#EDD200; display:inline-block;">
              <option value="2">★</option>
              <option value="4">★★</option>   
              <option value="6">★★★</option>    
              <option value="8">★★★★</option>
              <option value="10">★★★★★</option>  
            </form:select>
	    </td>
	  </tr>  
	  <tr><td colspan="2" align="center">
	      <a href="javascript:document.reviewinform.submit()">[등록]</a>
	      <a href="productDetail.mall?pro_no=${param.pro_no}">[리뷰 목록]</a>
	      </td>
	  </tr>                    
	</table>
</form:form>
</body>
</html>