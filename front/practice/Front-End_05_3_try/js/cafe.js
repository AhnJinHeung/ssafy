$(document).ready(function () {
        // localStorage에서 poll이름의 data 얻기.
        var poll = localStorage.getItem('poll');

        if (poll) {
          // localStorage에서 얻은 문자열을 JSON객체로 변환.
          var vote = JSON.parse(poll);
          var sdate = vote.start_date; // 시작일.
          var edate = vote.end_date; // 종료일.
          var question = vote.question; // 질문.
          var answers = vote.answers; // 답변항목.
          // 투표 화면 구성.
          var pollContent = `
            <div class="vote_title">[ 당신의 선택 ]</div>
            <div class="vote_question">${question}</div>
              <div class="vote_answer">
                <ul>`;
          $.each(answers, function (i, item) {
            pollContent += `
                  <li>
                    <label>
                      <input type="radio" name="vote_answer" value="${item}" /> ${item}
                    </label>
                  </li >`;
          });
          pollContent += `
                </ul>
              </div>
              <div class="vote_button">
                <button id="btn-polling" class="button btn_primary">투표하기</button>
                <button class="button">결과보기</button>
              </div>
              <div class="vote_date">투표기간 : ${dateFormat(sdate)} ~ ${dateFormat(edate)}</div>`;
          // 투표 화면에 투표양식 추가.
          $('#vote').html(pollContent);
        } else {
          // 진행중인 투표가 없을 경우 화면 추가.
          $('#vote').html('<div class="vote_title">진행중인 투표가 없습니다.</div>');
        }

        // 로그인
        $('#btn-login').click(function () {
          // 사용자 정보를 입력받는다.
          var userid = prompt('아이디입력', 'ssafy');
          if (userid.length == 0) {
            alert('아이디 입력!!!');
            return;
          }
          var userpass = prompt('비밀번호입력', '1234');
          if (userpass.length == 0) {
            alert('비밀번호 입력!!!');
            return;
          }
          if (userid == 'ssafy' && userpass == '1234') {
            alert('로그인 성공!!!');
            // id가 profile_img인 element의 src 속성의 값을 img/profile.png로 설정.
            $('#profile_img').attr('src', 'img/profile.png');
            $('#header_nav_confirm_off').css('display', 'none');
            $('#header_nav_confirm_on').css('display', 'block');
          } else {
            alert('아이디 또는 비밀번호 확인!!!');
          }
        });

        // 로그아웃
        $('#btn-logout').click(function () {
          // id가 profile_img인 element의 src 속성의 값을 img/noimg.png로 설정.
          $('#profile_img').attr('src', 'img/noimg.png');
          $('#header_nav_confirm_off').css('display', 'block');
          $('#header_nav_confirm_on').css('display', 'none');
        });

        //전국매장
        var storeView = true;
        $('#store_display').click(function () {
          if (storeView) {
            $('.store_item_sub').slideDown(300);
            $('#store_display').text('전국매장접기');
            storeView = false;
          } else {
            $('.store_item_sub').slideUp(600);
            $('#store_display').text('전국매장펼치기');
            storeView = true;
          }
        });

        //지역매장
        $('.store_area').click(function () {
          $(this)
            .siblings('div.store_item_sub')
            .slideDown(300)
            .parent()
            .siblings('li')
            .children('div.store_item_sub')
            .slideUp(500);
        });

        //프로그래밍메뉴 3초간격 이동
        setInterval(function () {
          $('.program_menu_li').first().appendTo('.program_menu_ul');
        }, 3000);

        // 투표 마들기
        $('#btn-admin').click(function () {
          // pollmake.html의 창아이디를 poll로 설정하고 가로 500, 세로 300인 창을 열기.
          window.open('pollmake.html', 'poll', 'width=500,height=300,top=300,left=400');
        });

        $('#btn-polling').click(function () {
          var sel_menu = $("input[name='vote_answer']:checked").val();
          alert(sel_menu + '를 선택했습니다.');
        });
        
        $.ajax({
        	url: 'programming.xml',
        	type: 'GET',
        	dataType: 'xml',
        	success: function (response) {
        		xmlList(response);
        	}
        });
        
        $.ajax({
        	url: 'essay.json',
        	type: 'GET',
        	dataType: 'json',
        	success: function (response) {
        		jsonList(response);
        	}
        });
      });

	  function xmlList(data) {
		let list = '';
		$(data).find('book').each(function (index, item) {
			list += `
			<li class="program_menu_li">
              <div class="menu_item">
			    <div class="menu_item_img">
			      <img src="img/book/${$(this).find('isbn').text()}.png" alt="" />
			    </div>
			    <div class="menu_item_info">
			      ${$(this).find('title').text()}<br/>(${$(this).find('price').text()})
			    </div>
			  </div>
            </li>
			`;
		});
		$('.program_menu_ul').empty().append(list);
	  }
	  
	  function jsonList(data) {
		  let list = '';
		  $.each(data, function (index, item) {
			  list += `
				<li>
	              <div class="menu_item">
	                <div class="menu_item_img">
	                  <img src="img/book/${item["isbn"]}.png" alt="" />
	                </div>
	                <div class="menu_item_info">${item["title"]}<br />(${item["price"]}원)</div>
	              </div>
	            </li>
			  `;
		  });
		  $('.essay_menu_ul').empty().append(list);
	  }
	  
      // 투표 시작일과 종료일 날짜 형식. (yy.mm.dd)
      function dateFormat(date) {
        var yymmdd = date.split('-');
        return yymmdd[0].substr(2, 2) + '.' + yymmdd[1] + '.' + yymmdd[2];
      }