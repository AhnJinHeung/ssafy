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
    <%@ include file="/WEB-INF/views/include/header.jsp"%>
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
			    <input type="text" class="form-control" id="uid" placeholder="Enter UserID" name="userId" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>
			  <div class="form-group p-2 m-3">
			    <label for="pwd">Password:</label>
			    <input type="password" class="form-control" id="pwd" placeholder="Enter Password" name="userPwd" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>
			  <div class="form-group p-2 m-3">
			    <label for="uname">UserName:</label>
			    <input type="text" class="form-control" id="uname" placeholder="Enter UserName" name="userName" required>
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
   <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    <!-- 하단 Footer End  -->
</body>
</html>