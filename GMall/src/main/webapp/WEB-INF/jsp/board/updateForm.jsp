<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객센터 글 수정</title>
<script type="text/javascript">
  function file_delete() {
	document.updateform.filep.value="";
    document.getElementById("file_desc").innerHTML="";
  }
  function file_delete2() {
	document.updateform.filep2.value="";
	   document.getElementById("file_desc2").innerHTML="";
  }
  function file_delete3() {
	document.updateform.filep3.value="";
	document.getElementById("file_desc3").innerHTML="";
  }
</script>
</head>
<body>
<form:form modelAttribute="board" action="update.mall?pageNum=${pageNum}" enctype="multipart/form-data" name="updateform">
	<input type="hidden" name="filep" value="${board.fileurl}">
	<input type="hidden" name="filep2" value="${board.fileurl2}">
	<input type="hidden" name="filep3" value="${board.fileurl3}">
	<form:hidden path="board_no" />
	<form:hidden path="id" />
	<table cellpadding="0" cellspacing="0" border="1">
	  <tr><td colspan="2">고객센터 글 수정</td></tr>
	  <tr><td>제목</td>
	      <td><form:input path="subject" />
	      <font color="red"><form:errors path="subject"/></font></td>
      </tr>
      <tr><td>내용</td>
	      <td><form:textarea path="content" cols="67" rows="15"/>
	      <font color="red"><form:errors path="content"/></font></td>
      </tr>
      <tr><td>첨부파일</td><td>&nbsp;
      	 <c:if test="${!empty board.fileurl}">
      	   <div id="file_desc">
      	     <a href="./fileupload/${board.fileurl}">${board.fileurl}</a>&nbsp;
             <a href="javascript:file_delete()">[첨부파일1 삭제]</a>
      	   </div>
      	 </c:if>
      	 <c:if test="${!empty board.fileurl2}">
      	   <div id="file_desc2">
      	     <a href="./fileupload/${board.fileurl2}">${board.fileurl2}</a>&nbsp;
             <a href="javascript:file_delete2()">[첨부파일2 삭제]</a>
      	   </div>
      	 </c:if>
      	 <c:if test="${!empty board.fileurl3}">
      	   <div id="file_desc3">
      	     <a href="./fileupload/${board.fileurl3}">${board.fileurl3}</a>&nbsp;
             <a href="javascript:file_delete3()">[첨부파일3 삭제]</a>
      	   </div>
      	 </c:if>
      	 <div>첨부파일 1 : <input type="file" name="img1"></div>
      	 <div>첨부파일 2 : <input type="file" name="img2"></div>
      	 <div>첨부파일 3 : <input type="file" name="img3"></div>     
      	 </td> 	  
      </tr>
      <tr><td>비밀번호</td>
        <td><form:password path="pass" />
        <font color="red"><form:errors path="pass"/></font></td>
      </tr>
      <tr><td colspan="2" align="center">
        <a href="javascript:document.updateform.submit()">[수정]</a>&nbsp;
        <a href="centerList.mall?pageNum=${param.pageNum}">[목록]</a></td>
      </tr>                  	 
	</table>  
</form:form>
</body>
</html>