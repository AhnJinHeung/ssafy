$(document).ready(function() {
	let numbers = new Array(46);
	let cnt = 0;
	let time;
	
	let table = $('#table');
	
	time = setInterval(toDo, 1000);
	
	function toDo() {
		let num = Math.floor(Math.random()*45) + 1;
		while (numbers[num] != undefined)  num = Math.floor(Math.random()*45) + 1;
		numbers[num] = true;
		console.log(num);
		
		let ball = `<div class="ball">${num}</div>`;
		table.html(table.html()+ball);
		
		cnt++;
		if (cnt == 6) clearInterval(time);
	}
});