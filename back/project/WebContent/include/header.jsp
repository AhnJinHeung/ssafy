<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	$(function() {
		$.getJSON('./json/sidoJSON.jsp', function(data) {
			$.each(data, function(index, item) {
				$('#sido').append(
						"<option value = " + item.sido_name + ">"
								+ item.sido_name + "</option>");
			})
		});
		$("#sido").change(function() {
					var sido = $("#sido").val();
					var act = "gugunsearch";
					$.ajax({
						url : "http://localhost:8080/happy/main",
						data : {
							"sido" : sido,
							"act" : act
						},
						type : "POST",
						dataType : "json",
						success : function(data) { //DB접근 후 가져온 데이터
							var list = '';
							$("#gugun").empty();
							$.each(data, function(index, item) {
								list = '';
								list += "<option value=" +item.gugun+" >"
										+ item.gugun + "</option>";
								$("#gugun").append(list);
							});
						}
					})
		});
		$("#gugun").change(function() {
			var gugun = $("#gugun").val();
			var act = "dongsearch";
			$.ajax({
				url : "http://localhost:8080/happy/main",
				data : {
					"gugun" : gugun,
					"act" : act
				},
				type : "POST",
				dataType : "json",
				success : function(data) { //DB접근 후 가져온 데이터
					var list = '';
					$("#dong").empty();
					$.each(data, function(index, item) {
						list = '';
						list += "<option value=" +item.dong+" >"
								+ item.dong + "</option>";
						$("#dong").append(list);
					});
				}
			})
		});
	})
	function login() {
		if (document.getElementById("userid").value == "") {
			alert("아이디 입력!!!");
			return;
		} else if (document.getElementById("userpwd").value == "") {
			alert("비밀번호 입력!!!");
			return;
		} else {
			document.getElementById("loginform").action = "${root}/main";
			document.getElementById("loginform").submit();
		}
	}

	function join() {
		if (document.getElementById("uid").value == "") {
			alert("아이디 입력!!!");
			return;
		} else if (document.getElementById("pwd").value == "") {
			alert("비밀번호 입력!!!");
			return;
		} else if (document.getElementById("uname").value == "") {
			alert("이름 입력!!!");
			return;
		} else if (document.getElementById("mail").value == "") {
			alert("이메일 입력!!!");
			return;
		} else if (document.getElementById("address").value == "") {
			alert("주소 입력!!!");
			return;
		} else {
			document.getElementById("registerform").action = "${root}/main";
			document.getElementById("registerform").submit();
		}
	}

	function searchApt() {
		if ($("#dong option:selected").val() == "동") {
			alert("동을 입력하세요");
		} else {
			document.getElementById("frm").action = "${root}/main";
		}
	}

	function deleteMember() {
		if (!confirm("정말 삭제하시겠습니까?")) {

		} else {
			alert("회원정보가 삭제되었습니다.");
			location.href = "${root}/main?act=deleteMember";
		}
	}

	function moveJoin() {
		document.location.href = "${root}/main?act=mvregister";
	}

	function modify() {
		if (document.getElementById("info_pwd").value == "") {
			alert("비밀번호 입력!!!");
			return;
		} else if (document.getElementById("info_name").value == "") {
			alert("이름 입력!!!");
			return;
		} else if (document.getElementById("info_email").value == "") {
			alert("이메일 입력!!!");
			return;
		} else if (document.getElementById("info_address").value == "") {
			alert("주소 입력!!!");
			return;
		} else {
			document.getElementById("modifyform").action = "${root}/main";
			document.getElementById("modifyform").submit();
		}
	}

	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>
<body>
	<header>
		<div class="container nav justify-content-end">
			<c:if test="${userinfo eq null}">
				<ul class="nav in_nav before">
					<li class="nav-item"><a class="nav-link text-danger"
						onclick="javascript:moveJoin();"><i class="fa fa-user-plus"
							aria-hidden="true" style="color: black;"></i>SignUp</a></li>
					<li class="nav-item"><a class="nav-link text-danger"
						data-toggle="modal" data-target="#myModal"><i
							class="fa fa-sign-in" aria-hidden="true" style="color: black;"></i>Login</a></li>
				</ul>
			</c:if>
			<c:if test="${userinfo ne null}">
				<ul class="nav out_nav after">
					<li class="nav-item"><a class="nav-link text-primary nav-uid"
						href="#" data-toggle="modal" data-target="#myInfo"><i
							class="fa fa-user" aria-hidden="true" style="color: black;"></i>${userinfo.userName}</a></li>
					<li class="nav-item"><a class="nav-link text-danger"
						href="${root}/main?act=logout"><i class="fa fa-sign-out"
							aria-hidden="true" style="color: black;"></i>Logout</a></li>
					<li class="nav-item"><a class="nav-link text-primary nav-uid"
						href="#" data-toggle="modal" data-target="#myInterest"><i
							class="fa fa-user" aria-hidden="true" style="color: black;"></i>관심지역</a></li>
				</ul>
			</c:if>
		</div>
		<div class="jumbotron jumbotron-fluid"
			style="background-image: url(./img/apart.jpg); background-repeat: no-repeat; background-size: cover; background-position: center;">
			<div class="container">
				<h1 style="">
					<a href="index.jsp"
						style="color: black; text-decoration: none; text-decoration: none;">Happy
						House</a>
				</h1>
				<div style="border-color: white; border-style: solid;"></div>
				<p style="color: #616161;">Give me, Happy House...</p>
			</div>
		</div>
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<!-- Links -->
			<div class="container">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
					<li class="nav-item"><a class="nav-link"
						href="https://news.google.com/topstories?hl=ko&gl=KR&ceid=KR:ko">오늘의
							뉴스</a></li>
				</ul>
				<div>
					<form class="form-inline" id="frm" method="post" action="">
						<input type="hidden" name="act" id="act" value=findApt>
						<!-- <input type="hidden" id="code"  name="code" value="code"/> -->
						<div class="form-group md">
							<select class="form-control btn btn-secondary" name="sido"
								id="sido">
								<option selected>도/광역시</option>
							</select>
						</div>
						<div class="form-group md-1">
							<select class="form-control btn btn-secondary" name="gugun"
								id="gugun">
								<option selected>시/구/군</option>
							</select>
						</div>
						<div class="form-group md-1">
							<select class="form-control btn btn-secondary" name="dong"
								id="dong">
								<option selected>동</option>
							</select>
						</div>
						<div style="margin: 5px;">
							<button class="btn btn-primary btn-login"
								onclick="javascript:searchApt();">검색</button>
						</div>
					</form>

				</div>
			</div>
		</nav>
	</header>
	<div class="modal text-black" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Login</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form id="loginform" method="post" action="">
						<input type="hidden" name="act" id="act" value="login">
						<div class="form-group">
							<label for="uid">아이디:</label> <input type="text"
								class="form-control" placeholder="Enter id" id="userid"
								name="userid">
						</div>
						<div class="form-group">
							<label for="pwd">비밀번호:</label> <input type="password"
								class="form-control" placeholder="Enter password" id="userpwd"
								name="userpwd"
								onkeydown="javascript:if(event.keyCode == 13) {login();}">
						</div>
						<button class="btn btn-primary btn-login" data-dismiss="modal"
							onclick="javascript:login();">로그인</button>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	<!-- The Modal -->
	<div class="modal text-black" id="myInfo">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">회원정보</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form id="modifyform" method="post" action="">
						<input type="hidden" name="act" id="act" value="modify">
						<div class="form-group">
							<label for="info_id">아이디:</label> <input type="text" id="info_id"
								name="info_id" class="form-control" value="${userinfo.userId}"
								readOnly>
						</div>
						<div class="form-group">
							<label for="info_pwd">비밀번호:</label> <input type="text"
								id="info_pwd" name="info_pwd" class="form-control"
								value="${userinfo.userPwd}">
						</div>
						<div class="form-group">
							<label for="info_name">이름:</label> <input type="text"
								id="info_name" name="info_name" class="form-control"
								value="${userinfo.userName}" readOnly>
						</div>
						<div class="form-group">
							<label for="info_email">이메일:</label> <input type="text"
								id="info_email" name="info_email" class="form-control"
								value="${userinfo.email}">
						</div>
						<div class="form-group">
							<label for="info_address">주소:</label> <input type="text"
								id="info_address" name="info_address" class="form-control"
								value="${userinfo.address}">
						</div>
						<div class="form-group">
							<label for="info_date">등록일:</label> <input type="text"
								id="info_date" name="info_date" class="form-control"
								value="${userinfo.joindate}" readOnly>
						</div>
						<button class="btn btn-primary btn-login" data-dismiss="modal"
							onclick="javascript:modify();">수정</button>
						<button class="btn btn-danger btn-login" data-dismiss="modal"
							onclick="javascript:deleteMember();">삭제</button>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	
	<div class="modal text-black" id="myInterest">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">관심지역 목록</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<table>
					<c:forEach var = "list" items = "${userinfo.interest}">
						<tr><td> ${list} </td></tr>
					</c:forEach>
					</table>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>