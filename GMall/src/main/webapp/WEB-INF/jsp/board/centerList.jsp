<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객센터 글목록</title>
<style type="text/css">
#loc
{
  text-align : center;
}
#loc2
{
  text-align : right;
}
</style>
<script>
 function list_disp(id)
  {
	  var disp = document.getElementById(id);
	  if(disp.style.display == 'block')
      {
		  disp.style.display = 'none';
      }
	  else
      {
		  disp.style.display = 'block';
      }
	  
  }
  
 function list(pageNum) 
 {
		var searchType = document.searchform.searchType.value;
		if(searchType == null || searchType.length == 0)
		{
			document.searchform.searchContent.value = "";
			document.searchform.pageNum.value = 1;
			location.href = "centerList.mall?pageNum=" + pageNum;
		}
		else
		{
			document.searchform.pageNum.value = pageNum;
			document.searchform.submit();
			return true;
		}
		return false;
 }
</script>
</head>
<body> 
<div style="display:block; width:100%;">
<table border="1" cellpadding="0" cellspacing="0" width="100%">
<c:if test="${listcount > 0}">
	<tr width="100%">
	  <td colspan="5" align="center"><h1>고객센터</h1></td></tr>
	  <tr><td width="20%" align="center">글번호</td><td width="20%" align="center">답변상태</td>
	      <td width="20%" align="center">제목</td><td width="20%" align="center">작성자</td>
	      <td width="20%" align="center">날짜</td></tr>
	  <c:forEach items="${centerlist}" var="clist" varStatus="stat">
	    <tr>
          <td align="center">${clist.board_no}</td>
          <td align="center">
          <c:if test="${(clist.ans_chk == 0) && userid != 'admin' && userid == clist.id && empty param.pageNum}"> 
            <a href="centerupdateForm.mall?num=${clist.board_no}&pageNum=1">[수정]</a>
          </c:if>
          <c:if test="${(clist.ans_chk == 0) && userid != 'admin' && userid == clist.id && not empty param.pageNum}"> 
            <a href="centerupdateForm.mall?num=${clist.board_no}&pageNum=${param.pageNum}">[수정]</a>
          </c:if>
          <c:if test="${(clist.ans_chk == 0) && userid != 'admin' && userid != clist.id}"> 
            <font color="red">미답변</font>
          </c:if>
          <c:if test="${(clist.ans_chk == 0) && userid == 'admin'&& empty param.pageNum}"> 
            <a href="centeranswerForm.mall?num=${clist.board_no}&pageNum=1">[답변]</a>
          </c:if>
          <c:if test="${(clist.ans_chk == 0) && userid == 'admin'&& not empty param.pageNum}"> 
            <a href="centeranswerForm.mall?num=${clist.board_no}&pageNum=${param.pageNum}">[답변]</a>
          </c:if>
          <c:if test="${clist.ans_chk == 1}"> 
             <font color="blue">√</font>
          </c:if> 
          </td>
          <c:if test="${not empty clist.pass}">
          <td align="center"><a href="javascript:list_disp('listLine${stat.count}')">${clist.subject}</a><img src="../img/rock.jpg" width="20" height="20" /></td>
          </c:if>
          <c:if test="${empty clist.pass}">
          <td align="center"><a href="javascript:list_disp('listLine${stat.count}')">${clist.subject}</a></td>
          </c:if>
	      <td align="center">${clist.id}</td>
	      <td align="center"><f:formatDate value="${clist.regdate}" pattern="yyyy-MM-dd"/></td>
	     </tr>
	     <tr>
	       <td colspan="5">
	        <div id="listLine${stat.count}" style="display:none;">
	        <c:if test="${not empty clist.pass && empty param.searchType && empty param.searchContent && empty param.num && empty param.password}"> 
	          <form action="centerList.mall" method="get" name="onpass" id="loc">
	                       비밀번호 : 
	          	<input type="hidden" name="pageNum" value="${param.pageNum}">
	          	<input type="hidden" name="num" value="${clist.board_no}">
                <input type="text" name="password">
                <input type="submit" value="확인">
              </form>
            </c:if>
            <c:if test="${not empty clist.pass && not empty param.pageNum &&not empty param.searchType && not empty param.searchContent && empty password}"> 
	          <form action="centerList.mall" method="get" name="onpass2" id="loc">
	                       비밀번호 : 	     
	            <input type="hidden" name="pageNum" value="${param.pageNum}">  
	            <input type="hidden" name="searchType" value="${param.searchType}">  
	            <input type="hidden" name="searchContent" value="${param.searchContent}">  	                          
	          	<input type="hidden" name="num" value="${clist.board_no}">
                <input type="text" name="password">
                <input type="submit" value="확인">
              </form>
            </c:if>
	        <%-- <c:if test="${(not empty clist.pass) && (not empty searchType2 && not empty searchContent2) && (num != clist.board_no)}"> 
	          <form action="centerList.mall" method="post" name="onpass3" id="loc">
	                       비밀번호 : 
	            <input type="hidden" name="pageNum2" value="${param.pageNum2}">
	            <input type="hidden" name="searchType2" value="${param.searchType2}">
	            <input type="hidden" name="searchContent2" value="${param.searchContent2}">           
	          	<input type="hidden" name="num" value="${clist.board_no}">
                <input type="text" name="password">
                <input type="submit" value="확인">
              </form>
            </c:if>   --%>
            <c:if test="${not empty password && not empty num}"> 
             <c:if test="${(clist.pass == password) && (clist.board_no == num)}">
            	<table border="1" cellpadding="0" cellspacing="0" width="100%" height="70%">
	           <tr>
	          	 <td align="center">내용 : ${clist.content}</td>
               </tr> 
               <tr>  
                  <td align="center">첨부파일 → 
                    <c:if test="${empty clist.fileurl || clist.fileurl2 || clist.fileurl3}"> 
                       <font color="gray">첨부파일 없음</font>
                    </c:if>
                    <c:if test="${not empty clist.fileurl}"> 
                       <a href="filedown.mall?filename=${clist.fileurl}">${clist.fileurl}</a>
                    </c:if>
                    <c:if test="${not empty clist.fileurl2}"> 
                       <a href="filedown.mall?filename=${clist.fileurl2}">${clist.fileurl2}</a>
                    </c:if>
                    <c:if test="${not empty clist.fileurl3}"> 
                       <a href="filedown.mall?filename=${clist.fileurl3}">${clist.fileurl3}</a>
                    </c:if>
                 </td>
               </tr> 
             </table>
	         </c:if>
	         <c:if test="${((clist.pass != password) || (clist.board_no != num)) && empty param.searchType}">
	          <form action="centerList.mall" method="get" name="onpass4" id="loc">
	                       비밀번호 : 
	            <input type="hidden" name="pageNum" value="${param.pageNum}">
	          	<input type="hidden" name="num" value="${clist.board_no}">
                <input type="text" name="password">
                <input type="submit" value="확인">
              </form>
	         </c:if> 
	         <c:if test="${(clist.pass != password && not empty clist.pass) && (not empty param.pageNum && not empty param.searchType && not empty param.searchContent && not empty param.num && not empty param.password)}">
	         	<form action="centerList.mall" method="get" name="onpass5" id="loc">
	                       비밀번호 : 
	            <input type="hidden" name="pageNum" value="${param.pageNum}">  
	            <input type="hidden" name="searchType" value="${param.searchType}">  
	            <input type="hidden" name="searchContent" value="${param.searchContent}">           
	          	<input type="hidden" name="num" value="${clist.board_no}">
                <input type="text" name="password">
                <input type="submit" value="확인">
              </form>
	         </c:if>
	        </c:if> 
	        <c:if test="${empty clist.pass}"> 
	          <table border="1" cellpadding="0" cellspacing="0" width="100%" height="70%">
	           <tr>
	          	 <td align="center">내용 : ${clist.content}</td>
               </tr> 
               <tr>  
                  <td align="center">첨부파일 → 
                    <c:if test="${empty clist.fileurl || clist.fileurl2 || clist.fileurl3}"> 
                       <font color="gray">첨부파일 없음</font>
                    </c:if>
                    <c:if test="${not empty clist.fileurl}"> 
                       <a href="filedown.mall?filename=${clist.fileurl}">${clist.fileurl}</a>
                    </c:if>
                    <c:if test="${not empty clist.fileurl2}"> 
                       <a href="filedown.mall?filename=${clist.fileurl2}">${clist.fileurl2}</a>
                    </c:if>
                    <c:if test="${not empty clist.fileurl3}"> 
                       <a href="filedown.mall?filename=${clist.fileurl3}">${clist.fileurl3}</a>
                    </c:if>
                 </td>
               </tr> 
             </table>
            </c:if> 
            </div>
		  </td>
        </tr>
      </c:forEach>
<tr align="center" height="26">
  <td colspan="5">
        <c:if test="${pageNum > 1}">
           <a href="javascript:list(${pageNum - 1})">
        </c:if>[이전]&nbsp;
        <c:if test="${pageNum > 1}"></a></c:if>
        <c:forEach var="a" begin="${startpage}" end="${endpage}">
  	       <c:if test="${pageNum == a}">[${a}]</c:if>
  	       <c:if test="${pageNum != a}"><a href="javascript:list(${a})">[${a}]</a></c:if>&nbsp;  	 
        </c:forEach>
        <c:if test="${pageNum < maxpage}">
           <a href="javascript:list(${pageNum + 1})">
        </c:if>[다음]&nbsp;
        <c:if test="${pageNum < maxpage}"></a></c:if>
  </td>
</tr>         		
</c:if>
<c:if test="${listcount ==0}">
  <tr><td colspan="5">등록된 게시물이 없습니다.</td></tr>
</c:if>
<tr><td colspan="5" align="center">
  <form action="centerList.mall" method="get" name="searchform" onsubmit="return list(1)">
  	<input type="hidden" name="pageNum" value="1">
  	<select name="searchType" id="searchType">
  	  <option value="">선택하세요</option>
  	  <option value="subject">제목</option>
  	  <option value="id">작성자</option>
  	  <option value="content">내용</option>
  	</select>&nbsp;  
  	<script>
  	  if('${param.searchType}' != '')
  	  {
  	      document.getElementById("searchType").value = '${param.searchType}';  
  	  }
  	</script>
  	<input type="text" name="searchContent" value="${param.searchContent}">
  	<input type="submit" value="검색">
  </form>
</td></tr>
</table>
<div id="loc2">
<c:if test="${userid != 'admin' && userid != 'guest'}">
   <tr><td id="loc"><a href="centerAdd.mall">[글쓰기]</a></td></tr>
   <tr><td id="loc"><a href="centerList.mall">[글목록]</a></td></tr>
</c:if>
<c:if test="${userid == 'admin' || userid == 'guest'}">
   <tr><td id="loc"><a href="centerList.mall">[글목록]</a></td></tr>
</c:if>
</div>
</div>    
</body>
</html>