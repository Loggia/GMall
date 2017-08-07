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
#category_bar {
	height: 45px;
	background-color: rgba(255, 255, 255, 1);
}
 .col-xs-3 {
	padding: 0px 0px 0px 0px;
	height: 240px;
	background-color: white;
}

.fir_line {
	background-color: rgba(255, 255, 255, 1);
	height: 240px;
}

.sec_line {
	background-color: rgba(255, 255, 255, 1);
	height: 240px;
}

.thr_line {
	background-color: rgba(255, 255, 255, 1);
	height: 240px;
}

.for_line { 
	background-color: rgba(255, 255, 255, 1);
	height: 240px;
}

#category ul {
	overflow: hidden;
	list-style: none;
	padding-top: 5px;
}

#category ul li{
	float: left;
	display: inline;
	font-size: 25px;
	font-family: 'Roboto', sans-serif;
	text-align: left;
	cursor: pointer;
	margin-right: 50px;
}

#category ul li a {
	color: rgba(0,0,0,0.75);
}

#category ul li a:hover {
	color: #12d8fa;
	text-decoration: underline;
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

<div class="container-fluid" style="padding: 0px 0px 0px 0px;">
		<div class="col-xs-2" style="padding: 0px 0px 0px 0px; background-color: white; height: 45px;"></div>
		<div class="col-xs-8" id="category_bar" style="padding: 0px 0px 0px 0px;">
			<div id="category" style="margin: 0; padding: 0;">
				<ul style="margin: 0px; padding: 0px;">
					<li><a href="proList.mall?category=육류"><b>육류</b></a></li>
					<li><a href="proList.mall?category=해산물"><b>해산물</b></a></li>
					<li><a href="proList.mall?category=채소"><b>야채</b></a></li>
					<li><a href="proList.mall?category=과일"><b>과일</b></a></li>
					<li><a href="proList.mall?category=곡류"><b>곡류</b></a></li>
					<li><a href="proList.mall?category=조미료"><b>조미료</b></a></li>
				</ul>
			</div>
		</div>
		<div class="col-xs-2" style="padding: 0px 0px 0px 0px; background-color: white; height: 45px;"></div>
		
		<div class="gap_black col-xs-12"></div>
		
		<div class="col-xs-2">&nbsp;</div>
			<div class="col-xs-8" style="padding: 0px 0px 0px 0px; margin-top: 16px;">
				<div style="display: inline;">
					<div class="col-xs-3">
						<div class="mask"></div>
					프리미엄 상품
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
				</div>
				<div style="display: inline;">
					<div class="col-xs-3">
					<div class="mask"></div>
					나의관심 상품
					</div>
					<div class="col-xs-3 ">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
				</div>

				<div style="display: inline;">
					<div class="col-xs-3">
					<div class="mask"></div>
					최다 검색 상품
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
				</div>

				<div style="display: inline;">
					<div class="col-xs-3">
					<div class="mask"></div>
					최다 구매 상품
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3">
					<div class="mask"></div>
					</div>
				</div>
			</div>
		<div class="col-xs-2"></div>
	</div>
</body>
</html>