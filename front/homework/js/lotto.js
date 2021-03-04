window.onload = function() {
	let numbers = new Array(46);
	let cnt = 0;
	let time;
	
	let table = document.querySelector('#table');
	
	time = setInterval(toDo, 1000);
	
	function toDo() {
		let num = Math.floor(Math.random()*45) + 1;
		while (numbers[num] != undefined)  num = Math.floor(Math.random()*45) + 1;
		numbers[num] = true;
		console.log(num);
		
		let ball = document.createElement('div');
		ball.setAttribute('class', 'ball');
		ball.innerHTML = num;
		
		table.appendChild(ball);
		
		cnt++;
		if (cnt == 6) clearInterval(time);
	}
}