<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 리스트</title>
<style type="text/css">
a
{
  color : black;
}
</style> 
<script>
function prolist(pageNum) 
{
  location.href = "proList.mall?category=${param.category}&group=${param.group}&pageNum=" + pageNum;
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
                <tr align="center">    
                  <td><button class="btn btn-default"><a href="proList.mall?category=${param.category}&group=premium">프리미엄순</a></button></td>
                  <td><button class="btn btn-default"><a href="proList.mall?category=${param.category}&group=high">높은 가격순</a></button></td>
                  <td><button class="btn btn-default"><a href="proList.mall?category=${param.category}&group=low">낮은 가격순</a></button></td>                
                </tr>
            <c:if test="${listcount > 0}">  
                <tr class="proloc" align="center">
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
                <c:forEach items="${productlist}" var="product">
                    <tr>
                        <td align="center">
                        <a href="productDetail.mall?pro_no=${product.pro_no}&category=${product.category}"><img src='../picture/${product.fileurl}' width='70' height='70' /></a>
                        </td>
                        <td align="center"><a href="productDetail.mall?pro_no=${product.pro_no}&category=${product.category}">${product.pro_name}</a></td>
                        <td align="center">${product.price}</td>
                        <td align="center">
                          ${product.averfavorprice}원<br>
                          <c:if test="${product.price > product.averfavorprice}">
                            <font color="red">(+${product.price - product.averfavorprice}원)</font>
                          </c:if>
                          <c:if test="${product.price < product.averfavorprice}">
                            <font color="blue">(-${product.averfavorprice - product.price}원)</font>
                          </c:if>
                          <c:if test="${product.price == product.averfavorprice}">
                            (${product.price - product.averfavorprice}원)
                          </c:if>
                        </td>                          
                        <td align="center"><fmt:formatDate value="${product.date}" pattern="yyyy-MM-dd"/></td>                        
                        <td align="center">${product.bis_name}</td> 
                        <c:if test="${product.prim == 1}"> 
                          <td align="center"><img src='../img/prim.png' width='50' height='50' /></td>
                        </c:if>
                        <c:if test="${product.prim == 0}">
                          <td align="center">일반 사업자</td>
                        </c:if> 
                    </tr>
                </c:forEach>
                <tr align="center" height="26">  
                  <td colspan="5">
                    <c:if test="${pageNum > 1}">
                      <a href="javascript:prolist(${pageNum - 1})">
                    </c:if>[이전]&nbsp;
                    <c:if test="${pageNum > 1}"></a></c:if>
                    <c:forEach var="a" begin="${startpage}" end="${endpage}">
  	                    <c:if test="${pageNum == a}">[${a}]</c:if>
  	                    <c:if test="${pageNum != a}"><a href="javascript:prolist(${a})">[${a}]</a></c:if>&nbsp;  	 
                    </c:forEach>
                    <c:if test="${pageNum < maxpage}">
                      <a href="javascript:prolist(${pageNum + 1})">
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