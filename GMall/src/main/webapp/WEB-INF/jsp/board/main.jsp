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
		
		<%-- 	<div style="display: inline;">
				<c:forEach items="${primList }" var="prim">
					<div class="col-xs-3">
						<div class="1st-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
							<img src="../img/${prim.fileurl }">
						</div>
					</div>
				</c:forEach>
			</div> --%>
			
			<div style="display: inline;">
			<c:forEach items="${primList }" var="prim" varStatus="stat">
			<div class="col-xs-3">
			<div id="carousel${stat.index }" class="carousel slide 1st-line mask" data-ride="carousel" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
				<!-- Indicators -->
				<ol class="carousel-indicators" style="margin-top: 10px;">
					<li data-target="#carousel" data-slide-to="0" class="active"></li>
					<li data-target="#carousel" data-slide-to="1"></li>
					<li data-target="#carousel" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">

					<div class="item active">
						<img src="../img/sanaprof.PNG" alt="" align="" style="width: 300px; height: 300px;">
						<div class="carousel-caption">
						<h4 style="margin-bottom: 20px;">사나 이미지</h4>
						</div>
					</div>

					<div class="item">
						<img src="../img/logo.png" alt="" align="middle" style="width: 300px; height: 300px;">
						<div class="carousel-caption">
							<h4 style="margin-bottom: 20px;">로고</h4>
						</div>
					</div>

					<div class="item">
						<img src="../img/prim.png" alt="" align="middle" style="width: 300px; height: 300px;">
						<div class="carousel-caption">
							<h4 style="margin-bottom: 20px;">프리미엄</h4>
						</div>
					</div>

				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel${stat.index }" role="button" data-slide="prev" style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);" class="right carousel-control" href="#carousel${stat.index }" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			</div>
			</c:forEach>
			</div>
			
			<div style="display: inline;">
				<c:forEach items="${popuList }" var="popu">
					<div class="col-xs-3">
						<div class="2nd-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
							<img src="../img/${popu.fileurl }">
						</div>
					</div>
				</c:forEach>
			</div>

			<div style="display: inline;">
				<c:forEach items="${newList }" var="newL">
					<div class="col-xs-3">
						<div class="3th-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
							<img src="../img/${newL.fileurl }">
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