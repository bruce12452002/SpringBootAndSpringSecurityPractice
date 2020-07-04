package com.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) // 如果不想打帳密，就排除這個類別
public class SpringBootAndSpringSecurityPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndSpringSecurityPracticeApplication.class, args);
    }

}
