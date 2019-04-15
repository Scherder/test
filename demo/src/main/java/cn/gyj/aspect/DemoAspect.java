package cn.gyj.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

	@Pointcut("execution(public * cn.gyj.controller.DemoController.*(..)) || execution(public * cn.gyj.controller.TestController.*(..))")
	public void log() {}
	
	@Before("log()")
	public void beforeLog() {
		System.out.println("aop beforeLog()");
	}
	
	@After("log()")
	public void afterLog() {
		System.out.println("aop afterLog()");
	}
	
	@AfterReturning("log()")
	public void afterReturningLog() {
		System.out.println("aop afterReturningLog()");
	}
	
	
}
