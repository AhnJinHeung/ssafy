package com.ssafy.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssafy.web.test.SService;
import com.ssafy.web.test.SServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class STest {

	

	@Before
	public void memberinsertTest() {
		System.out.println("test a");
	}
	
	@Autowired
	SService service ;
	
	@Test
	public void memberinsertTestb() {
		String result = service.doPro();
		
		System.out.println(result);

	}
	
	@After
	public void memberinsertTestc() {
		System.out.println("test c");
	}
}
