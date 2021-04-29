package com.ssafy.guestbook.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before(value = "execution(* com.ssafy.guestbook.model..*.*(..))")
	//@Before(value = "execution(* com.ssafy.guestbook.model..*Dao.*Article(..))")
	// 이렇게하면 클래스 이름이 Dao로 끝나는 클래스 중에서  메소드의 이름이 무슨무슨 Article이라는 메소드일때만 호출. 
	public void loggin(JoinPoint jp) {
		logger.debug("메서드 선언부 : {} 전달 파라미터 : {}", jp.getSignature(), Arrays.toString(jp.getArgs()));
	}
	
}
