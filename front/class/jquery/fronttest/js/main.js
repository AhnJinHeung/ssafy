$(document).ready(function() {
	/*localStorage.clear();*/
	var question = localStorage.getItem('question');
	
	if (question) { // 질문이 있다면 == 투표가 있다면
	    var answers = localStorage.getItem('answers');
	    var answersArr = JSON.parse(answers);
	   
	    var poll = `
	        <div class="vote-title">[ 당신의 선택 ]</div>
	        <div class="vote-question">${question}</div>
	        <div class="vote-answer">
	          <ul>
	      `;
	    
	    $.each(answersArr, function(index, item){
	    	poll += `
	            <li>
	              <label><input type="radio" name="vote-answer" value="${item}" />${item}</label>
	            </li>
	        `;
	    });
	    
	    poll += `
	          </ul>
	        </div>
	        <div class="vote-button">
	          <button id="btn-poll" class="button btn-primary">투표하기</button>
	          <button class="button">결과보기</button>
	        </div>
	        <div class="vote-date">투표기간 : 20.09.01 ~ 20.09.30</div>
	      `;

	    $('.content-left-poll').html(poll);

	    $('.content-left-poll-btn').css('display', 'none');
	    $('.content-left-poll').css('display', '');
	  } else {
	    var poll = `진행중인 투표가 없습니다.`;
	    $('.content-left-poll').html(poll);

	    $('.content-left-poll-btn').css('display', '');
	    $('.content-left-poll').css('display', '');
	  }
	
	 $('#btn-makepoll').click(function(){
		 window.open('makepoll.html', 'poll', 'width=420,height=300,top=300,left=400');
	 });
	 
	 $('#btn-poll').click(function() {
		 var selMenu = $('input[name=vote-answer]:checked').val();
		 alert(selMenu + '를 선택했습니다.');
	 });
});