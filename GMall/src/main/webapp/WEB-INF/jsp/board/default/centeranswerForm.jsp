<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객센터 답변</title>
</head>
<body>
<form:form modelAttribute="board" action="centeranswer.mall?pageNum=${pageNum}" enctype="multipart/form-data" name="answerform">
	<form:hidden path="board_no" />
	<form:hidden path="id" />
	<table cellpadding="0" cellspacing="0" border="1">
	  <tr><td colspan="2">고객센터 답변</td></tr>
	  <tr><td>제목</td>
	      <td><form:input path="subject" />
	      <font color="red"><form:errors path="subject"/></font></td>
      </tr>
      <tr><td>내용</td>
	      <td><form:textarea path="content" cols="67" rows="15"/>
	      <font color="red"><form:errors path="content"/></font></td>
      </tr>
      <tr><td colspan="2" align="center">
        <a href="javascript:document.answerform.submit()">[답변]</a>&nbsp;
        <a href="centeraddeForm.mall?num=${board.board_no}&pageNum=${param.pageNum}">[삭제]</a>
        <a href="centerList.mall?pageNum=${param.pageNum}">[목록]</a></td>
      </tr>                  	 
	</table>  
</form:form>
</body>
</html>