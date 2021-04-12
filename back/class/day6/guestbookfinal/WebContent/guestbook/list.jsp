<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test="${userinfo == null}">
	<c:redirect url="/main.do"/>
</c:if>
<c:if test="${userinfo != null}">
<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>SSAFY-글목록</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			var key = "<c:out value='${key}'/>";
		    $.each($('.opt'),function(index, item){
		        if(item.value == key) $(item).attr("selected", "selected");
		        
		    })
		});
		
		function movewrite() {
			location.href="${root}/main.do?act=mvwrite";
		}
		function searchArticle() {
			if(document.getElementById("sword").value == "") {
				alert("모든 목록 조회!!");
			} else {
				if(document.getElementById("skey").value == "") {
					alert("검색 조건을 선택!!");
					return;
				}
			}
			document.getElementById("searchform").action = "${root}/main.do";
			document.getElementById("searchform").submit();
		}
		function firstPageMove() {
			document.getElementById("act").value = "list";
			document.getElementById("pg").value = 1;
			document.getElementById("key").value = "";
			document.getElementById("word").value = "";			
			document.getElementById("pageform").action = "${root}/main.do";
			document.getElementById("pageform").submit();
		}
		function pageMove(pg) {
//			location.href = "${root}/main.do?act=list&pg=" + pg + "&key=" + ${key} + "&word=" + ${word}; // word 때문에 x 한글 깨짐
			document.getElementById("act").value = "list";
			document.getElementById("pg").value = pg;
			document.getElementById("pageform").action = "${root}/main.do";
			document.getElementById("pageform").submit();
		}
		function deleteArticle(ano) {
			document.getElementById("act").value = "delete";
			document.getElementById("pg").value = "<c:out value='${pg}'/>";
			document.getElementById("articleno").value = ano;
			document.getElementById("pageform").action = "${root}/main.do";
			document.getElementById("pageform").submit();
		}
		</script>
	</head>
	<body>	
	<form id="pageform">
		<input type="hidden" name="act" id="act" value="">
		<input type="hidden" name="pg" id="pg" value="">
		<input type="hidden" name="key" id="key" value="${key}">
		<input type="hidden" name="word" id="word" value="${word}">
		<input type="hidden" name="articleno" id="articleno" value="">
	</form>
	<div class="container" align="center">
		<div class="col-lg-8" align="right">
		<strong>${userinfo.username}</strong>님 환영합니다.
		<a href="${root}/main.do?act=logout">로그아웃</a>
		</div>
	  <div class="col-lg-8" align="center">
	  <h2>글목록</h2>
	  <p>좋은글 많이 올려 주세요!!!!!</p>  
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right"><button type="button" class="btn btn-link" onclick="javascript:movewrite();">글쓰기</button></td>
	  	</tr>
	  </table>
	  <form id="searchform" method="get" class="form-inline" action="">
	  <input type="hidden" name="act" id="act" value="list">
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
		  	  <select class="form-control" name="key" id="skey">
		  	  	<option class="opt" value="" selected="selected">선택</option>
			    <option class="opt" value="userid">아이디</option>
			    <option class="opt" value="articleno">글번호</option>
			    <option class="opt" value="subject">제목</option>
			  </select>
			  <input type="text" class="form-control" placeholder="검색어 입력." name="word" id="sword" value="${word}">
			  <button type="button" class="btn btn-primary" onclick="javascript:searchArticle();">검색</button>
			</td>
	  	</tr>
	  </table>
	  </form>
	  <c:if test="${articles.size() != 0}">
	  	<c:forEach var="article" items="${articles}">
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info">
	        <td>작성자 : ${article.userid}</td>
	        <td align="right">작성일 : ${article.regtime}</td>
	      </tr>
	      <tr>
	        <td colspan="2" class="table-danger"><strong>${article.articleno}. ${article.subject}</strong></td>
	      </tr>
	      <tr>
	        <td colspan="2">${article.content}</td>
	      </tr>
	      <c:if test="${userinfo.userid == article.userid}">
	      <tr>
	        <td colspan="2">
			<a href="${root}/main.do?act=mvmodify&articleno=${article.articleno}">수정</a>
			<a href="javascript:deleteArticle(${article.articleno});">삭제</a>
			</td>
	      </tr>
	      </c:if>
	    </tbody>
	  </table>
	  	</c:forEach>
	  	${navigator.navigator}
	  </c:if>
	  <c:if test="${articles.size() == 0}">
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info" align="center">
	        <td>작성된 글이 없습니다.</td>
	      </tr>
	    </tbody>
	  </table>
	  </c:if>
	  </div>
	</div>
	</body>
</html>
</c:if>


