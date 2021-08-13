package com.platform.user.aop.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面实现
 * @author lin512100
 * @date 2021/6/8
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    /**
     * 定义一个切点
     */
    @Pointcut(value = "@annotation(com.platform.user.aop.annotation.Log))")
    public void pointcut() {
    }

    /**
     * 前置通知
     * @param joinPoint 包含了目标方法的所有关键信息
     * @param log       注解信息
     * @param object    参数信息
     */
    @Before("pointcut() && @annotation(log) && args(object)")
    public void before(JoinPoint joinPoint, Log log, Object object) {
        Signature signature = joinPoint.getSignature();
        System.out.printf("前置通知 模块名称:%s 参数:%s 方法：%s%n", log.module(), object, signature.getName());
    }

    /**
     * 后置通知
     * @param joinPoint 包含了目标方法的所有关键信息
     */
    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.printf("后置通知 %s方法执行结束了...%n", signature.getName());
    }

    /**
     * 有返回通知
     * 目标方法的返回值类型要和这里方法返回值参数的类型一致，否则拦截不到
     * 如果想拦截所有（包括返回值为 void），则方法返回值参数可以为 Object
     * @param joinPoint 包含了目标方法的所有关键信息
     */
    @AfterReturning(value = "pointcut()", returning = "obj")
    public void returning(JoinPoint joinPoint, Object obj) {
        Signature signature = joinPoint.getSignature();
        System.out.printf("有返回值拦截 %s方法执行结束了... 返回值:%s", signature.getName(), obj);
    }

    /**
     * 异常通知
     * @param joinPoint 包含了目标方法的所有关键信息
     * @param e         目标方法所抛出的异常，注意，这个参数必须是目标方法所抛出的异常或者所抛出的异常的父类
     *                  如果想拦截所有，参数类型声明为 Exception
     */
    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.printf("异常通知 %s 方法抛异常了：%s%n", name, e.getMessage());
    }

    /**
     * 环绕通知
     * 可以用环绕通知实现上面的四个通知，这个方法的核心有点类似于在这里通过反射执行方法
     * @param pjp 包含了目标方法过程的所有关键信息
     * @return 注意这里的返回值类型最好是 Object ，和拦截到的方法相匹配
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        Object proceed = null;
        try {
            System.out.println("环形通知开始");
            proceed = pjp.proceed();
            System.out.println("环形通知方法执行结束");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环形通知方法执行异常结束");
        }
        return proceed;
    }
}

