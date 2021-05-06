package com.ssafy.guestbook.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before(value = "execution(* com.ssafy.guestbook.model..GuestBook*.*(..))")
	public void loggin(JoinPoint joinPoint) {
		logger.debug("메서드 선언부 : {} 전달 파라미터 : {}", joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
	}

	// weaving 위빙
	@Around(value = "execution(* com.ssafy.guestbook.model..GuestBook*.list*(..))") // pointcut
	public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object proceed = joinPoint.proceed(); // 실제적인 메소드 구현(핵심업무)
		
		stopWatch.stop();
		
		logger.debug("summary : {}", stopWatch.shortSummary());
		logger.debug("totalTime : {}", stopWatch.getTotalTimeMillis());
		logger.debug("pretty : {}", stopWatch.prettyPrint());
		
		return proceed;
	}

	// 정상적으로 실행됐을 경우
	@AfterReturning(value = "execution(* com.ssafy.guestbook.model..GuestBook*.list*(..))", returning = "obj")
	public void afterReturningMethod(JoinPoint joinPoint, Object obj) {
		logger.debug("afterReturning call method : {} ", joinPoint.getSignature());
		logger.debug("return value : {}", obj);
	}

	// 에러가 났을 경우
	@AfterThrowing(value = "execution(* com.ssafy.guestbook.model..GuestBook*.list*(..))", throwing = "exception")
	public void afterThrowingMethod(JoinPoint joinPoint, Exception exception) {
		logger.debug("afterThrowing call method : {}", joinPoint.getSignature());
		logger.debug("exception : {}", exception);
	}

	// 무조건 실행
	@After(value = "execution(* com.ssafy.guestbook.model..GuestBook*.list*(..))")
	public void afterMethod(JoinPoint joinPoint) {
		logger.debug("after call method : {}", joinPoint.getSignature());
	}

}
