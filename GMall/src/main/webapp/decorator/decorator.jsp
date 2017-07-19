<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<!-- 부트스트랩 css, cdn -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부트스트랩 js, cdn -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<decorator:head />
<title>GMall</title>
<script type="text/javascript">
	$(document).ready(function() {

		$('#mymenu').on("click", function() {
			if ($(this).attr('data-click-state') == 1) {
				$(this).attr('data-click-state', 0);
				$(this).attr('src', './img/mymenu_noclick.png');
			} else {
				$(this).attr('data-click-state', 1);
				$(this).attr('src', './img/mymenu_click.png');
			}
		}).popover({
			placement : 'bottom',
			html : true,
			content : $('#mymenu_Form').html()
		});

	});
</script>
<style type="text/css">
* {
	list-style: none;
}

.header_topbar {
	height: 35px;
	background: linear-gradient(to left, #1fa2ff, #12d8fa, #a6ffcb);
}

#header_bottombar {
	height: 65px;
	background: linear-gradient(to left, #1fa2ff, #12d8fa, #a6ffcb);
}

#logo_wrap {
	display: inline;
}

#logo {
	cursor: pointer;
	height: 54px;
}

.mymenu_wrap {
	
}

#mymenu {
	cursor: pointer;
	text-align: center;
}

.mymenu_click {
	
}

.mymenu_list {
	cursor: pointer;
	color: black;
}

#main_categorybar {
	height: 40px;
}

.gap_white {
	display: block;
	height: 2px;
	z-index: 1;
	background-color: #fff;
	opacity: .2;
}

.gap_black {
	display: block;
	height: 2px;
	z-index: 1;
	background-color: #000;
	opacity: .2;
}

.TOP {
    overflow: hidden;
    width: 44px;
    height: 42px;
    background-position: -450px -40px;
    vertical-align: top;
    display: block;
    position: fixed;
    right: 0;
    bottom: 80px;
    z-index: 20;
    margin-right: 30px;
    background-color: green;
    color: white;
}
</style>
</head>
<body>
	<!-- 헤더 영역 -->
	<header class="container-fluid">
		<div class="row">
		
			<div id="header_topbar" class="col-xs-12 header_topbar">
				<div class="row">
					<div class="col-xs-2"></div>
					<div class="col-xs-8" style="padding: 0px;">
					
						<button type="button" onclick="location.href='loginForm.mall'" class="btn btn-success btn-sm pull-right" style="margin-right: 15px; margin-top: 3px;">로그인</button>
						<c:if test="">
						<button type="button" class="btn btn-success btn-sm pull-right" style="margin-right: 15px; margin-top: 3px;">${Session.id }</button>
						</c:if>
						
					</div>
					<div class="col-xs-2"></div>
				</div>
			</div>
			
			<div class="gap_black col-xs-12"></div>

			<div id="header_bottombar" class="col-xs-12">
				<div class="row">

					<div class="col-xs-2"></div>

					<div class="col-xs-8" style="padding: 0px;">
						<a href="main.mall" class="pull-left" style="margin-top: 5px;"><img
							id="logo" src="../img/logo.png"></a>

						<form class="navbar-form navbar-left" style="margin-top: 15px;">
							<!-- 검색창 시작 -->
							<div class="input-group">
								<input type="text" class="form-control" placeholder="검색어를 입력해주세요">
								<div class="input-group-btn">
									<button class="btn btn-default" type="submit">
										<i class="glyphicon glyphicon-search"></i>
									</button>
								</div>
							</div>
							<!-- 검색창 끝 -->
						</form>
						
						<!-- 마이메뉴 시작 -->
						<div id="mymenu_wrap" class="pull-right"
							style="margin-top: 25px; margin-right: 15px;">
							<div id="mymenu" data-toggle="popover">
								<span class="glyphicon glyphicon-user" aria-hidden="true"
									style="color: white;"></span> <b style="color: white">MY 쇼핑</b>
								<div class="hide">
									<ol id="mymenu_Form">
										<li><a href="infoForm.mall" class="mymenu_list">내 정보</a></li>
										<li><a href="cartForm.mall" class="mymenu_list">장바구니</a></li>
										<li><a href="deleveryForm.mall" class="mymenu_list">배송 정보</a></li>
										<li><a href="logout.mall" class="mymenu_list">로그아웃</a></li>
									</ol>
								</div>
							</div>
						</div>
						<!-- 마이메뉴 끝 -->

					</div>

					<div class="col-xs-2"></div>

				</div>
			</div>
			<div class="gap_black col-lg-12"></div>
		</div>
	</header>

	<!-- 섹션 영역 -->
	<section class="container-fluid">
		<div class="row">
			<div class="col-xs-2"></div>
			<div class="col-xs-8" style="margin: 15px 0px 15px 0px; padding: 0px 0px 0px 0px; background-color: rgba(255,255,0,0.15); height: 1000px;">
				<decorator:body />
			</div>
			<div class="col-xs-2 "></div>
		</div>
	</section>
	
	<!-- 푸터 영역 -->
	<footer class="container-fluid" style="padding: 0px 0px 0px 0px;">
		<div class="col-xs-12" style="background-color: rgba(255, 0, 0, 0.15); height: 100px;">
		</div>
		<button type="button" class="btn btn-success btn-sm TOP" onclick="location.href='#'">TOP</button>
	</footer>
</body>
</html>