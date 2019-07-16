package com.sivadas.anand.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	protected static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(final ProceedingJoinPoint joinPoint) throws Throwable {

		final long start = System.currentTimeMillis();
		final Object proceed = joinPoint.proceed();
		final long executionTime = System.currentTimeMillis() - start;
		LOGGER.info("{} executed in {}ms", joinPoint.getSignature(), executionTime);

		return proceed;
	}
}
