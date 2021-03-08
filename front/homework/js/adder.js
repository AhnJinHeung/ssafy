// 빽틱, 제이쿼리 연습
var list = [
	['7', '8', '9', '+'], 
	['4', '5', '6', '-'],
	['1', '2', '3', '*'],
	['0', 'CE', '=', '/']
];
var cnt = 1;
var result = 0;
var num1 = "";
var num2 = "";
var op = "";

$(document).ready(function() {
	var table = $('#buttons');
	
	var content = "";
	for (let i=0; i<4; i++) {
		content += `<tr>`;
		for (let j=0; j<4; j++) {
			content += `
				<td><button id='${list[i][j]}' onClick='inputData(${i}, ${j})'>${list[i][j]}</button></td>
			`;
		}
		content += `</tr>`;
	}
	
	table.html(content);
});

function inputData(i, j) {
	let char = list[i][j];
	
	if (char == '=') {
		console.log(num1, num2);
		switch(op) {
		case '*': result = parseInt(num1) * parseInt(num2); break;
		case '+': result = parseInt(num1) + parseInt(num2); break;
		case '-': result = parseInt(num1) - parseInt(num2); break;
		case '/': result = parseInt(num1) / parseInt(num2); break;
		}
		console.log(result);
		
		var html = $('input').attr('value');
		var results = $('#results');
		
		var content = results.html();
		content += `
			<div class='res'>${cnt}. ${html}=${result}</div>
		`;
		
		results.html(content);
		$('input').attr('value', "");
		result = 0;
		num1 = "";
		num2 = "";
		op = "";
		cnt++;
	}
	else if (char == 'CE') {
		$('input').attr('value', "");
		result = 0;
		num1 = "";
		num2 = "";
		op = "";
	}
	else {
		let input = $('input');
		let text = "";
		let add = input.attr('value');
		if (add != undefined) text += add;
		input.attr('value', text+char);
		
		if (j == 3) op = char;
		else {
			if (op == "") num1 += char;
			else num2 += char;
		}
	}
}

