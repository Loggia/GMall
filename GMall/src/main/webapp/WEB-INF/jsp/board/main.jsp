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
    $('.carousel-inner:first-child').addClass('active');
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
			
			
			<div class="col-xs-3">
			<div id="carousel1" class="carousel slide 1st-line mask" data-ride="carousel" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
				<!-- Indicators -->
				<ol class="carousel-indicators" style="margin-top: 10px;">
					<li data-target="#carousel1" data-slide-to="0" class="active"></li>
					<li data-target="#carousel1" data-slide-to="1"></li>
					<li data-target="#carousel1" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<a href="${path }/board/productDetail.mall?pro_no=${prim1.pro_no}&category=${prim1.category}">
									<img src="../picture/${prim1.fileurl }" alt="" align="middle" style="width: 300px; height: 300px;">
								</a>
								<div class="carousel-caption">
									<h4 style="margin-bottom: 20px;">${prim1.pro_name }</h4>
								</div>
							</div>

							<c:forEach items="${primList1 }" var="primList1">
								<div class="item">
									<a href="${path }/board/productDetail.mall?pro_no=${primList1.pro_no}&category=${primList1.category}">
										<img src="../picture/${primList1.fileurl }" alt="" align="middle" style="width: 300px; height: 300px;">
									</a>
									<div class="carousel-caption">
										<h4 style="margin-bottom: 20px;">${primList1.pro_name }</h4>
									</div>
								</div>
							</c:forEach>

						</div>

						<!-- Controls -->
				<a class="left carousel-control" href="#carousel1" role="button" data-slide="prev" style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel1" role="button" data-slide="next" style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			</div>
			
			
			
			<div class="col-xs-3">
			<div id="carousel2" class="carousel slide 1st-line mask" data-ride="carousel" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
				<!-- Indicators -->
				<ol class="carousel-indicators" style="margin-top: 10px;">
					<li data-target="#carousel2" data-slide-to="0" class="active"></li>
					<li data-target="#carousel2" data-slide-to="1"></li>
					<li data-target="#carousel2" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<a href="${path }/board/productDetail.mall?pro_no=${prim2.pro_no}&category=${prim2.category}">
									<img src="../picture/${prim2.fileurl }" alt="" align="middle" style="width: 300px; height: 300px;">
								</a>
								<div class="carousel-caption">
									<h4 style="margin-bottom: 20px;">${prim2.pro_name }</h4>
								</div>
							</div>

							<c:forEach items="${primList2 }" var="primList2">
								<div class="item">
									<a href="${path }/board/productDetail.mall?pro_no=${primList2.pro_no}&category=${primList2.category}">
										<img src="../picture/${primList2.fileurl }" alt="" align="middle" style="width: 300px; height: 300px;">
									</a>
									<div class="carousel-caption">
										<h4 style="margin-bottom: 20px;">${primList2.pro_name }</h4>
									</div>
								</div>
							</c:forEach>

						</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel2" role="button" data-slide="prev" style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel2" role="button" data-slide="next" style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			</div>
			
			
			
			<div class="col-xs-3">
			<div id="carousel3" class="carousel slide 1st-line mask" data-ride="carousel" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
				<!-- Indicators -->
				<ol class="carousel-indicators" style="margin-top: 10px;">
					<li data-target="#carousel3" data-slide-to="0" class="active"></li>
					<li data-target="#carousel3" data-slide-to="1"></li>
					<li data-target="#carousel3" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<a href="${path }/board/productDetail.mall?pro_no=${prim3.pro_no}&category=${prim3.category}">
									<img src="../picture/${prim3.fileurl }" alt="" align="middle" style="width: 300px; height: 300px;">
								</a>
								<div class="carousel-caption">
									<h4 style="margin-bottom: 20px;">${prim3.pro_name }</h4>
								</div>
							</div>

							<c:forEach items="${primList3 }" var="primList3">
								<div class="item">
									<a href="${path }/board/productDetail.mall?pro_no=${primList3.pro_no}&category=${primList3.category}">
										<img src="../picture/${primList3.fileurl }" alt="" align="middle" style="width: 300px; height: 300px;">
									</a>
									<div class="carousel-caption">
										<h4 style="margin-bottom: 20px;">${primList3.pro_name }</h4>
									</div>
								</div>
							</c:forEach>

						</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel3" role="button" data-slide="prev" style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel3" role="button" data-slide="next" style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			</div>
			
			
			
			<div class="col-xs-3">
			<div id="carousel4" class="carousel slide 1st-line mask" data-ride="carousel" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
				<!-- Indicators -->
				<ol class="carousel-indicators" style="margin-top: 10px;">
					<li data-target="#carousel4" data-slide-to="0" class="active"></li>
					<li data-target="#carousel4" data-slide-to="1"></li>
					<li data-target="#carousel4" data-slide-to="2"></li>
				</ol>

				<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<a href="${path }/board/productDetail.mall?pro_no=${prim4.pro_no}&category=${prim4.category}">
									<img src="../picture/${prim4.fileurl }" alt="" align="middle" style="width: 300px; height: 300px;">
								</a>
								<div class="carousel-caption">
									<h4 style="margin-bottom: 20px;">${prim4.fileurl }</h4>
								</div>
							</div>

							<c:forEach items="${primList4 }" var="primList4">
								<div class="item">
									<a href="${path }/board/productDetail.mall?pro_no=${primList4.pro_no}&category=${primList4.category}">
										<img src="../picture/${primList4.main_img }" alt="" align="middle" style="width: 300px; height: 300px;">
									</a>
									<div class="carousel-caption">
										<h4 style="margin-bottom: 20px;">${primList4.pro_name }</h4>
									</div>
								</div>
							</c:forEach>

						</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel4" role="button" data-slide="prev" style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel4" role="button" data-slide="next" style="background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			</div>
			
			
			</div>
			
			
			
			<div style="display: inline;">
				<c:forEach items="${popuList }" var="popu">
					<div class="col-xs-3">
						<div class="2nd-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
							<img src="../picture/${popu.fileurl }" style="width: 300px; height: 300px;">
						</div>
					</div>
				</c:forEach>
			</div>

			<div style="display: inline;">
				<c:forEach items="${newList }" var="newL">
					<div class="col-xs-3">
						<div class="3th-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
							<img src="../picture/${newL.fileurl }" style="width: 300px; height: 300px;">
						</div>
					</div>
				</c:forEach>
			</div>

			<div style="display: inline;">
				<c:forEach items="${interList }" var="inter">
					<div class="col-xs-3">
						<div class="4th-line mask" style="background-color: white; margin-left: 15px; margin-bottom: 15px;">
							<img src="../picture/${inter.fileurl }" style="width: 300px; height: 300px;">
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>