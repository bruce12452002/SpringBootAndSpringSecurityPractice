package com.bruce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Configuration
//@Import(BCryptPasswordEncoder.class)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private BCryptPasswordEncoder pe;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 設定後，application.properties 的設定就沒用了
        // 但以下設定，按送出後，會出現例外 There is no PasswordEncoder mapped for the id "null"
//        auth.inMemoryAuthentication().withUser("aaa").password("123").roles();
//        auth.inMemoryAuthentication().withUser("bbb").password("456").roles();

        // 以下的 passwordEncoder 和 password 都要使用才會生效
        // 尤於 BCryptPasswordEncoder 用到很多次，所以提出共用，使用 @Import 的方式
        // 如果使用 @Bean 可以少寫 passwordEncoder 方法
        auth.inMemoryAuthentication()
                //.passwordEncoder(pe)
                .withUser("aaa")
                .password(pe.encode("123"))
                .roles("level1");

        auth.inMemoryAuthentication()
                //.passwordEncoder(pe)
                .withUser("bbb")
                .password(pe.encode("456"))
                .roles("level2");


    }

    @Bean
    public BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }
}
