<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/jspHeader.jsp"%>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
      <title>사업자 상품 추가하기</title>
   </head>
   
   <body>
   <script type="text/javascript">
 function changes(fr) {
  if(fr=="육류") {
   num = new Array("소고기", "돼지고기","닭고기","개구리 뒷다리","양고기");
  }
  else if(fr=="해산물") {
   num = new Array("소라", "멍게","해삼", "새우", "랍스터");
  }
  else if(fr=="과일") {
   num = new Array("사과", "딸기","토마토","포도", "수박");
  }
  else if(fr=="채소") {
	   num = new Array("상추", "배추","시금치", "당근", "무");
	  }
  else if(fr=="곡류") {
	   num = new Array("쌀", "보리","밀","호밀", "수수");
	  }
  else if(fr=="견과류") {
	   num = new Array("아몬드", "캐슈넛","호두","땅콩", "잣");
	  }
  else if(fr=="조미료") {
	   num = new Array("고춧가루", "후추","설탕","소금", "마약");
	  }

  //document.getElementbyId("Step2")
  
   //두번째값 넣어주기(Option함수 이용)
   for(i=0; i<num.length; i++) {
	   productForm.Step2.options[i] = new Option(num[i]);
  }
 }
</script>

      <form:form modelAttribute="product" action="productUpdate.mall" enctype="multipart/form-data" name="productForm">
         <table cellpadding="0" cellspacing="0"> 
            <tr align="center" valign="middle">
               <td colspan="2"><h2>상품을 등록하자 사업자야</h2></td>
            </tr>
            
         <tr> 
         <td>카테고리</td>
         <td><form:select id="Step1" name='Step1' onchange='changes(value)' path="category">
         <option value="육류">육류</option>
         <option value="해산물">해산물</option>
         <option value="과일">과일</option>
         <option value="채소">채소</option>
         <option value="곡류">곡류</option>
         <option value="견과류">견과류</option>
         <option value="조미료">조미료</option></form:select>
         <form:select id="Step2" name='Step2' path="favorite">
         <option>----</option>
         </form:select></td></tr>
   
         
          <tr> 
               <td>상품이름</td>
               <td>
                  <form:input path="pro_name" />
               </td>
          </tr>     
          
          <tr>
          <td>수량</td>
               <td>
                  <form:input path="cnt"/>
               </td>
          </tr>  
          
          <tr> 
               <td>상품가격</td>
               <td>
                  <form:input path="price" />
               </td>
          </tr>       
          
          
      
           <tr> 
               <td>상품설명</td>
               <td>
                <form:textarea path="pro_content" cols="50" rows="15" />
               </td>
          </tr>
          
          
           <tr> 
               <td>메인사진</td>
               <td><form:input type="file"  path="main_img"/><br></td>
           </tr>
           
           <tr>
              <td>서브사진</td>
              <td><form:input type="file"  path="sub_img1"/><br>
              <form:input type="file"  path="sub_img2"/><br>
              <form:input type="file"  path="sub_img3"/><br></td>
             
           </tr>
     
          <tr>
               <td colspan="2" align="center">
               <input type="button" onclick="javascript:document.productForm.submit()" value="등록 하기">
              
               <input type="button" onclick="javascript:history.go(-1);" value="뒤로 가기">
             </td>
          </tr>
         </table>
      </form:form>      
   </body>
</html>