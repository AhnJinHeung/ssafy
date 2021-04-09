<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Happy House</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!--   <script type="text/javascript" >
    </script>-->
    
<script type="text/javascript">
	$(function() {
		$("#addInterest").click(function() {
			location.href = "${root}/main?act=addInterest&gugun=${gugun}&dong=${dong}";
		});
		
		$("#removeInterest").click(function() {
			location.href = "${root}/main?act=removeInterest&gugun=${gugun}&dong=${dong}";
		});
	})
</script>
</head>
<body>
	<%@ include file="/include/header.jsp"%>
	<!-- 상단 Header End  -->

	<div class="container">
		<div style="height: 60px;"></div>
		<!-- 중앙 contents start -->
		<!-- 중앙 center contents start -->
		
		<div class="col-12 text-center">
		<h3 class = "text-center">[${dong} 아파트 거래 정보]</h3>
		
		<c:if test="${userinfo ne null}">
			<c:set var="check" value="true"/>
			<c:set var="area" value="${gugun}${dong}"/>
			
			<c:forEach var = "list" items = "${userinfo.interest}">
				<c:if test="${check}">
					<c:if test ="${list eq area}">
						<button type="button" class="btn btn-danger" id="removeInterest">관심지역 삭제</button>
						<c:set var="check" value="false"/>
					</c:if>
				</c:if>
			</c:forEach>
			
			<c:if test ="${check eq true}">
				<button type="button" class="btn btn-success" id="addInterest">관심지역 추가</button>
			</c:if>
		</c:if>
		
		<div style="height:30px;"></div>
		
			<div id="map" style="max-width: 1200px; height: 500px;"></div>
			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=eb94e0a165fada25939d9bf736b9992f"></script>
			<script>
				var container = document.getElementById('map');
				var options = {
					center: new kakao.maps.LatLng(37.5915245479787, 126.9768010428442),
					level: 6
				};
		
				var map = new kakao.maps.Map(container, options);
				var markerPosition  = new kakao.maps.LatLng(37.5915245479787, 126.9768010428442); 
				var marker = new kakao.maps.Marker({
				    position: markerPosition
				});
				marker.setMap(map);
				</script>
		</div>
		<div class="col-12">
			
			<c:if test ="${empty list }">
				<h3 class = "text-center">${dong} 정보가 없습니다.</h3>
			</c:if>
			<c:if test ="${!empty list }">
			
			<table class="table table-striped text-center">
				<thead>
					<tr>
						<th>아파트명</th>
						<th>가격</th>
						<th>대지면적</th>
						<th>건축년도</th>
					</tr>
				</thead>
				<tbody>
				
				<c:forEach var = "a" items = "${list}">
					<tr>
						<td>${a.aptName }</td>
						<td>${a.dealAmount }</td>
						<td>${a.area }</td>
						<td>${a.buildYear }</td>
					</tr>
				</c:forEach>

				</tbody>
			</table>
			</c:if>
		</div>
		<!-- 중앙 center contents end -->
		<div style="height: 60px;"></div>
		<!-- 중앙 contents end -->
	</div>
	<!-- 하단 Footer Start  -->
	<footer
		class="navbar navbar-expand-md justify-content-center bg-light align-bottom">
		<div class="row">
			<h5 class="nav-link text-secondary">Find Us</h5>
			<div class="col-md-12">
				<ul class="navbar-nav">
					<li><label class="nav-link text-secondary">(SSAFY) 서울시
							강남구 테헤란로 멀티스퀘어</label></li>
					<li><label class="nav-link text-secondary">1544-9001</label></li>
					<li><a class="nav-link text-secondary" href="#">admin@ssafy.com</a></li>
				</ul>
			</div>
			<label class="nav-link text-secondary">Copyright by SSAFY.
				All rights reserved.</label>
		</div>
	</footer>

	<!-- 하단 Footer End  -->
	<!-- The Modal -->
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
					<div class="form-group">
						<label for="uid">아이디:</label> <input type="text"
							class="form-control" placeholder="Enter id" id="login_id">
					</div>
					<div class="form-group">
						<label for="pwd">비밀번호:</label> <input type="password"
							class="form-control" placeholder="Enter password" id="login_pw">
					</div>
					<button class="btn btn-primary btn-login" data-dismiss="modal">로그인</button>
					<a style="color: black;" href="pwd.html"><i class="fa fa-key"
						aria-hidden="true"></i>비밀번호를 잊으셨나요?</a>
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
					<div class="form-group">
						<label for="uid">아이디:</label> <input type="text" id="info_id"
							class="form-control" placeholder="Enter id" value="">
					</div>
					<div class="form-group">
						<label for="pwd">비밀번호:</label> <input type="text" id="info_pw"
							class="form-control" placeholder="Enter password" value="">
					</div>
					<button class="btn btn-primary btn-login" data-dismiss="modal">수정</button>

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
