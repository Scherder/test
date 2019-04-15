package cn.gyj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.gyj.exception.ExceptionHandle;
import cn.gyj.model.Result;

@Aspect
@Component
public class ExceptionAop {

	@Autowired
	private ExceptionHandle exceptionHandle;
	
	@Pointcut("execution(public * cn.gyj.controller..*.*(..))")
	public void log() {}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@Around("log()")
	public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		Result result = null;
		try {
			
		}catch(Exception e) {
			return exceptionHandle.exceptionGet(e);
		}
		if(result == null) {
			return proceedingJoinPoint.proceed();
		}else{
			return result;
		}
	}
}
