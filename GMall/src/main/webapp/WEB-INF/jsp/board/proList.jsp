<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 리스트</title>
<script>
function prolist(pageNum) 
{
  location.href = "proList.mall?category=${param.category}&group=${param.group}&pageNum=" + pageNum;
}
</script>
</head>

<body>
<div class="row">
        <div class="col-xs-12">
          <div class="box">
            <!-- /.box-header -->
            <div class="box-body table-responsive no-padding">
              <table class="table table-hover">
                <tbody>
                <tr>
                  <td><a href="proList.mall?category=${param.category}&group=premium">프리미엄순</a></td>
                  <td><a href="proList.mall?category=${param.category}&group=high">높은 가격순</a></td>
                  <td><a href="proList.mall?category=${param.category}&group=low">낮은 가격순</a></td>                
                </tr>
            <c:if test="${listcount > 0}">
                <tr class="scrollLocation">
                  <th>상품이미지</th>
                  <th>상품명</th>
                  <th>가격</th>
                  <th>등록일</th>
                  <th>사업자명</th>  
                  <th>프리미엄</th>                      
                </tr>
                
                
                <c:forEach items="${productlist}" var="product">
                    <tr class="listToChange">
                        <td class="scrolling">
                        <a href="productDetail.mall?pro_no=${product.pro_no}&category=${product.category}"><img src='../picture/${product.fileurl}' width='70' height='70' /></a>
                        </td>
                        <td><a href="productDetail.mall?pro_no=${product.pro_no}&category=${product.category}">${product.pro_name}</a></td>
                        <td>${product.price}</td>
                        <td><fmt:formatDate value="${product.date}" pattern="yyyy-MM-dd"/></td>                        
                        <td>${product.bis_name}</td> 
                        <c:if test="${product.prim == 1}"> 
                          <td><img src='../img/prim.png' width='50' height='50' /></td>
                        </c:if>
                        <c:if test="${product.prim == 0}">
                          <td>일반 사업자</td>
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
</body>
</html>