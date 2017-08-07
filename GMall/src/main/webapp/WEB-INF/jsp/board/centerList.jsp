<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">
$(document).ready(function(){
	
	    $(".list_1st a").mouseover(function(){
	        $(".list_1st a").css("color", "#12d8fa");
	    });
	    $(".list_1st a").mouseout(function(){
	        $(".list_1st a").css("color", "black");
	    });
	    $(".list_2nd a").mouseover(function(){
	        $(".list_2nd a").css("color", "#12d8fa");
	    });
	    $(".list_2nd a").mouseout(function(){
	        $(".list_2nd a").css("color", "black");
	    });
	
	
});
</script>
<link rel="stylesheet" type="text/css" href="${path }/css/delvpage.css">
<!-- <style type="text/css">
body {
	background-color: #f4f4f4;
}

.container-fluid {
	padding-top: 0 !important;
}

.info_content {
	border: 1px solid #e5e5e5;
	height: 1500px;
	margin: 30px auto 30px auto;
	padding: 0px;
	background: #fff;
	font-family: '나눔고딕', NanumGothic, '맑은고딕', MalgunGothic, '돋움', Dotum,
		Helvetica, sans-serif;
}

.my_left {
	position: absolute;
	width: 250px;
	height: 1500px;
}

.my_right {
	position: relative;
	width: 1157.61px;
	padding: 0px 40px 120px 40px;
	height: 1500px;
	margin-left: 250px;
	border-left: 1px solid #e5e5e5;
}

.left_prof {
	width: 250px;
	height: 240px;
	background-color: #bbbfc3;
	border-bottom: 1px solid #e5e5e5;
}

.left_list {
	width: 250px;
	height: 800px;
	padding-top: 40px;
	padding-left: 40px;
	padding-right: 40px;
	padding-bottom: 20px;
	text-align: left;
}
.left_list ul {
	text-align: left;
	padding: 0px;
	margin: 0px;
	font-size: 20px;
}
.list_1st{
	border-bottom: 1px solid #e5e5e5;
	margin-top: 20px;
	margin-bottom: 20px;
	padding-bottom: 20px;
}
.list_2nd{
	border-bottom: 1px solid #e5e5e5;
	margin-top: 20px;
	margin-bottom: 20px;
	padding-bottom: 20px;
}
.list_3th{
	margin-top: 20px;
	margin-bottom: 20px;
}

.list_1st a{
	text-decoration: none;
	color: black;
}
.list_2nd a{
	text-decoration: none;
	color: black;
}
.list_3th a{
	text-decoration: none;
	color: #12d8fa;
}

.right_menu {
	position: relative;
	width: 100%;
	height: 240px;
	padding: 35px 0px 35px 0px;
	border-bottom: 1px solid #e5e5e5;
}

.right_menu ul {
	list-style: none;
}

.menu_delv {
	text-align: center;
	float: left;
	border-right: 1px solid #e5e5e5;
	padding-top: 40px;
	padding-bottom: 45px;
	padding-left: 50px;
	padding-right: 100px;
}

.menu_coup {
	text-align: center;
	float: left;
	border-right: 1px solid #e5e5e5;
	padding-top: 40px;
	padding-bottom: 45px;
	padding-left: 110px;
	padding-right: 110px;
}

.menu_money {
	text-align: center;
	float: left;
	border-right: 1px solid #e5e5e5;
	padding-top: 40px;
	padding-bottom: 45px;
	padding-left: 110px;
	padding-right: 110px;
}

.menu_talk {
	text-align: center;
	float: left;
	padding-top: 40px;
	padding-bottom: 45px;
	padding-left: 110px;
}

.right_cont {
	
}

.home_group {
	margin-top :20px;
	border-top: 1px solid #e5e5e5;
}
.bus_list {
	margin-top: 20px;
	border-bottom: 1px solid #e5e5e5;
}
.bus_cont {
	margin-top: 20px;
	margin-bottom: 20px;
}
</style>

<style type="text/css">
#loc
{
  text-align : center;
}
#loc2
{
  text-align : right;
}
</style> -->
<script>
 function list_disp(id)
  {
	  var disp = document.getElementById(id);

	  if(disp.className == 'hide')
      {
		  disp.className = "";
      }
	  else
      {
		  disp.className = "hide";
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
	<div class="container-fluid"
		style="padding-left: 0px; padding-right: 0px;">

		<div class="col-xs-2"></div>

		<div class="col-xs-8 info_content">
			<div class="my_left">
				<div class="left_prof">
					<div style="text-align: center;"><img style="margin-top: 30px;" src="../img/sanaprof.PNG" class="img-circle" width="150px" height="150px"></div>
					<a href="${path }/member/infoForm.mall"><img style="position: absolute; margin-left: 150px; margin-top: 18px;" src="../img/option.png"></a>
					<br>
					<div style="text-align: center;">${member.name }</div>
				</div>
				<div class="left_list">
					<ul>
						<c:if test="${member.type == 1 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">관심 사업장</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">구매 목록</a></li>
						<li class="list_3th"><a class="on" href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 2 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">내사업장</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">판매 목록</a></li>
						<li class="list_3th"><a class="on" href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.type == 3 }">
						<li class="list_1st"><a href="${path }/member/mypage.mall">사이트 관리</a></li>
						<li class="list_2nd"><a href="${path }/trade/BSList.mall">회원 거래 목록</a></li>
						<li class="list_3th"><a class="on" href="${path }/board/centerList.mall">고객 센터</a></li>
						</c:if>
						<c:if test="${member.id == sana }">
						<li class="list_1st"><a href="mypage.mall">찌릿찌릿</a></li>
						<li class="list_2nd"><a href="">샤샤샤</a></li>
						<li class="list_3th"><a class="on" href="">낙낙!</a></li>
						</c:if>
					</ul>
				</div>
			</div>
			<div class="right_menu pull-right" style="width: calc(100% - 250px); background-color: #f7f8f8; z-index: 20px;" >
					<ul style="width: 100%; display: block; padding: 0;">
						<c:if test="${member.type == 1 }">
							<li class="menu_delv"><a href="${path }/trade/delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>배송 정보</a></li>
							<li class="menu_delv"><a href="${path }/trade/couppage.mall"><img
									src="../img/coupon_color.png"><br>보유 쿠폰</a></li>
							<li class="menu_delv"><a href="${path }/member/moneypage.mall"><img
									src="../img/money_color.png"><br>보유 금액</a></li>
							<li class="menu_delv"><a href="${path }/member/talkpage.mall"><img
									src="../img/talk_color.png"><br>구디 톡톡!</a></li>
						</c:if>
						<c:if test="${member.type == 2 }">
							<li class="menu_delv"><a href="${path }/trade/delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>배송 관리</a></li>
							<li class="menu_delv"><a href="${path }/trade/couppage.mall"><img
									src="../img/coupon_color.png"><br>쿠폰관리</a></li>
							<li class="menu_delv"><a href="${path }/member/moneypage.mall"><img
									src="../img/money_color.png"><br>보유 금액</a></li>
							<li class="menu_delv"><a href="${path }/member/talkpage.mall"><img
									src="../img/talk_color.png"><br>구디 톡톡!</a></li>
						</c:if>
						<c:if test="${member.type == 3 }">
							<li class="menu_delv"><a href="${path }/member/nomalList.mall"><img
									src="../img/nomal_1.png" width="64px" height="64px"><br>일반회원 관리</a></li>
							<li class="menu_delv"><a href="${path }/member/businessList.mall"><img
									src="../img/busi_1.png"><br>사업자회원 관리</a></li>
							<li class="menu_delv"><a href="${path }/member/moneypage.mall"><img
									src="../img/money_color.png"><br>보유 금액</a></li>
							<li class="menu_delv"><a href="${path }/member/talkpage.mall"><img
									src="../img/talk_color.png"><br>구디 톡톡!</a></li>
						</c:if>
						<c:if test="${member.id==sana }"> 
							<li class="menu_delv"><a href="delvpage.mall"><img
									src="../img/truck2_color.png" width="64px" height="64px"><br>사나</a></li>
							<li class="menu_delv"><a href="couppage.mall"><img
									src="../img/coupon_color.png"><br>샤샤샤</a></li>
							<li class="menu_delv"><a href="moneypage.mall"><img
									src="../img/money_color.png"><br>낙낙!</a></li>
							<li class="menu_delv"><a href="talkpage.mall"><img
									src="../img/talk_color.png"><br>오효오효쨩</a></li>
						</c:if>
					</ul>
				</div>
			<div class="my_right" style="width: calc(100% - 250px);">
				<div class="left_cont">
					<br><br>
					<h3>
						<strong>고객 센터</strong>
					</h3>
					<!-- 수정 하시면 됩니다 -->
					<table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;">
						<thead>
							<tr>
								<th>NO</th><th>답변상태</th><th>제목</th><th>작성자</th><th>작성일자</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${listcount > 0}">
								<c:forEach items="${centerlist}" var="clist" varStatus="stat">
									<tr onclick="javascript:list_disp('listLine${stat.count}')">
									  <td align="left">${clist.board_no}</td>
							          <td align="left">
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
							             <font color="blue">&nbsp;&nbsp;√</font>
							          </c:if> 
							          </td>
							          <c:if test="${not empty clist.pass}">
							          <td align="left">${clist.subject}<img src="../img/rock.jpg" width="20" height="20" /></td>
							          </c:if>
							          <c:if test="${empty clist.pass}">
							          <td align="left">${clist.subject}</td>
							          </c:if>
								      <td align="left">${clist.id}</td>
								      <td align="left"><f:formatDate value="${clist.regdate}" pattern="yyyy-MM-dd"/></td>
									</tr>
									<tr id="listLine${stat.count}" class="hide">
								      <td colspan="5">
								       <div>
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
							<!--  <tr align="center" height="26">
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
							</td></tr>  -->
							</tbody>
						</table>
						<div align="center">
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
						</div><br>
						
						<div align="center">
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
						</div>
					<br><br>
					<c:if test="${userid != 'admin' && userid != 'guest'}">
					   <tr><td id="loc"><button type="button" class="btn btn-info" onclick="location.href='centerAdd.mall'">글쓰기</button></td></tr>
					   <tr><td id="loc"><button type="button" class="btn btn-info" onclick="location.href='centerList.mall'">글목록</button></td></tr>
					</c:if>
					<c:if test="${userid == 'admin' || userid == 'guest'}">
					   <tr><td id="loc"><button type="button" class="btn btn-info" onclick="location.href='centerList.mall'">글목록</button></td></tr>
					</c:if>
				</div>
			</div>
		</div>
		<div class="col-xs-2"></div>
	</div>
</body>
</html>