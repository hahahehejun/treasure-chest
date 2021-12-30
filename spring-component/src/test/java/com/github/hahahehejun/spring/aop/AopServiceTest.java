package com.github.hahahehejun.spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wu
 * @date 2021/12/29 11:05
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AopServiceTest {

    @Autowired
    private AopService service;

    @Test
    public void beforeAndAfter() {
        service.beforeAndAfter();
    }

    @Test
    public void annotationReturn() {
        service.annotationReturn();
    }

    @Test
    public void annotationThrow() {
        service.annotationThrow();
    }

    @Test
    public void changeParamAndReturn() {
        System.out.println(service.changeParamAndReturn("初始化参数"));
    }
}