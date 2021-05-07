<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Happy House | Find Password</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <link rel="stylesheet" href ="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {
	      form.addEventListener('submit', function(event) {
	        if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	        }
	        else check_pwd();
	        form.classList.add('was-validated');
	      }, false);
	    });
	});
	
	function check_pwd() {
		$.ajax({
	    	url: 'userlist.xml',
	    	type: 'GET',
	    	dataType: 'xml',
	    	success: function (response) {
	    		var check = true;
	    		var uid = $('#uid').val();
	    		var uname = $('#uname').val();
	    		var upass;
	    		console.log(uid);
	    		$(response).find('user').each(function (index, item) {
	    			console.log($(this).find('uid').text());
	    			console.log($(this).find('uname').text());
	    			if (uid === $(this).find('uid').text() && uname === $(this).find('uname').text()) {
	    				upass = $(this).find('upass').text();
	    				check = false;
	    				return false;
	    			}
	    		});
	    		if (!check) {
	    			alert("비밀번호는 : "+upass+"입니다.");
	    		}
	    		else alert("해당 아이디나 이름은 존재하지 않습니다.ㅇ");
	    	}
	    });
	}
	</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
   <section>
   	 <div class="container pt-5">
	      <div class="container" align="center">
	        <h2>비밀번호 찾기</h2>	       
	      </div>

	       <div class="container">
	       	<form class="needs-validation p-3 my-3" novalidate>
			  <div class="form-group p-2 m-3">
			    <label for="uid">UserID:</label>
			    <input type="text" class="form-control" id="uid" placeholder="Enter UserID" name="uid" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>			  
			  <div class="form-group p-2 m-3">
			    <label for="uname">UserName:</label>
			    <input type="text" class="form-control" id="uname" placeholder="Enter UserName" name="uname" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>			  
			  <div class="form-group p-2 m-3">
			    <label for="mail">E-mail:</label>
			    <input type="text" class="form-control" id="mail" placeholder="Enter E-mail" name="mail" required>
			    <div class="valid-feedback">Valid.</div>
			    <div class="invalid-feedback">Please fill out this field.</div>
			  </div>
			  <div class="row justify-content-center">
			  <button type="submit" class="find-btn btn btn-primary mx-3">찾기</button>
			  </div>
			</form>
			</div>
	  </div>
   </section>
   <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    <!-- 하단 Footer End  -->
</body>
</html>