package com.test.mybatisprotest.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Aspect
@Component
public class UserAspect {
    @Pointcut("execution(* com.test.mybatisprotest.mapper.UserMapper.*(..))")
    public void PointCutByUser() {}

    @Around(value = "PointCutByUser()")
    public Object takeUpTimeByUser(ProceedingJoinPoint joinPoint) throws Throwable {
        return handleJoinPoint(joinPoint, "UserMapper");
    }

    private Object handleJoinPoint(ProceedingJoinPoint joinPoint, String label) throws Throwable {
        final String methodName = joinPoint.getSignature().getName(); // 获取方法名

        log.info("Start running {} {}", label, methodName);

        long startTime = new Date().getTime();
        final Object proceedReturn = joinPoint.proceed();
        long endTime = new Date().getTime();

        log.info("{} {} use time {}s", label, methodName, ((double)endTime - startTime) / 1000);
        return proceedReturn;
    }
}
