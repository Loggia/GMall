<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/jspHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
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
	width: 332px;
}

.fir_line {
	background-color: rgba(255, 255, 255, 1);
	height: 240px;
	margin: 0px 0px 16px 16px;
}

.sec_line {
	background-color: rgba(255, 255, 255, 1);
	height: 240px;
	margin: 0px 0px 16px 16px;
}

.thr_line {
	background-color: rgba(255, 255, 255, 1);
	height: 240px;
	margin: 0px 0px 16px 16px;
}

.for_line { 
	background-color: rgba(255, 255, 255, 1);
	height: 240px;
	margin: 0px 0px 16px 16px;
}

#category ul {
	overflow: hidden;
	list-style: none;
}

#category ul li{
	background-color : rgba(255, 95, 162, 0.15);
	width: 100px;
	float: left;
	display: inline;
	margin: 0px 10px 0px 0px;
	font-size: 20px;
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
		<div class="col-xs-2" style="background-color: white; height: 45px;"></div>
		<div class="col-xs-8" id="category_bar" style="padding: 0px 0px 0px 0px;">
			<div id="category" style="margin: 0; padding: 0;">
				<ul style="margin: 0px; padding: 0px;">
					<li><b>육류</b></li>
					<li>해산물</li>
					<li>채소</li>
					<li>과일</li>
					<li>곡류</li>
					<li>견과류</li>
				</ul>
			</div>
		</div>
		<div class="col-xs-2" style="background-color: white; height: 45px;"></div>
		
		<div class="gap_black col-xs-12"></div>
		
		<div class="col-xs-2">&nbsp;</div>
		<div id="content-wrap" style="">
			<div class="col-xs-8" style="padding: 0px 0px 0px 0px; margin-top: 16px;">
				<div style="display: inline;">
					<div class="col-xs-3 fir_line">
						<div class="mask"></div>
					프리미엄 상품
					</div>
					<div class="col-xs-3 fir_line">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3 fir_line">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3 fir_line">
					<div class="mask"></div>
					</div>
				</div>
				<div style="display: inline;">
					<div class="col-xs-3 sec_line">
					<div class="mask"></div>
					나의관심 상품
					</div>
					<div class="col-xs-3 sec_line">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3 sec_line">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3 sec_line">
					<div class="mask"></div>
					</div>
				</div>

				<div style="display: inline;">
					<div class="col-xs-3 thr_line">
					<div class="mask"></div>
					최다 검색 상품
					</div>
					<div class="col-xs-3 thr_line">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3 thr_line">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3 thr_line">
					<div class="mask"></div>
					</div>
				</div>

				<div style="display: inline;">
					<div class="col-xs-3 for_line">
					<div class="mask"></div>
					최다 구매 상품
					</div>
					<div class="col-xs-3 for_line">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3 for_line">
					<div class="mask"></div>
					</div>
					<div class="col-xs-3 for_line">
					<div class="mask"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-2">&nbsp;</div>
	</div>
</body>
</html>