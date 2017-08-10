<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 리스트</title>
<script>
function totallist(pageNum) 
{
  location.href = "totalList.mall?&pageNum=" + pageNum;
}
</script>
</head>

<body>
<div class="container-fluid" style="padding-left: 0px; padding-right: 0px;">
  <div class="col-xs-2"></div>
    <div class="col-xs-8 info_content">
      <div class="row">
        <div class="col-xs-12">
          <div class="box">
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover" style="border-bottom: 1px solid #e5e5e5;" align="center">
                <tbody>            
            <c:if test="${listcount > 0}">
                <tr align="center">  
                  <th align="center">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;상품이미지</th>  
                  <th align="center">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;상품명</th>    
                  <th align="center">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp; 
                                     가격</th>
                  <th align="center">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                     평균가</th>
                  <th align="center">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                     등록일</th>   
                  <th align="center">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사업자명</th>      
                  <th align="center">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        
                                     프리미엄</th>                       
                </tr>               
                <c:forEach items="${totallist}" var="total">
                    <tr>
                        <td align="center">
                        <a href="productDetail.mall?pro_no=${total.pro_no}&category=${total.category}"><img src='../picture/${product.fileurl}' width='70' height='70' /></a>
                        </td>
                        <td align="center"><a href="productDetail.mall?pro_no=${total.pro_no}&category=${total.category}">${total.pro_name}</a></td>
                        <td align="center">${total.price}</td>
                        <td align="center">
                          ${total.averfavorprice}원<br>
                          <c:if test="${total.price > total.averfavorprice}">
                            <font color="red">(+${total.price - total.averfavorprice}원)</font>
                          </c:if>
                          <c:if test="${total.price < total.averfavorprice}">
                            <font color="blue">(-${total.averfavorprice - total.price}원)</font>
                          </c:if>
                          <c:if test="${total.price == total.averfavorprice}">
                            (${total.price - total.averfavorprice}원)
                          </c:if>
                        </td>
                        <td align="center"><fmt:formatDate value="${total.date}" pattern="yyyy-MM-dd"/></td>                        
                        <td align="center">${total.bis_name}</td> 
                        <c:if test="${total.prim == 1}"> 
                          <td align="center"><img src='../img/prim.png' width='50' height='50' /></td>
                        </c:if>
                        <c:if test="${total.prim == 0}">
                          <td align="center">일반 사업자</td>
                        </c:if>   
                    </tr>
                </c:forEach>
                <tr align="center" height="26">
                  <td align="center" colspan="5">
                    <c:if test="${pageNum > 1}">
                      <a href="javascript:totallist(${pageNum - 1})">
                    </c:if>[이전]&nbsp;
                    <c:if test="${pageNum > 1}"></a></c:if>
                    <c:forEach var="a" begin="${startpage}" end="${endpage}">
  	                    <c:if test="${pageNum == a}">[${a}]</c:if>
  	                    <c:if test="${pageNum != a}"><a href="javascript:totallist(${a})">[${a}]</a></c:if>&nbsp;  	 
                    </c:forEach>
                    <c:if test="${pageNum < maxpage}">
                      <a href="javascript:totallist(${pageNum + 1})">
                    </c:if>[다음]&nbsp;
                    <c:if test="${pageNum < maxpage}"></a></c:if>
                  </td>
                </tr>     
            </c:if>
            <c:if test="${listcount ==0}">
              <tr><td colspan="5">등록된 상품이 없습니다.</td></tr>
            </c:if>  
              </tbody>
            </table>
          </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
  </div>
 </div> 
 <div class="col-xs-2"></div>
</div>
</body>
</html>