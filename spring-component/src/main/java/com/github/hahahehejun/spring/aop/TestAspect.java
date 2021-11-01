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
public class TestAspect {


    @Pointcut("execution(public * com.demo.spring.service.impl.AopTestServiceImpl.test1())")
    public void test1Aspect(){

    }

    @Pointcut("execution(public * com.demo.spring.service.impl.AopTestServiceImpl.test2())")
    public void test2Aspect(){

    }

    @Pointcut("execution(public * com.demo.spring.service.impl.AopTestServiceImpl.test3())")
    public void test3Aspect(){

    }


    @Pointcut("execution(public * com.demo.spring.service.impl.AopTestServiceImpl.test4(int))&& args(i))")
    public void test4Aspect(int i){

    }

    /**
     * 以注解为切点
     */
    @Pointcut("@annotation(com.demo.spring.annotation.MyTest)")
    public void test5Aspect(){

    }

    /**
     * 方法执行前执行
     */
    @Before("test1Aspect()")
    public void doBeforeGame(){
        System.out.println("方法开始执行！");
    }

    /**
     * 方法执行后执行
     */
    @After("test1Aspect()")
    public void doAfterGame(){
        System.out.println("方法执行结束！");
    }


    /**
     * 在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("test2Aspect()")
    public void doAfterReturningGame(){
        System.out.println("没有抛出异常时执行！");
    }

    /**
     * 在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("test2Aspect()")
    public void doAfterThrowingGame(){
        System.out.println("抛出异常时执行！");
    }


    /**
     * 使用环绕通知
     */
    @Around("test3Aspect()")
    public void doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
        try{
            System.out.println("test3准备执行");
            pjp.proceed();
            System.out.println("test3执行完成");
        }
        catch(Throwable e){
            System.out.println("test3抛出异常");
        }
    }

    /**
     * 使用环绕通知
     */
    @Around("test4Aspect(i)")
    public void doAroundGameData(ProceedingJoinPoint pjp,int i) throws Throwable {
        try{
            System.out.println("test4准备执行");
            pjp.proceed();
            System.out.println("test4执行完成,传入参数"+i);
        }
        catch(Throwable e){
            System.out.println("test4抛出异常");
        }
    }

    /**
     * 使用环绕通知
     */
    @Around("test5Aspect()")
    public void doAroundGameByAnnotation(ProceedingJoinPoint pjp) throws Throwable {
        try{
            System.out.println("test5准备执行");
            pjp.proceed();
            System.out.println("test5执行完成");
        }
        catch(Throwable e){
            System.out.println("test5抛出异常");
        }
    }
}
