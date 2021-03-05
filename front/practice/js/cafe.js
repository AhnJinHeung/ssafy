window.onload = function () {
	var login = document.getElementById('login_btn');
	
	login.addEventListener('click', function (e) {
		var id = prompt('아이디 입력');
		var pass = prompt('비밀번호 입력');
		
		if (id == 'ssafy' && pass == '1234') {
			alert('로그인 성공!!!');
			
			var nav1 = document.getElementById('login_nav');
			var nav2 = document.getElementById('logout_nav');
			nav1.style.display = 'none';
			nav2.style.display = '';
			
			var img1 = document.getElementById('login_img');
			var img2 = document.getElementById('logout_img');
			img1.style.display = 'none';
			img2.style.display = '';
			
			return;
		}
		alert('로그인 실패...');
	});
	
	var store_open = document.getElementById('store_open');
	var store_close = document.getElementById('store_close');
	
	store_open.addEventListener('click', function (e) {
		store_open.style.display = 'none';
		store_close.style.display = '';
		
		var areas = document.getElementsByClassName('store_item_sub');
		for (var i=0; i<areas.length; i++) {
			areas[i].style.display = '';
		}
	});
	
	store_close.addEventListener('click', function (e) {
		store_close.style.display = 'none';
		store_open.style.display = '';
		
		var areas = document.getElementsByClassName('store_item_sub');
		for (var i=0; i<areas.length; i++) {
			areas[i].style.display = 'none';
		}
	});
	
	var store_areas = document.getElementsByClassName('store_area');
	
	for (var i=0; i<store_areas.length; i++) {
		store_areas[i].addEventListener('click', function (e) {
			/*var next = this.nextSibling; // 이건 #text 찍힘*/
			var next = this.nextElementSibling;
			/*console.log(next);*/
			if (next.style.display == 'none') next.style.display = '';
			else next.style.display = 'none';
		});
	}
	
	var manage = document.getElementById('manager');
	
	manage.addEventListener('click', function (e) {
		window.open('pollmake.html', 'poll', 'width=420,height=300,top=300,left=400');
	});
	
	function addAnswer() {
		
	}
	
	function makePoll() {
		
	}
}