package com.ssafy.web;

import com.ssafy.web.test.SService;
import com.ssafy.web.test.SServiceImpl;

public class SMain {

//	단위 테스트 ==> 라이브러리
	public static void main(String[] args) {
		SService service = new SServiceImpl();
		String result = service.doPro();
		System.out.println(result);

	}

}
