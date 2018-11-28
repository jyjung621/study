package com.oracle.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		// 시행될 핵심관심사 이름
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + " is start.");

		long st = System.currentTimeMillis();

		try {
			// 핵심관심사 실행 [Proxy]
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println(signatureStr + " is finished.");
			System.out.println(signatureStr + " 경과시간 : " + (et - st));
		}
	}

	public void beforeAdvice(JoinPoint joinPoin) {
		System.out.println("beforeAdvice()");
	}

	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}

	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}

	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
}
