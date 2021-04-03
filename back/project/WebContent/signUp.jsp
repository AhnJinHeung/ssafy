<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Happy House</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href ="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="./js/happy.js" type="text/javascript"></script>
</head>
<script>
</script>
<body>
    <%@ include file="/include/header.jsp"%>
   <section>
	  <div class="container pt-5">
	      <div class="container" align="center">
	        <h2>회원 가입</h2>	       
	      </div>

	       <div class="container">
	       	<form class="needs-validation p-3 my-3" id="registerform" method="post" action="" novalidate>
	       	  <input type="hidden" name="act" id="act" value="register">
			  <div class="form-group p-2 m-3">
			    <label for="uid">UserID:</label>
			    <input type="text" class="form-control" id="uid" placeholder="Enter UserID" name="userid" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>
			  <div class="form-group p-2 m-3">
			    <label for="pwd">Password:</label>
			    <input type="password" class="form-control" id="pwd" placeholder="Enter Password" name="userpwd" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>
			  <div class="form-group p-2 m-3">
			    <label for="uname">UserName:</label>
			    <input type="text" class="form-control" id="uname" placeholder="Enter UserName" name="username" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>
			  <div class="form-group p-2 m-3">
			    <label for="mail">E-mail:</label>
			    <input type="text" class="form-control" id="mail" placeholder="Enter E-mail" name="email" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>
			  <div class="form-group p-2 m-3">
			    <label for="address">Address:</label>
			    <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>
			  <div class="row justify-content-center">
			  <button type="button" class="btn btn-primary mx-3" onclick="javascript:join();">Submit</button>
			  <button type="reset" class="btn btn-danger mx-3">Reset</button>
			  </div>
			</form>
			</div>
	  </div>
	</section>
	    <!-- 하단 Footer Start  -->
   <footer class="navbar navbar-expand-md justify-content-center bg-light align-bottom">
      <div class="row">
      	<h5 class="nav-link text-secondary">Find Us</h5>
        <div class="col-md-12">
          <ul class="navbar-nav">
            <li><label class="nav-link text-secondary">(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어</label></li>
            <li><label class="nav-link text-secondary">1544-9001</label></li>
            <li><a class="nav-link text-secondary" href="#">admin@ssafy.com</a></li>
          </ul>
        </div>
        <label class="nav-link text-secondary">Copyright by SSAFY. All rights reserved.</label>
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
		    <label for="uid">아이디:</label>
		    <input type="text" class="form-control" placeholder="Enter id" id="login_id">
		  </div>
		  <div class="form-group">
		    <label for="pwd">비밀번호:</label>
		    <input type="password" class="form-control" placeholder="Enter password" id="login_pw">
		  </div>
		  <button class="btn btn-primary btn-login" data-dismiss="modal">로그인</button>
		  <a style="color : black;" href="pwd.html"><i class="fa fa-key" aria-hidden="true"></i>비밀번호를 잊으셨나요?</a>
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
		    <label for="uid">아이디:</label>
		    <input type="text" id="info_id" class="form-control" placeholder="Enter id" value="">
		  </div>
		  <div class="form-group">
		    <label for="pwd">비밀번호:</label>
		    <input type="text" id="info_pw" class="form-control" placeholder="Enter password" value="">
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