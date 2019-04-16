package cn.gyj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.gyj.exception.GlobalExceptionHandler;

@Aspect
@Component
public class ExceptionAop {

	@Autowired
	private GlobalExceptionHandler globalExceptionHandler;
	
	@Pointcut("execution(public * cn.gyj.controller..*.*(..))")
	public void log() {}
	
	@Around("log()")
	public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		try {
			
		}catch(Exception e) {
			return globalExceptionHandler.handleException(e);
		}
		return proceedingJoinPoint.proceed();
	}	
}
