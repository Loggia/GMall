<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#loc
{
  text-align : center;
}
#loc2
{
  text-align : center;
  margin-bottom : 30px;
} 
#loc3 ul li  
{
  text-align : center;
  display : inline-block;  
} 
#loc4
{  
  overflow:hidden; margin-top:-35px; margin-left:120px;
} 
#loc5            
{          
  width : 150px;  
  float : left;    
}   
#arrange      
{         
  width        : 350px;           
  text-overflow: ellipsis;  
  white-space  : nowrap;    
  overflow     : hidden;    
  display      : block;     
}
.line
{
  word-break : break-all;
}
.prodeloc
{
  left:80%; overflow:hidden;  margin-left:230px; 
}   
a
{
  color : black;
}  
</style>          
<script>      
function explain_disp()
{  
	  var disp = document.getElementById('explain');
	  if(disp.style.display == 'block')
    {
		  disp.style.display = 'none';
    }
	  else
    {
		  disp.style.display = 'block';
		  document.getElementById('review').style.display = 'none';
		  document.getElementById('qna').style.display = 'none';
    } 
	   
}

function review_disp()
{
	  var disp = document.getElementById('review');
	  if(disp.style.display == 'block')
     {
		  disp.style.display = 'none';
     }
	  else
     {
		  disp.style.display = 'block';
		  document.getElementById('explain').style.display = 'none';
		  document.getElementById('qna').style.display = 'none';
     }  
}  

function qna_disp()
 {
	  var disp = document.getElementById('qna');
	  if(disp.style.display == 'block')
      {
		  disp.style.display = 'none';
      }
	  else
      {
		  disp.style.display = 'block';
		  document.getElementById('explain').style.display = 'none';
		  document.getElementById('review').style.display = 'none';
      } 
}
  
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
 
function productlist(pageNum) 
{
		var searchType = document.productsearchform.searchType.value;
		if(searchType == null || searchType.length == 0)
		{
			document.productsearchform.searchContent.value = "";
			document.productsearchform.pageNum.value = 1;
			location.href = "productDetail.mall?pro_no=" + ${param.pro_no} + "&pageNum=" + pageNum;
		}
		else
		{
			document.productsearchform.pageNum.value = pageNum;
			document.productsearchform.submit();
			return true;
		}
		return false;
}
</script>
</head>
<body>
<div class="container-fluid" style="padding-left: 0px; padding-right: 0px;">
  <div class="col-xs-2"></div>
    <div class="col-xs-8 info_content">
<div>
<div class="prodeloc"><h2>${proinfo.bis_name}</h2></div>  
<div>  
<c:set var="product" value="${proinfo}" />
<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5; width:850px;" align="center">
  <tr>    
  <td width="300"><img src="../picture/${product.fileurl}" width="250" height="250"></td>
  <td align="center">
    <table>
    <tr><td width="120"><h2>상품명</h2></td>  
        <td width="180"><h2>${product.pro_name}</h2></td>  
    </tr>    
    <tr><td width="100"><h2>가격</h2></td>
        <td width="180"><h2><fmt:formatNumber value="${product.price}" groupingUsed="true"/>원</h2></td>
    </tr>
    <tr><td width="120"><h2>상품내용</h2></td>    
        <td width="180"><h2>&nbsp;&nbsp;${product.pro_content}</h2></td>
    </tr>
    <tr><td colspan="2" align="center">
      <form:form modelAttribute="trade" action="cartAdd.mall" name="tradeForm">
        <input type="hidden" name="pro_no" value="${product.pro_no}">
          <table align="left">
          <tr>
            <td>
              <h2>갯수</h2>
              <select name="quantity">
				<c:forEach begin="1" end="10" var="idx">
					<option>${idx}</option>
				</c:forEach>
			</select>
            </td>
          </tr>
          <tr>
            <td>
              <br><br><br> 
              &nbsp;&nbsp;&nbsp;
              <c:if test="${usertype == 0}">              
                <input id="loc5" type="button" class="btn btn-success" value="목록보기" onclick="location.href='proList.mall?category=${category}'">
              </c:if>
              <c:if test="${usertype == 1}">
                <input id="loc5" type="submit" class="btn btn-success" value="카트에 넣기" onclick="">
                <input id="loc5" type="button" class="btn btn-success" value="목록보기" onclick="location.href='proList.mall?category=${category}'">
                <input id="loc5" type="button" class="btn btn-success" value="즐겨찾기" onclick="">
              </c:if>
              <c:if test="${usertype == 2 && probis.bis_no == proinfo.bis_no}">
                <input id="loc5" type="submit" class="btn btn-success" value="수정하기" onclick="">
                <input id="loc5" type="button" class="btn btn-success" value="목록보기" onclick="location.href='proList.mall?category=${category}'">
              </c:if>
              <c:if test="${usertype == 2 && probis.bis_no != proinfo.bis_no}">
                <input id="loc5" type="button" class="btn btn-success" value="목록보기" onclick="location.href='proList.mall?category=${category}'">
              </c:if>
              <c:if test="${usertype == 3}">               
                <input id="loc5" type="button" class="btn btn-success" value="목록보기" onclick="location.href='proList.mall?category=${category}'">   
              </c:if>
            </td>
          </tr> 
          </table>  
      </form:form>
         </td>
     </tr>
    </table>
  </td> 
  </tr>
</table>        
</div>
<br><br>
<div id="loc3" align="center">      
<ul>
<li><button class="btn btn-warning" onclick="return explain_disp()">상품소개</button></li>
<li><button class="btn btn-warning" onclick="return review_disp()">리뷰</button></li>
<li><button class="btn btn-warning" onclick="return qna_disp()">QnA</button></li>
</ul>
</div> 
<div id="explain" style="display:block;" align="center">
	<c:set var="product" value="${proinfo}" />
	<img src="../picture/${product.fileurl1}" /><br>
	<img src="../picture/${product.fileurl2}" /><br>
	<img src="../picture/${product.fileurl3}" />
</div>
<div id="review" style="display:none; width:100%;">
<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5; width:850px;" align="center"> 
<c:if test="${relistcount > 0}">    
	<tr width="100%"><td colspan="5" align="center"><h1>Review</h1></td></tr> 
	<c:forEach items="${reviewlist}" var="rvlist" varStatus="stat">  
    <tr>             
	  <td width="20%" align="center"><h4><a href="#reviewModal${stat.count}" data-toggle="modal" 
	  style="margin-top: 3px;">제목 : ${rvlist.subject}</a></h4><h4 id="arrange">내용 : ${rvlist.content}</h4></td>
      <td width="20%" align="center"><br>작성자 : ${rvlist.id}<br>등록일 : <fmt:formatDate value="${rvlist.regdate}" pattern="yyyy-MM-dd"/></td>		  
	  <td width="20%" align="center"><br>평점<br>  
	    <c:if test="${rvlist.grade == 2}">   
	      <font color="#EDD200">★</font>   
	    </c:if>      
	    <c:if test="${rvlist.grade == 4}">
	      <font color="#EDD200">★★</font>
	    </c:if>  
	    <c:if test="${rvlist.grade == 6}">
	      <font color="#EDD200">★★★</font>
	    </c:if>
	    <c:if test="${rvlist.grade == 8}">
	      <font color="#EDD200">★★★★</font>
	    </c:if>
	    <c:if test="${rvlist.grade == 10}">
	      <font color="#EDD200">★★★★★</font>
	    </c:if>
	  </td> 
	  <c:if test="${userid != 'admin' && userid != 'guest' && userid == rvlist.id && empty param.pageNum}">
	    <td width="20%" align="center">  
	      <br>  
	      <button class="btn btn-default"><a href="reviewupdateForm.mall?pro_no=${pro_no}&num=${rvlist.board_no}&pageNum=1">수정</a>
	      <button class="btn btn-default"><a href="reviewdeleteForm.mall?pro_no=${pro_no}&num=${rvlist.board_no}&pageNum=1">삭제</a>
	    </td>        
      </c:if>       
	  <c:if test="${userid != 'admin' && userid != 'guest' && userid == rvlist.id && not empty param.pageNum}">
	    <td width="20%" align="center">
	      <br>  
	      <button class="btn btn-default"><a href="reviewupdateForm.mall?pro_no=${pro_no}&num=${rvlist.board_no}&pageNum=${param.pageNum}">수정</a>
	      <button class="btn btn-default"><a href="reviewdeleteForm.mall?pro_no=${pro_no}&num=${rvlist.board_no}&pageNum=${param.pageNum}">삭제</a>
	    </td>  
      </c:if>
	  <c:if test="${userid == 'admin' && userid != 'guest' && empty param.pageNum}">
	    <td width="20%" align="center">  
	      <button class="btn btn-default"><a href="reviewupdateForm.mall?pro_no=${pro_no}&num=${rvlist.board_no}&pageNum=1">수정</a>
	    </td>
	  </c:if>
	  <c:if test="${userid == 'admin' && userid != 'guest' && not empty param.pageNum}">
	    <td width="20%" align="center">
	      <button class="btn btn-default"><a href="reviewdeleteForm.mall?pro_no=${pro_no}&num=${rvlist.board_no}&pageNum=${param.pageNum}">삭제</a>
        </td>  
      </c:if>
      <c:if test="${userid != 'admin' && userid != 'guest' && userid != rvlist.id && empty param.pageNum}">
	    <td width="20%" align="center"></td>
      </c:if>
      <c:if test="${userid != 'admin' && userid != 'guest' && userid != rvlist.id && not empty param.pageNum}">
	    <td width="20%" align="center"></td>
      </c:if>
	</tr>
    <div class="modal fade" id="reviewModal${stat.count}" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
		    <h2 class="modal-title">Review 상세보기</h2>
          </div>
	      <div class="modal-body">
	        <div class="form-group line">
	          <h4>제목 : ${rvlist.subject}</h4>
	          <h4>내용: ${rvlist.content}</h4>
	        </div>
	      </div>
	      <div class="modal-footer">
		    <input type="button" class="btn btn-default" value="닫기" data-dismiss="modal">
		  </div>
        </div>
      </div>
    </div>     
	</c:forEach>
	<tr align="center" height="26">
      <td colspan="5">
        <c:if test="${pageNum > 1}">
           <a href="javascript:productlist(${pageNum - 1})">
        </c:if>[이전]&nbsp;
        <c:if test="${pageNum > 1}"></a></c:if>
        <c:forEach var="a" begin="${startpage2}" end="${endpage2}">
  	       <c:if test="${pageNum == a}">[${a}]</c:if>
  	       <c:if test="${pageNum != a}"><a href="javascript:productlist(${a})">[${a}]</a></c:if>&nbsp;  	 
        </c:forEach>
        <c:if test="${pageNum < maxpage2}">
           <a href="javascript:productlist(${pageNum + 1})">
        </c:if>[다음]&nbsp;
        <c:if test="${pageNum < maxpage2}"></a></c:if>
     </td>
   </tr>    
</c:if>
<c:if test="${relistcount ==0}">
  <tr><td colspan="5">등록된 리뷰가 없습니다.</td></tr>
</c:if>	
</table>
<div id="loc2">
<c:if test="${userid != 'admin' && userid != 'guest' && codeequal == 1}">
   <div id="loc"><button type="button" class="btn btn-info" onclick="location.href='reviewAdd.mall?pro_no=${param.pro_no}'">리뷰 남기기</button></div>
</c:if>
</div>
</div>
<div id="qna" style="display:none; width:100%;">
<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5; width:850px;" align="center">
<c:if test="${listcount > 0}">
	<tr width="100%">
	  <td colspan="5" align="center"><h1>Q&A</h1></td></tr>
	  <tr><td width="20%" align="center">글번호</td><td width="20%" align="center">답변상태</td>
	      <td width="20%" align="center">제목</td><td width="20%" align="center">작성자</td>
	      <td width="20%" align="center">날짜</td></tr>
	  <c:forEach items="${qnalist}" var="qalist" varStatus="stat">
	    <tr>
          <td align="center">${stat.count}</td>
          <td align="center">
          <c:if test="${(qalist.ans_chk == 0) && userid != 'admin' && userid == qalist.id && empty param.pageNum}"> 
            <a href="qnaupdateForm.mall?pro_no=${param.pro_no}&num=${qalist.board_no}&pageNum=1">[수정]</a>
          </c:if>
          <c:if test="${(qalist.ans_chk == 0) && userid != 'admin' && userid == qalist.id && not empty param.pageNum}"> 
            <a href="qnaupdateForm.mall?pro_no=${param.pro_no}&num=${qalist.board_no}&pageNum=${param.pageNum}">[수정]</a>
          </c:if>
          <c:if test="${(qalist.ans_chk == 0) && userid != 'admin' && userid != qalist.id}"> 
            <font color="red">미답변</font>
          </c:if>
          <c:if test="${(qalist.ans_chk == 0) && userid == 'admin'&& empty param.pageNum}"> 
            <a href="qnaanswerForm.mall?pro_no=${param.pro_no}&num=${qalist.board_no}&pageNum=1">[답변]</a>
          </c:if>
          <c:if test="${(qalist.ans_chk == 0) && userid == 'admin'&& not empty param.pageNum}"> 
            <a href="qnaanswerForm.mall?pro_no=${param.pro_no}&num=${qalist.board_no}&pageNum=${param.pageNum}">[답변]</a>
          </c:if>
          <c:if test="${qalist.ans_chk == 1}"> 
             &nbsp;<img src="../img/check.png" width="30" height="30">
          </c:if> 
          </td>
          <c:if test="${not empty qalist.pass}">
          <td align="center"><a href="javascript:list_disp('listLine${stat.count}')">${qalist.subject}</a><img src="../img/rock.jpg" width="20" height="20" /></td>
          </c:if>
          <c:if test="${empty qalist.pass}">
          <td align="center"><a href="javascript:list_disp('listLine${stat.count}')">${qalist.subject}</a></td>
          </c:if>
	      <td align="center">${qalist.id}</td>
	      <td align="center"><f:formatDate value="${qalist.regdate}" pattern="yyyy-MM-dd"/></td>
	     </tr>
	     <tr>
	       <td colspan="5">
	        <div id="listLine${stat.count}" style="display:none;">
	        <c:if test="${not empty qalist.pass && empty param.searchType && empty param.searchContent && empty param.num && empty param.password}"> 
	          <form action="productDetail.mall" method="get" name="onpass" id="loc">
	                       비밀번호 : 	                       
	          	<input type="hidden" name="pro_no" value="${param.pro_no}">
	          	<input type="hidden" name="pageNum" value="${param.pageNum}">
	          	<input type="hidden" name="num" value="${qalist.board_no}">
                <input type="text" name="password">
                <input type="submit" class="btn btn-default" value="확인">
              </form>
            </c:if>
            <c:if test="${not empty qalist.pass && not empty param.pageNum &&not empty param.searchType && not empty param.searchContent && empty password}"> 
	          <form action="productDetail.mall" method="get" name="onpass2" id="loc">
	                       비밀번호 : 	  
	            <input type="hidden" name="pro_no" value="${param.pro_no}">   
	            <input type="hidden" name="pageNum" value="${param.pageNum}">  
	            <input type="hidden" name="searchType" value="${param.searchType}">  
	            <input type="hidden" name="searchContent" value="${param.searchContent}">  	                          
	          	<input type="hidden" name="num" value="${qalist.board_no}">
                <input type="text" name="password">
                <input type="submit" class="btn btn-default" value="확인">
              </form>
            </c:if>	     
            <c:if test="${not empty password && not empty num}"> 
             <c:if test="${(qalist.pass == password) && (qalist.board_no == num)}">
            	<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;" align="center">
	           <tr>
	          	 <td align="center"><h3>내용 : ${qalist.content}</h3></td>
               </tr> 
               <tr>  
                  <td align="center">첨부파일 → 
                    <c:if test="${empty qalist.fileurl || qalist.fileurl2 || qalist.fileurl3}"> 
                       <font color="gray">첨부파일 없음</font>
                    </c:if>
                    <c:if test="${not empty qalist.fileurl}"> 
                       <a href="filedown.mall?filename=${qalist.fileurl}">${qalist.fileurl}</a>
                    </c:if>
                    <c:if test="${not empty qalist.fileurl2}"> 
                       <a href="filedown.mall?filename=${qalist.fileurl2}">${qalist.fileurl2}</a>
                    </c:if>
                    <c:if test="${not empty qalist.fileurl3}"> 
                       <a href="filedown.mall?filename=${qalist.fileurl3}">${qalist.fileurl3}</a>
                    </c:if>
                 </td> 
               </tr> 
             </table>
	         </c:if>
	         <c:if test="${((qalist.pass != password) || (qalist.board_no != num)) && empty param.searchType && not empty qalist.pass}">
	          <form action="productDetail.mall" method="get" name="onpass4" id="loc">
	                       비밀번호 : 
	            <input type="hidden" name="pro_no" value="${param.pro_no}">
	            <input type="hidden" name="pageNum" value="${param.pageNum}">
	          	<input type="hidden" name="num" value="${qalist.board_no}">
                <input type="text" name="password">
                <input type="submit" class="btn btn-default" value="확인">
              </form>
	         </c:if> 
	         <c:if test="${(qalist.pass != password && not empty qalist.pass) && (not empty param.pageNum && not empty param.searchType && not empty param.searchContent && not empty param.num && not empty param.password)}">
	         	<form action="productDetail.mall" method="get" name="onpass5" id="loc">
	                       비밀번호 : 
	            <input type="hidden" name="pro_no" value="${param.pro_no}">
	            <input type="hidden" name="pageNum" value="${param.pageNum}">  
	            <input type="hidden" name="searchType" value="${param.searchType}">  
	            <input type="hidden" name="searchContent" value="${param.searchContent}">           
	          	<input type="hidden" name="num" value="${qalist.board_no}">
                <input type="text" name="password">
                <input type="submit" class="btn btn-default" value="확인">
              </form>
	         </c:if>
	        </c:if> 
	        <c:if test="${empty qalist.pass}"> 
	          <table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;" align="center">
	           <tr>
	          	 <td align="center"><h3>내용 : ${qalist.content}</h3></td>
               </tr> 
               <tr>  
                  <td align="center">첨부파일 → 
                    <c:if test="${empty qalist.fileurl || qalist.fileurl2 || qalist.fileurl3}"> 
                       <font color="gray">첨부파일 없음</font>
                    </c:if>
                    <c:if test="${not empty qalist.fileurl}"> 
                       <a href="filedown.mall?filename=${qalist.fileurl}">${qalist.fileurl}</a>
                    </c:if>
                    <c:if test="${not empty qalist.fileurl2}"> 
                       <a href="filedown.mall?filename=${qalist.fileurl2}">${qalist.fileurl2}</a>
                    </c:if>
                    <c:if test="${not empty qalist.fileurl3}"> 
                       <a href="filedown.mall?filename=${qalist.fileurl3}">${qalist.fileurl3}</a>
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
           <a href="javascript:productlist(${pageNum - 1})">
        </c:if>[이전]&nbsp;
        <c:if test="${pageNum > 1}"></a></c:if>
        <c:forEach var="a" begin="${startpage}" end="${endpage}">
  	       <c:if test="${pageNum == a}">[${a}]</c:if>
  	       <c:if test="${pageNum != a}"><a href="javascript:productlist(${a})">[${a}]</a></c:if>&nbsp;  	 
        </c:forEach>
        <c:if test="${pageNum < maxpage}">
           <a href="javascript:productlist(${pageNum + 1})">
        </c:if>[다음]&nbsp;
        <c:if test="${pageNum < maxpage}"></a></c:if>
  </td>
</tr>         		
</c:if>
<c:if test="${listcount ==0}">
  <tr><td colspan="5" align="center">등록된 Q&A가 없습니다.</td></tr>
</c:if>
<tr><td colspan="5" align="center">
  <form action="productDetail.mall" method="get" name="productsearchform" onsubmit="return productlist(1)">
  	<input type="hidden" name="pro_no" value="${param.pro_no}">
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
  	<input type="submit" class="btn btn-default" value="검색">
  </form>
</td></tr>
</table>  
<div id="loc2">
<c:if test="${userid != 'admin' && userid != 'guest'}">
   <tr>
     <td id="loc">
       <button class="btn btn-default"><a href="qnaAdd.mall?pro_no=${param.pro_no}">글쓰기</a></button>
     </td>
   </tr>
   <tr>
     <td id="loc">
       <button class="btn btn-default"><a href="productDetail.mall?pro_no=${param.pro_no}">글목록</a></button>
     </td>
   </tr>
</c:if>
<c:if test="${userid == 'admin' || userid == 'guest'}">
   <tr>
     <td id="loc">
       <button class="btn btn-default"><a href="productDetail.mall?pro_no=${param.pro_no}">글목록</a></button>
     </td>
   </tr>
</c:if>
</div>
</div>
</div>
  </div>
  <div class="col-xs-2"></div>
</div>
</body>
</html>