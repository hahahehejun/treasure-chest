package com.github.hahahehejun.spring.aop;

import org.springframework.stereotype.Service;

/**
 *
 * @author wu
 * @date 2021/12/29 10:38
 */
@Service
public class AopService {


    public void beforeAndAfter(){
        System.out.println("beforeAndAfter()执行中.....");
    }

    public String changeParamAndReturn(String param){
        System.out.println("传入参数为-》"+param);
        return param;
    }

    @AopAnnotation
    public void annotationReturn(){
        System.out.println("使用注解切面..正常返回......");
    }

    @AopAnnotation
    public void annotationThrow(){
        System.out.println("使用注解切面..抛出异常......");
        throw new RuntimeException();
    }

}
