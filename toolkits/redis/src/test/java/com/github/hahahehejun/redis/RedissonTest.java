package com.github.hahahehejun.redis;

import com.github.hahahehejun.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wu
 * @date 2022/1/10 11:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedissonTest {

    @Autowired
    RedissonClient redissonClient;

    @Test
    public void contextLoads() throws InterruptedException {
        RBloomFilter<User> bloom = redissonClient.getBloomFilter("bloom3");
        bloom.tryInit(55000l,0.03);
        for (int i = 0; i < 1000; i++) {
            bloom.add(new User(i));
        }
        System.out.println(bloom.contains(new User(1)));

    }
}
