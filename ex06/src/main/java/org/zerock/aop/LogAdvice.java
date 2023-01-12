package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component
public class LogAdvice {
	// 정규 표현식 
	// 로그 기능을 사용하기 위한 클래스  ( 패키지경로.클래스이름.모든 클래스.모든메소드. 매개변수의 개수 상관없이 ) 
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("==================================");
	}
	
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String,String)) && args(str1 , str2)")
	public void logBeforeWithParam(String str1 , String str2) {
		log.info("str 1 : " + str1);
		log.info("str 2 : " + str2);
	}
	
	//예외 처리 부분 
	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))" , throwing="exception")
	public void logException(Exception exception) {
		log.info("Exception....!!!!");
		log.info("exception : " + exception );
	}
	
	// 메소드가 동작하기 전과 후 모두 작동
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		
		// 메소드 호출 전의 실행 문 
		long start = System.currentTimeMillis()	;
		
		log.info("Target : " + pjp.getTarget());
		log.info("Param : " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result = pjp.proceed(); 
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		// 메소드 호출  후의 실행 문 
		
		long end = System.currentTimeMillis();
		
		log.info("TIME : " + (end - start));
		
		return result;
	}
	@After("execution(* org.zerock.service.SampleService*.*(..))")
	public void logAfter() {
		log.info("==================================");
	}
	
}
