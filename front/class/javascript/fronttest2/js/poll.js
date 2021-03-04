window.onload = function() {
	document.querySelector('#btn-add').addEventListener('click', function() {
		var listDiv = document.querySelector('#poll-answer-list');
		
		var divEl = document.createElement('div'); // <div></div>
		divEl.setAttribute('class', 'poll-answer-item'); // <div class='poll-answer-item'>
		
		var inputEl = document.createElement('input');
		inputEl.setAttribute('type', 'text');
		inputEl.setAttribute('name', 'answer');
		
		var buttonEl = document.createElement('button');
		buttonEl.setAttribute('class', 'button');
		buttonEl.addEventListener('click', function() {
			var parent = this.parentNode;
			listDiv.removeChild(parent);
		});
		buttonEl.appendChild(document.createTextNode('제거'));
		
		divEl.appendChild(inputEl);
		divEl.appendChild(buttonEl);
		
		listDiv.appendChild(divEl);
	});
}