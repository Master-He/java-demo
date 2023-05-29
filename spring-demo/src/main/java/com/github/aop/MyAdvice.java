package com.github.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hewenji
 * @Date 2023/5/29 17:14
 */
@Component // 写入spring容器
@Aspect // 把你当AOP处理，  除此之气还要在SpringConfig类中声明@EnableAspectJAutoProxy， 告诉spring有注解aop， spring就会找到这里
public class MyAdvice {

    /*
        // AOP本质就是代理模式
        切点表达式
        execution(public void com.github.dao.BookDao.get(void))

        切点表达式可以用通配符， 这样就可以对很多类进行描述
            *  表示单个独立的任意符号
            .. 表示连续的任意符号
            + 用于匹配子类类型
     */

    // 定义切点，可以切在接口上，也可以切在实体类（但是这样会很耦合，所以实际情况不能用）
    @Pointcut("execution(public void com.github.dao.BookDao.get())")
    // @Pointcut("execution(public void com.*.*.BookDao.get())")  // 依然可以用， * 表示单个独立的任意符号
    // @Pointcut("execution(public void com..BookDao.get(..))")  // 依然可以用   .. 表示连续的任意符号
    // @Pointcut("execution(* *..*(..))") // 匹配所有类的所有方法。。。 不要这么写
    // @Pointcut("execution(* *..get*(..))")  // 表示匹配get开头的方法
    private void pt(){
    }

    // 在切点之前执行
    // @Before("pt()")
    public void method() {
        // AOP本质就是代理模式
        System.out.println("调用前时间：" + System.currentTimeMillis());
    }

    // @After("pt()")
    public void method2() {
        System.out.println("调用后时间：" + System.currentTimeMillis());
    }

    @Around("pt()")
    public void method3(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before");
        pjp.proceed();
        System.out.println("after");
    }

}
