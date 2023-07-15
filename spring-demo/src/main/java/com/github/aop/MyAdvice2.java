package com.github.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author hewenji
 * @Date 2023/5/29 17:14
 */
@Component
@Aspect
public class MyAdvice2 {

    @Pointcut("execution(public int com.github.dao.BookDao.getRandomNumber())")
    private void pt(){
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("AOP============ before  getRandomNumber");
        Object res = pjp.proceed();
        System.out.println("AOP============ after  getRandomNumber");
        return res;
    }

    @AfterReturning("pt()")
    public void afterReturn() {
        // 正常返回才能线程
        System.out.println("after return");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        // 正常返回才能线程
        System.out.println("after throw");
    }

}
