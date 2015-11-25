package com.hybrid.aspect;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
// @aspect 가 aspect 클래스임을 명시
public class LogDaoAspect {

//	static Log log = LogFactory.getLog(LogDaoAspect.class);
	
	@Pointcut("execution(public * com.hybrid.dao.*Dao.*(..))")
	/*	excution(함수)  ( public >> public 인것 모두 
	 * >>  리턴타입 (* 모두)
	 com.hybrid.dao.*Dao.*(..)  >>  com.hybrid.dao 에있는
	 								Dao 로 끝나는 모든거 에있는
	 								모든 메소드에
	 								모든 파라미터*/
	public void dao(){
		
	}
	
	@Pointcut("execution(public * com.hybrid.dao.*Service.*(..))")
	public void service(){
		
	}
	
	@Before("dao() || service()")
//	마찬가지로 @before 를 해줘야지 before 메소드가 된다. 

	public void before(JoinPoint jp){
		// 위버가  joinpoint라는 객체를 넘겨준다.
		Log log = LogFactory.getLog(jp.getTarget().getClass());
		log.info("###" + jp.getSignature().getName()
					   + Arrays.toString(jp.getArgs())
					   + " START ");
	}
	
	@After("dao() || service()")
	public void after(JoinPoint jp){
		
		Log log = LogFactory.getLog(jp.getTarget().getClass());
		log.info("###" + jp.getSignature().getName()
				  	   + Arrays.toString(jp.getArgs())
				  	   + " END ");
	}
	
	
	
}
