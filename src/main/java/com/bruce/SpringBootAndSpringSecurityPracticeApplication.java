package com.bruce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


/**
 * Springboot 的自動設定 SecurityAutoConfiguration，有使用 @Import，
 * 其中 WebSecurityEnablerConfiguration 類別上已經有 @EnableWebSecurity
 * 所以不用這個註解也能使用 SpringSecurity
 */
// @EnableWebSecurity
@SpringBootApplication // (exclude = SecurityAutoConfiguration.class) // 如果不想打帳密，就排除這個類別
@EnableGlobalMethodSecurity(prePostEnabled = true) // 會抓到 @PreAuthorize @PostAuthorize
public class SpringBootAndSpringSecurityPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAndSpringSecurityPracticeApplication.class, args);
    }

}
