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