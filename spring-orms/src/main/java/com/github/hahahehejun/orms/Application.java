package com.github.hahahehejun.orms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lfw
 * @Description
 * @date 2020/10/30 10:06
 */
@MapperScan(value = "com.github.hahahehejun.orms.mybatis.mapper")
@SpringBootApplication(scanBasePackages = {"com.github.hahahehejun.orms"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
