<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 등록</title>
</head>
<body>
<form:form modelAttribute="board" action="centerwrite.mall" method="post" enctype="multipart/form-data" name="centerinform">
	<table cellpadding="0" cellspacing="0">
	  <tr align="center" valign="middle">
	    <td colspan="2">고객센터 글 작성</td>
	  </tr>
	  <tr><td>글쓴이</td>
	      <td><form:input path="id" />
	      </td>
	  </tr>
	  <tr><td>제목</td>
	      <td><form:input path="subject" />
	      </td>
	  </tr>
	  <tr><td>비밀번호</td>
	      <td><form:password path="pass" />
	      </td>
	  </tr>
	  <tr><td>내용</td>
	      <td><form:textarea path="content" cols="67" rows="15"/>
	      </td>
	  </tr>
	  <tr><td>파일첨부</td>
	       <td><input type="file" name="img1"></td>
	       <td><input type="file" name="img2"></td>
	       <td><input type="file" name="img3"></td>
	  </tr>
	  <tr><td colspan="2" align="center">
	      <a href="javascript:document.centerinform.submit()">[등록]</a>
	      <a href="centerList.mall">[게시물 목록]</a>
	      </td>
	  </tr>                    
	</table>  
</form:form>
</body>
</html>