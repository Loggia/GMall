<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>회원가입</title>
	</head>
	
	<body>
		<form:form modelAttribute="member" method="post" action="join.mall">
			<table>
				<tr valign="top" height="50">
					<td>회원 구분</td>
					<td>
						<form:radiobutton path="type" value="1" label="일반 회원" />
						<form:radiobutton path="type" value="2" label="사업자 회원" />
					</td>
				</tr>
				
				<tr>
					<td>아이디</td>
					<td>
						<form:input path="id" /> 
					</td>
				</tr>
				
				<tr>
					<td>비밀번호</td>
					<td>
						<form:input path="pass" />
					</td>
				</tr>	
				
				<tr>
					<td>이름</td>
					<td>
						<form:input path="name" />
					</td>
				</tr>
				
				<tr>
					<td>닉네임</td>
					<td>
						<form:input path="nickname" />
					</td>
				</tr>
				
				<tr>
					<td>성별</td>
					<td>
						<form:radiobutton path="gender" value="1" label="남" />
						<form:radiobutton path="gender" value="2" label="여" />
					</td>
				</tr>
				
				<tr>
					<td>연락처</td>
					<td>
						<form:input path="tel" />
					</td>
				</tr>
				
				<tr>
					<td>주소</td>
					<td>
						<form:input path="address" />
					</td>
				</tr>
				
				<!-- 관심 상품 드롭박스 추가 바람 -->
				
				<tr height="40px;">
					<td colspan="2" align="center">
						<input type="submit" value="등록" />
						<input type="reset" value="리셋" />
					</td>
				</tr>
			</table>				
		</form:form>
	</body>
</html>