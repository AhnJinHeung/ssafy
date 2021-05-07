<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:set var="spp" value="10" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Happy House</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
<script type="text/javascript">
	$(function() {
		
		$(document).on('click','#addInterest', function() {
			let interestInfo = JSON.stringify({
				"dong" : "${dong}",
				"gugun" : "${gugun}"
			});
			$.ajax({
				url:'${root}/member/addInterest',
				type: 'POST',
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				data: interestInfo,
				success:function(){
					console.log("ok");
					$("#interestBtn").empty();
					let str = "<button type=\"button\" class=\"btn btn-danger\" id=\"removeInterest\">"
					+ "관심지역 삭제</button>";
					$("#interestBtn").append(str);
				},
				error:function(request, error){
					console.log("error");
				}
			});
		});
		
		$(document).on('click','#removeInterest', function() {
			let interestInfo = JSON.stringify({
				"dong" : "${dong}",
				"gugun" : "${gugun}"
			});
			$.ajax({
				url:'${root}/member/removeInterest',
				type: 'POST',
				contentType:'application/json;charset=utf-8',
				dataType:'json',
				data: interestInfo,
				success:function(){
					console.log("ok");
					$("#interestBtn").empty();
					let str = "<button type=\"button\" class=\"btn btn-success\" id=\"addInterest\">"
					+"관심지역 추가</button>";
					$("#interestBtn").append(str);
				},
				error:function(request, error){
					console.log("error");
				}
			});
		});
	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<!-- 상단 Header End  -->

	<div class="container">
		<div style="height: 60px;"></div>
		<!-- 중앙 contents start -->
		<!-- 중앙 center contents start -->
		
		<div class="col-12 text-center">
		<h3 class = "text-center">[${dong} 아파트 거래 정보]</h3>
		
		<c:if test="${userinfo ne null}">
			<div id="interestBtn">
				<c:set var="check" value="true"/>
				<c:set var="area" value="${gugun} ${dong}"/>
				
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
			</div>
		</c:if>
		
		<div style="height:30px;"></div>
		<%@ include file="/WEB-INF/views/include/map.jsp"%>
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
				<tbody id="listArea">
				
				<c:forEach var = "a" items = "${list}" begin="0" end="${spp}">
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
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	<!-- 하단 Footer End  -->
</body>
</html>
