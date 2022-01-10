package com.github.hahahehejun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wu
 * @date 2022/1/10 10:54
 */
@SpringBootApplication(scanBasePackages = {"com.github.hahahehejun"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
