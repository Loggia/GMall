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
      h2 {
         font-family : '돋움';
         font-weight: bold;
      }
      
      
      
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

   .boardList .name {
      width: 140px;
   }
   .boardList .tel {
      width: 140px;
   }
   .boardList .address {
      width: 200px;
   }
   .boardList .address2{
      width: auto;
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
   input {
      width: 100%
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
               <li title="현재위치"><strong>▶ 주문/판매</strong></li>
            </ol>
         </div>
            <hr>
            
      <div class="float">
      <br>
   <p class="circle2"><img src="../img/baguni.png" width="64px" height="64px"></p> <font >BASKET</font>
      <img src="../img/arrow.png" width="30px" height="30px;">
   <P class="circle1"><img src="../img/daller.png" width="64px" height="64px"></p> <font >PAYMENT</font>
   <img src="../img/arrow.png" width="30px" height="30px;">
   <P class="circle2"><img src="../img/order.png" width="64px" height="64px"></p> <font >COMPLETE</font>
      <br>
   </div>
      <p class="box"><br><br><br><font size="10px">주문/판매</font></p>
         <br><br><br>
         
         <div class="orderListArea">
            <div class="title">   
               구매자 정보
            </div>
         
      <table class="boardList">
         <thead>
         <tr>
            <th class="name">받는 사람</th>
            <th class="tel">연락처</th>
            <th class="address">배송지</th>
            <th class="address2">배송지 변경</th>
         </tr>
         </thead>
         <tr>
            <td>${member.name }</td>
            <td>${member.tel }</td>
            <td>${member.address }</td>
            <td><input type="text" name="address" value=""></td>
         </tr>   
         
         <tfoot>
            <tr>
               <td colspan="4">[일반상품]</td>
            </tr>
         </tfoot>
      </table>
         </div>
      
      <form action="${path }/board/end.mall?his_no=${his_no}" method="post" name="checkoutForm">
      
   <div class="orderListArea">
      <div class="title">
         구매목록
      </div>
      <table class="boardList" >
         <thead>
         <tr>
            <th class="mutual">상호</th>
            <th class="product">상품명</th>
            <th class="price">가격</th>
            <th class="quantity">수량</th>
            <th class="total">총액</th>
         </tr>
         </thead>
            <c:forEach items="${proList}" var="productSet">
               <tr>
                  <td>${productSet.product.bis_name }</td>
                  <td>${productSet.product.pro_name}</td>
                  <td align="right">${productSet.product.price}원</td>
                  <td align="right">${productSet.quantity}개</td>
                  <td align="right">${productSet.quantity * productSet.product.price}원</td>
               </tr>
            </c:forEach>
            
            <tfoot>
         
            <tr>
               <td colspan="3" align="center">
                  <select name="selectCoupon" id="selectCoupon" class="form-control" style="width: 170px; cursor: pointer;">
                     <option value="none/none/none">할인 쿠폰</option>
                     <c:forEach items="${coupon_history }" var="coupons">
                        <option value="${coupons.his_no }/${coupons.bis_no }/${coupons.discount }">${coupons.bis_name } / ${coupons.discount }%</option>
                     </c:forEach>
                  </select>
                  
                  <script type="text/javascript">
                     $("#selectCoupon").val("${selectCoupon}");
                  
                     $(document).ready(function()
                     {
                        $("#selectCoupon").change(function()
                        {
                           location.href="../board/checkout.mall?&selectCoupon=" + $(this).val();
                        });
                     });
                  </script>
               </td>
               <td colspan="2" align="center">총합: ${totalAmount}원</td>
            </tr>
         </tfoot>
         </table>
         </div>
         <div class="float">
         <input  id="loc5" class="btn btn-success" type="submit" value="구매하기">&nbsp;
         </div>
      </form>
      

      </div>
      <div class="col-xs-2"></div>
      </div>
   </body>
</html>