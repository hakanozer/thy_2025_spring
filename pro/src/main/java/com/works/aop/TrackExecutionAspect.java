package com.works.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackExecutionAspect {

    @Around("@annotation(trackExecution)")
    public Object trackExecution(ProceedingJoinPoint joinPoint, TrackExecution trackExecution) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("TrackExecutionAspect.trackExecution start: " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed(); // Method tetiklenmesi
        System.out.println("Result : " + result);
        long end = System.currentTimeMillis();
        long executionTime = end - start;
        System.out.println("Execution time: " + executionTime + " ms");
        return result;
    }

}
