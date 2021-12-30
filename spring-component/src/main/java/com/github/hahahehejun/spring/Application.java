package com.github.hahahehejun.spring;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wu
 * @date 2021/12/29 10:32
 */
@SpringBootApplication(scanBasePackages = "com.github.hahahehejun.spring")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
