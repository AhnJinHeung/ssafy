window.onload = function() {
	var question = localStorage.getItem('question');
	var pollBtnDiv = document.getElementsByClassName('content-left-poll-btn')[0];
	var pollDiv = document.getElementsByClassName('content-left-poll')[0];
	
	if (question) {
		
	}
	else {
		var poll = '현재 진행중인 투표가 없습니다.';
		pollDiv.innerHTML = poll;
		
		pollBtnDiv.style.display = '';
		pollDiv.style.display = '';
	}
	
	document.getElementById('btn-makepoll').onclick = function() {
		window.open('makepoll.html', 'mp', 'width=400, height=300');
	}
}