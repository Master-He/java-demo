package com.github.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author hewenji
 * @Date 2023/5/29 17:14
 */
@Component
@Aspect
public class MyAdvice3 {

    /*
        获取参数
        获取返回值
        获取异常
     */

    @Pointcut("execution(public int com.github.dao.BookDao.inc(int))")
    private void pt(){
    }

    // @Before("pt()")
    public void before(JoinPoint jp) {
        Object[] args = jp.getArgs();
        System.out.println("args:" + Arrays.toString(args));
    }

    @Around("pt()")
    public int around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        System.out.println("args:" + Arrays.toString(args));
        args[0] = 665;
        int res = (int) pjp.proceed(args);
        return res;
    }

    @AfterReturning(value = "pt()", returning = "ret") // 如果有返回值，返回值会传到形参上
    public void afterReturning(Object ret) {
        System.out.println("after returning advice ..." + ret);
    }
}
