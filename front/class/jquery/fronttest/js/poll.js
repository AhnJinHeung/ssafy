$(document).ready(function() {
	$('#btn-add').click(function() {
		var div = $('<div class="poll-answer-item">')
			.append('<input type="text" name="answer">')
			.append('<button type="button" class="button btn-remove">삭제</button>');
		$('#poll-answer-list').append(div);
	});
	
	$(document).on('click', '.button.btn-remove', function() {
		$(this).parent('.poll-answer-item').remove();
	});
	
	$('#btn-make').click(function() {
		if (!$('#question').val()) {
			alert('질문 내용 입력!!');
			return;
		}
		
		var flag = true;
		$('input[name=answer]').each(function(index, item){
			if (!$(this).val()) {
				alert('답변 항목 입력!!');
				flag = false;
			}
		});
		
		if (flag) {
			var answerArr = [];
			$('input[name=answer]').each(function(index, item){
				answerArr.push($(this).val());
			});
			
			localStorage.setItem('question', $('#question').val());
			localStorage.setItem('answers', JSON.stringify(answerArr));
			
			alert('투표를 생성합니다.');
			opener.location.reload();
			self.close();
		}
	});
});