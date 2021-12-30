package com.github.hahahehejun.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: 哈哈呵呵君
 * @date: 2020/10/31 22:51
 */
@Aspect
@Component
public class AopAspect {

    /**
     * execution(<修饰符模式>?<返回类型模式><方法名模式>(<参数模式>)<异常模式>?)
     */
    @Pointcut("execution(public * com.github.hahahehejun.spring.aop.AopService.beforeAndAfter())")
    public void executionPointcut(){

    }


    @Pointcut("execution(public * com.github.hahahehejun.spring.aop.AopService.changeParamAndReturn(*))")
    public void executionPointcut2(){

    }

    /**
     * 以注解为切点
     */
    @Pointcut("@annotation(com.github.hahahehejun.spring.aop.AopAnnotation)")
    public void annotationPointcut(){

    }



    /**
     * 方法执行前执行
     */
    @Before("executionPointcut()")
    public void doBeforeSome(){
        System.out.println("进入切面一：方法开始前执行！");
    }

    /**
     * 方法执行后执行
     */
    @After("executionPointcut()")
    public void doAfterSome(){
        System.out.println("进入切面二：方法结束后执行！");
    }

    /**
     * 使用环绕通知
     */
    @Around("annotationPointcut()")
    public void doAroundByAnnotation(ProceedingJoinPoint pjp) throws Throwable {
        try{
            System.out.println("通过注解进入切面-环绕-执行前 ");
            pjp.proceed();
            System.out.println("通过注解进入切面-环绕-执行后 ");
        }
        catch(Throwable e){
            System.out.println("通过注解进入切面-环绕-抛出异常");
        }
    }


    /**
     * 使用环绕通知
     */
    @Around("executionPointcut2()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        System.out.print("传入参数为：");
        for (Object arg : args) {
            System.out.println(arg);
        }
        String[] newParams= {"参数已修改"};
        pjp.proceed(newParams);
        return "返回值已修改";
    }

}
