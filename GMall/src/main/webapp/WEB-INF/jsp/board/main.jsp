<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript">
$(document).ready(function() {
	
});
</script>
<style type="text/css">
body {
	background-color: #e9ecef;
}
 .col-xs-3 {
	padding: 0px 0px 0px 0px;
	height: 300px;
}

.1st-line {
	height: 240px;
}

.2nd-line {
	height: 240px;
}

.3th-line {
	height: 240px;
}

.4th-line { 
	height: 240px;
}

.mask {
	position: absolute;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	display: block;
	overflow: hidden;
	border: 1px solid #ced2d7
}

</style>
</head>
<body>

<div class="container-fluid" style="padding: 0px 0px 0px 0px; margin-top: 16px; margin-bottom: 16px;">
		<div class="main_cont" style="padding: 0px 0px 0px 0px; margin: 0 auto; width: 1268px;">
			<div style="display: inline;">
				<c:forEach begin="1" end="4">
					<div class="col-xs-3">
					<div class="1st-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
						</div>
					</div>
				</c:forEach>
			</div>
			<div style="display: inline;">
				<c:forEach begin="1" end="4">
					<div class="col-xs-3">
						<div class="2nd-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
						</div>
					</div>
				</c:forEach>
			</div>

			<div style="display: inline;">
				<c:forEach begin="1" end="4">
					<div class="col-xs-3">
					<div class="3th-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
						</div>
					</div>
				</c:forEach>
			</div>

			<div style="display: inline;">
				<c:forEach items="${interList }" var="inter">
					<div class="col-xs-3">
						<div class="4th-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
							<img src="../img/${inter.fileurl }">
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>