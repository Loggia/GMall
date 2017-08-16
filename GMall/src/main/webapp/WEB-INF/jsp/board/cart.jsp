<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Insert title here</title>
   
      <link rel="stylesheet" type="text/css" href="${path }/css/delvpage.css"> 
      <style type="text/css">
      
      .float {
          float: right;
      }
      
      .circle1 {
          width:100px;
          height:100px;
          border-radius:100px;
          -moz-border-radius : 100px;
          -webkit-border-radius : 100px;
          -ms-border-radius :100px;
          -khtml-border-radius : 100px;
          -o-border-radius :100px;
          background:#09F;
          font:normal 12px/100px "나눔고딕", "돋움", "굴림";
          color:#fff;
          text-align:center;
          display: inline-block;
         }
      .circle2 {
          width:100px;
          height:100px;
          border-radius:100px;
          -moz-border-radius : 100px;
          -webkit-border-radius : 100px;
          -ms-border-radius :100px;
          -khtml-border-radius : 100px;
          -o-border-radius :100px;
          background:#2b68a7;
          font:normal 12px/100px "나눔고딕", "돋움", "굴림";
          color:#fff;
          text-align:center;
          display: inline-block;
         }
      font {
      font-family : Times New Roman;
      font-weight: bold;
      }
      
      .box {
         width: 100%;
         height: 140px;
         border-radius: 5px;
         background:#dddee0;
         border-bottom: 5px black;
      }
      
      
      /* 맨위  */
      
      .path {
    overflow: hidden;
    height: 40px;
    font-family: "나눔고딕",'Nanum Gothic',sans-serif;
    font-size: 11px;
   }
   li {
    list-style: none;
}
   .path li {
    float: left;
    padding: 0 0 0 12px;
    margin: 0 0 0 8px;
    color: #757575;
    }
   ol {
    display: block;
    list-style-type: decimal;
    -webkit-margin-before: 1em;
    -webkit-margin-after: 1em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
    -webkit-padding-start: 40px;
   } 
   .path ol {
    float: right;
}




.orderListArea .title{
    height: 38px;
    margin: 20px 0 0;
    padding: 0 0 0 9px;
    border: 1px solid #d7d5d5;
    border-bottom: 0;
    line-height: 38px;
    background: #f6f6f6;
     font-family: "나눔고딕",'Nanum Gothic',sans-serif;
}

   table {
    width: 100%;
    border: 0;
    border-spacing: 0;
    border-collapse: collapse;
}
   .boardList {
    table-layout: fixed;
    margin: 0 0 1px;
    border: 1px solid #d7d5d5;
    color: #353535;
    line-height: 1.5;
}
   .boardList .mutual {
      width: 92px
   }
   .boardList .thumb{
       width: 150px;
   }
   .boardList .product {
      width: auto;
   }
   .boardList .price {
      width: 100px
   }
   .boardList .quantity {
      width: 92px
   }
   .boardList .total{
      width: 92px
   }
   .boardList .delete{
      width: 92px
   }
   .boardList th {
    padding: 11px 0 9px;
    border-left: 1px solid #e9e9e9;
    font-weight: normal;
    background: #fbfafa;
}
   th, td {
    border: 0;
    vertical-align: top;
}

   tr {
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
}
   tfoot tr td {
   padding: 11px 0 9px;
    border-left: 1px solid #e9e9e9;
    font-weight: normal;
    background: #fbfafa;
   }


      </style>
   </head>

      <body>
      <div class="container-fluid" style="padding-left: 0px; padding-right: 0px;">
      
      <div class="col-xs-2"></div>

      <div class="col-xs-8 info_content">

         <div class="path">
            <ol>
               <li><a>홈</a></li>
               <li title="현재위치"><strong>▶ 장바구니</strong></li>
            </ol>
         </div>
            <hr>

         <div class="float">
      <br>
   <p class="circle1"><img src="../img/baguni.png" width="64px" height="64px"></p> <font >BASKET</font>
      <img src="../img/arrow.png" width="30px" height="30px;">
   <P class="circle2"><img src="../img/daller.png" width="64px" height="64px"></p> <font >PAYMENT</font>
   <img src="../img/arrow.png" width="30px" height="30px;">
   <P class="circle2"><img src="../img/order.png" width="64px" height="64px"></p> <font >COMPLETE</font>
      <br>
      </div>
      <p class="box"><br><br><br><font size="10px">장바구니</font></p>
         <br><br><br>
         
         
      <div class="orderListArea">
      <div class="title">
         일반상품(${cartsize})
      </div>
      <table class="boardList" >
         <thead>
         <tr>
            <th class="mutual">상호</th>
            <th class="thumb">상품이미지</th>
            <th class="product">상품명</th>
            <th class="price">가격</th>
            <th class="quantity">수량</th>
            <th class="total">총액</th>
            <th class="delete">삭제하기</th>
         </tr>
         </thead>
         
         
         
         <c:set value="${0}" var="tot"/>
         <c:forEach items="${cart.productList}" var="productSet" varStatus="stat">
            <tr>
               <td>${productSet.product.bis_name }</td>
            
                 <td><img src="../picture/${productSet.product.fileurl}" style="width: 100px; height: 100px;"/></td> 
               <td>${productSet.product.pro_name}</td>
               <td>${productSet.product.price}</td>
               <td align="right">${productSet.quantity}</td>
               <td align="right"><font>${productSet.quantity * productSet.product.price} 원</font>
               </td>
               <td><a href="cartDelete.mall?index=${stat.index}">
               <img src="http://img.echosting.cafe24.com/skin/base_ko_KR/order/btn_delete2.gif"></a>
               </td>
               <c:set var="tot" value="${tot+(productSet.quantity * productSet.product.price)}"/>
            </tr>
         </c:forEach>
         
   
         <tfoot>
            <tr>
               <td>[일반상품]</td>
               <td colspan="6" align="right">
                  총구입금액:${tot}원
               </td>
            </tr>
         </tfoot>
      </table>
         <div class="float">
       <input id="loc5" type="button" class="btn btn-success" value="목록보기" onclick="location.href='proList.mall?category=${category}'">
      <input id="loc5" type="button" class="btn btn-success" value="구매하기" onclick="location.href='../board/checkout.mall'">
         </div>
      </div>
      </div>
         <div class="col-xs-2"></div>
         </div>
         
   </body>
</html>