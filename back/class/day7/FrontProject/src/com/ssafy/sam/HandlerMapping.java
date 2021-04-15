package com.ssafy.sam;

import java.util.HashMap;

public class HandlerMapping {
	static HashMap<String, Controller> map = new HashMap<>();
	static {
		map.put("/hello.do", new HelloController());
		map.put("/login.do", new LogInController());
//		map.put("/memberInsert.do", MeberInsertController);
//		map.put("/hello.do", helloController);
	}
	public static Controller getMapping(String path) {
		
		return map.get(path);
	}
}
