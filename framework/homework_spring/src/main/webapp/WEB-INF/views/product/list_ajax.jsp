<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
		$(document).ready(function() {
			$(document).on('click', ".page-item", function() {
				let condition = JSON.stringify({
					"key" : $("#key").val(), 
					"word" : $("#word").val(), 
					"pg" : $(this).attr("data-page"), 
					"spp" : $("#sspp").val(), 
					"start" : 1
				});
				$.ajax({
					url: '${root}/admin/product/search',
					type: 'POST',
					contentType: 'application/json;charset=utf-8',
					dataType:'json',
					data: condition,
					success:function(map) {
						makeList(map['products']);
					}
				});
			});
			
			$("#searchBtn").click(function() {
				$("#key").val($("#skey").val());
				$("#word").val($("#sword").val());
				
				let condition = JSON.stringify({
					"key" : $("#key").val(), 
					"word" : $("#word").val(), 
					"pg" : $("#spg").val(), 
					"spp" : $("#sspp").val(), 
					"start" : 1
				});
				$.ajax({
					url: '${root}/admin/product/search',
					type: 'POST',
					contentType: 'application/json;charset=utf-8',
					dataType:'json',
					data: condition,
					success:function(map) {
						makeList(map['products']);
					}
				});
			});
			
			$(document).on("dblclick", "tr.view", function() {
				let code = $(this).attr("data-id");
				$.ajax({
					url:'${root}/admin/product/' + code,  
					type:'GET',
					contentType:'application/json;charset=utf-8',
					success:function(product) {
						$("#code").val(product.code);
						$("#name").val(product.name);
						$("#company").val(product.company);
						$("#price").val(product.price);
						$("#description").text(product.description);
					}
				});			
			});
			
			$("#insertBtn").click(function() {
				let product = JSON.stringify({
					"code" : $("#code").val(), 
					"name" : $("#name").val(), 
					"company" : $("#company").val(), 
					"price" : $("#price").val(), 
					"description" : $("#description").val(), 
					"attach" : $("#attach").val(), 
				});
				$.ajax({
					url: '${root}/admin/product',
					type: 'POST',
					contentType: 'application/json;charset=utf-8',
					dataType:'json',
					data: product,
					success:function(map) {
						makeList(map['products']);
					}
				});
			});
			
			$("#updateBtn").click(function() {
				let product = JSON.stringify({
					"code" : $("#code").val(), 
					"name" : $("#name").val(), 
					"company" : $("#company").val(), 
					"price" : $("#price").val(), 
					"description" : $("#description").val(), 
					"attach" : $("#attach").val(), 
				});
				$.ajax({
					url: '${root}/admin/product',
					type: 'PUT',
					contentType: 'application/json;charset=utf-8',
					dataType:'json',
					data: product,
					success:function(map) {
						makeList(map['products']);
					}
				});
			});
			
			$("#deleteBtn").click(function() {
				let code = $("#code").val();
				$.ajax({
					url: '${root}/admin/product/' + code,
					type: 'DELETE',
					dataType:'json',
					success:function(map) {
						makeList(map['products']);
					}
				});
			});
		});
		
		function makeList(products) {
			$("#plist").empty();
			$(products).each(function(index, product) {
				let str = `
					<tr id="view_${'${product.code}'}" class="view" data-id="${'${product.code}'}">
					<td>${'${product.code}'}</td>
					<td>${'${product.name}'}</td>
					<td>${'${product.company}'}</td>
					<td>${'${product.price}'}</td>
					<td>${'${product.description}'}</td>
					<td>${'${product.fileName}'}</td>
					<td>${'${product.fileSize}'}</td>
					</tr>
				`;
				$("#plist").append(str);
			});
		}
</script>
<style>
	#info {
		width:800px;
	}
	label{
		display: inline-block;
		width: 80px;
	}
	textarea {
	width: 100%;
}
</style>
</head>
<body>
	<div class="container" style="height:650px">
		<h2><a href="${root}/">상품 목록</a></h2>
		<div>
			<form name="pageform" id="pageform" action="">
				<input type="hidden" name="pg" id="pg" value="">
				<input type="hidden" name="spp" id="spp" value="10">
				<input type="hidden" name="key" id="key" value="">
				<input type="hidden" name="word" id="word" value="">
			</form>
	
			<form class="form-inline" action="">
				<input type="hidden" name="pg" id="spg" value="1">
				<input type="hidden" name="spp" id="sspp" value="10">
				<div class="form-group md">
					<label for="key">검색 컬럼: </label>
					<select name="key"
						id="skey">
						<option value="code">상품번호</option>
						<option value="name">상품명</option>
						<option value="company" selected>제조회사</option>
						<option value="price">가격</option>
					</select>
				</div>
				<div class="form-group md-1">
					<label for="word">검색어: </label>
					<input type="text" name="word" id="sword">
				</div>
				<div style="margin: 5px;">
					<input type="button" value="검색" id="searchBtn">
				</div>
			</form>
		</div>
		
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>상품번호</th>
					<th>상품명</th>
					<th>제조회사</th>
					<th>가격</th>
					<th>설명</th>
					<th>파일명</th>
					<th>byte</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody id="plist"></tbody>
		</table>
	</div>
	
	<div id="pageNav"></div>
	<%@ include file="/WEB-INF/views/include/paging.jsp"%>
	
	<div class="container">
		<div>
			<span><input type="button" value="추가" id="insertBtn"></span>
			<span><input type="button" value="수정" id="updateBtn"></span>
			<span><input type="button" value="삭제" id="deleteBtn"></span>
		</div>
		<div>
			<form action="" enctype="multipart/form-data">
				<fieldset id="info">
				<legend>상품 정보</legend>
				<label for="code">상품번호</label>
				<input type="text" id="code" name="code" value="" readonly="readonly"><br>
				<label for="name">상품명</label>
				<input type="text" id="name" name="name" value=""><br>
				<label for="company">제조회사</label>
				<input type="text" id="company" name="company" value=""><br>
				<label for="price">가격</label>
				<input type="number" id="price" name="price" value=""><br>
				<label for="desc">설명</label>
				<br>
				<textarea id="description" name="description"></textarea><br>
				<label for="attach">첨부파일</label><input type="file" id="attach" name="attach">
				</fieldset>
			</form>
		</div>
	</div>
	
	<script type="text/javascript">
		let msg = "${msg}";
		if (msg) {
			alert(msg);
		}
	</script>
</body>
</html>