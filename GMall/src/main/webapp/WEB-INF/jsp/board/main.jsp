<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.col-xs-2 {
	background-color: rgba(255, 0, 0, 0.15);
	height: 200px;
}

.col-xs-3 {
	background-color: rgba(0, 255, 0, 0.15);
	height: 200px;
	padding: 0px 0px 0px 0px;
}

.fir_line {
	background-color: rgba(255, 0, 0, 0.15);
	margin-right: 10px;
}

.sec_line {
	background-color: rgba(0, 255, 0, 0.15);
	margin-right: 10px;
}
</style>
</head>
<body>
<div class="row">
  <div class="col-xs-3 fir_line">col-xs-3 fir_line</div>
  <div class="col-xs-3 fir_line"></div>
  <div class="col-xs-3 fir_line"></div>
  <div class="col-xs-3 fir_line_end"></div>
</div>
<div class="row">
  <div class="col-xs-2 sec_line">col-xs-2 sec_line</div>
  <div class="col-xs-2 sec_line"></div>
  <div class="col-xs-2 sec_line"></div>
  <div class="col-xs-2 sec_line_end"></div>
</div>
</body>
</html>