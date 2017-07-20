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
	height: 1px;
	z-index: 1;
	background-color: #fff;
	opacity: 0.15;
}

.gap_black {
	display: block;
	height: 1px;
	z-index: 1;
	background-color: #000;
	opacity: 0.15;
}

.TOP {
    width: 50px;
    height: 50px;
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

#bus_img {
	display: none;
}
#bus_num {
	display: none;
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
					
						<!-- 모달 로그인창 띄우는 버튼 -->
						<c:if test="${session.LOGIN_MEMBER == null}">
						<button type="button" data-toggle="modal" data-target="#loginFormModal" class="btn btn-success btn-sm pull-right" style="margin-right: 15px; margin-top: 3px;">로그인</button>
						</c:if>
						<c:if test="${!Session.LOGIN_MEMBER == null}">
						<button type="button" data-toggle="modal" data-target="#loginFormModal" class="btn btn-success btn-sm pull-right" style="margin-right: 15px; margin-top: 3px;">${Session.LOGIN_MEMBER }</button>
						</c:if>
						<!-- 모달 로그인폼 바디-->
						<div class="modal fade" id="loginFormModal" role="dialog">
							<div class="modal-dialog">

								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">로그인</h4>
									</div>
									<div class="modal-body">
										<form action="login.mall" method="post" name="loginform">
											<div class="form-group">
												<label for="recipient-name" class="control-label">ID:</label>
												<input name="id" type="text" class="form-control" id="recipient-name" placeholder="아이디를 입력해주세요">
											</div>
											<div class="form-group">
												<label for="message-text" class="control-label">PASSWORD:</label>
												<input name="pass" type="password" class="form-control" id="message-text" placeholder="비밀번호를 입력해주세요">
											</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-info" data-dismiss="modal" data-toggle="modal" data-target="#joinFormModal">회원가입</button>
										<button type="submit" class="btn btn-success" data-dismiss="modal" onclick="document.loginform.submit()">로그인</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
									</div>
								</div>

							</div>
						</div>
						
						<!-- 조인폼 모달 바디-->
						<div class="modal fade" id="joinFormModal" role="dialog">
							<script type="text/javascript">
								$(document).ready(function() {
									$("#type_nomal").click(function() {
										$("#bus_num").slideUp("slow");
										$("#bus_img").slideUp("slow");
									});

									$("#type_bussiness").click(function() {
										$("#bus_num").slideDown("slow");
										$("#bus_img").slideDown("slow");
									});
								});
							</script>
							<div class="modal-dialog">

								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title">Goodee 가족되기</h4>
									</div>
									<div class="modal-body">
										<form action="join.mall" method="post" name="joinform">
											<div class="form-group">
												<label class="radio-inline-lg" id="type_nomal" style="cursor: pointer;"> <input type="radio" name="type" value="1">일반 회원</label>&nbsp;&nbsp;&nbsp;
												<label class="radio-inline-lg" id="type_bussiness" style="cursor: pointer;"> <input type="radio" name="type" value="2">사업자 회원</label>
											</div>
											<div class="form-group">
												<label for="recipient-name" class="control-label">아이디:</label>
												<input name="id" type="text" class="form-control" id="recipient-name" placeholder="아이디를 입력해주세요">
											</div>
											<div class="form-group">
												<label for="message-text" class="control-label">비밀번호:</label>
												<input name="pass" type="password" class="form-control" id="message-text" placeholder="비밀번호를 입력해주세요">
											</div>
											<div class="form-group">
												<label for="recipient-name" class="control-label">이름:</label>
												<input name="name" type="text" class="form-control" id="recipient-name" placeholder="이름을 입력해주세요">
											</div>
											<div class="form-group">
												<label for="message-text" class="control-label">닉네임:</label>
												<input name="nickname" type="text" class="form-control" id="message-text" placeholder="닉네임을 입력해주세요">
											</div>
											<div class="form-group">
												<label for="recipient-name" class="control-label">성별:&nbsp;&nbsp;</label>
												<label class="radio-inline-lg" style="cursor: pointer;">
												<input type="radio"name="gender" value="1" style="cursor: pointer;">남자</label>
												&nbsp;&nbsp;
												<label class="radio-inline-lg" style="cursor: pointer;">
												<input type="radio"name="gender" value="2" style="cursor: pointer;">여자</label>
											</div>
											<div class="form-group">
												<label for="message-text" class="control-label">연락처:</label>
												<input name="tel" type="text" class="form-control" id="message-text" placeholder="연락처를 입력해주세요">
											</div>
											<div class="form-group">
												<label for="message-text" class="control-label">주소:</label>
												<input name="address" type="text" class="form-control" id="message-text" placeholder="주소를 입력해주세요">
											</div>
											<div class="form-group">
												<label for="sel1">관심 상품:</label>
												<select name="interest" class="form-control" id="sel1" style="width: 100px; cursor: pointer;">
													<option>육류</option>
													<option>해산물</option>
													<option>과일</option>
													<option>채소</option>
													<option>곡류</option>
													<option>견과류</option>
												</select>
											</div>
												<div class="form-group" id="bus_num">
													<label for="message-text" class="control-label">사업자
														번호:</label> <input name="bis_no" type="text" class="form-control"
														id="message-text" placeholder="사업자 번호를 입력해주세요">
												</div>
												<div class="form-group" id="bus_img">
													<label for="message-text" class="control-label">상호:</label>
													<input name="bis_name" type="text" class="form-control"
														id="message-text" placeholder="상호를 입력해주세요">
												</div>
										</form>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-success" data-dismiss="modal" onclick="document.joinform.submit()">가입 완료</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
									</div>
								</div>

							</div>
						</div>
						
						<c:if test="">
						<button type="button" class="btn btn-success btn-sm pull-right" style="margin-right: 15px; margin-top: 3px;"></button>
						</c:if>
						
					</div>
					<div class="col-xs-2"></div>
				</div>
			</div>
			
			<div class="gap_white col-xs-12"></div>

			<div id="header_bottombar" class="col-xs-12">
				<div class="row">

					<div class="col-xs-2"></div>

					<div class="col-xs-8">
						<a href="main.mall" class="pull-left" style="margin-top: 5px;"><img
							id="logo" src="../img/logo.png"></a>

						<form class="navbar-form pull-left" style="margin-top: 15px;">
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
									style="color: white;"></span><b style="color: white">MY 쇼핑</b>
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
	<%-- <section class="container-fluid">
		<div class="col-xs-2"></div>
		<div class="col-xs-8"
			style="margin: 0px 0px 0px 0px; padding: 0px 0px 0px 0px;">
			<decorator:body />
		</div>
		<div class="col-xs-2 "></div>
	</section> --%>
	<decorator:body />

	<!-- 푸터 영역 -->
	<footer class="container-fluid" style="padding: 0px 0px 0px 0px;">
		<div class="col-xs-12" style="background-color: rgba(255, 0, 0, 0.15); height: 100px; position: absolute;">
		</div>
		<button type="button" class="btn btn-success btn-sm TOP" onclick="location.href='#'">TOP</button>
	</footer>
</body>
</html>