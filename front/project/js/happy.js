$(document).ready(function (){
    	$('.btn-login').click(function () {
    		check_login($('#login_id').val(), $('#login_pw').val());
    	});
    	
	    var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {
	      form.addEventListener('submit', function(event) {
	        if (form.checkValidity() === false) {
	          event.preventDefault();
	          event.stopPropagation();
	        }
	        else check_join();
	        form.classList.add('was-validated');
	      }, false);
	    });
   

	    $.ajax({
			 url: 'AptDealHistory.xml',
		      type: 'POST',
		      dataType: 'xml',
	    	success: function (response) {

		          
		          $(response).find('item').each(function () {
							var aptInfo ='';
							aptInfo = '<tr class="table_item">';
							aptInfo += '<td><h5><a class="item_aptname">'+$(this).find("아파트").text()+'</h5></a></td>';
							aptInfo += '<td>거래금액 : '+$(this).find("거래금액").text()+'</td>';
							aptInfo += '<td>전용면적 :'+$(this).find("전용면적").text()+'</td></tr>';
							$('#table_body').append(aptInfo);
						//}
		          });
	    	},
			error:function(xhr,status,msg){
			 console.log("상태값: "+status+" Http에러메세지 : " + msg);
			 }
	    });
	$('.btn-search').click(function() {
		if($('#city').val() ==='서울특별시' && $('#gu').val()==='11110'){
			location.href='apart.html';
			console.log('gg');
		
		}
	});
});	
function check_join() {
	$.ajax({
    	url: 'userlist.xml',
    	type: 'GET',
    	dataType: 'xml',
    	success: function (response) {
    		var check = true;
    		var uid = $('#uid').val();
    		console.log(uid);
    		$(response).find('user').each(function (index, item) {
    			console.log($(this).find('uid').text());
    			if (uid == $(this).find('uid').text()) {
    				check = false;
    				return false;
    			}
    		});
    		if (check) {
    			alert("회원가입이 되었습니다.");
    			location.href = "main.html";
    		}
    		else alert("아이디가 중복되었습니다.");
    	}
    });
}

function check_login(uid, upw) {
	$.ajax({
    	url: 'userlist.xml',
    	type: 'POST',
    	dataType: 'xml',
    	success: function (response) {
    		var check = true;
    		console.log(uid);
    		$(response).find('user').each(function (index, item) {
    			console.log($(this).find('uid').text());
    			if (uid == $(this).find('uid').text()) {
    				check = false;
    				return false;
    			}
    		});
    		if (check) alert("로그인 계정이 없습니다.");
    		else {
    			$('.before').css('display', 'none');
    	        $('.after').css('display', '');
    	        $('.nav-uid').text(uid);
    	        $('#info_id').val(uid);
    	        $('#info_pw').val(upw);
    		}
    	}
    });
	
}