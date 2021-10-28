package com.github.hahahehejun.orms.mybatis.service;

import com.github.hahahehejun.orms.mybatis.entity.OnlyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author wu
 * @date 2021/10/28 15:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OnlyServiceTest {

    @Autowired
    private IOnlyServiceService onlyServiceService;

    @Test
    public void list(){
        System.out.println(onlyServiceService.list());
    }


}
