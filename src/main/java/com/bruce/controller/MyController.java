package com.bruce.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/hello")
    public String helloSecurity() {
        return "hello spring security!";
    }

    @PreAuthorize("hasAnyRole('level1', 'level2')")
    @GetMapping("/autho1")
    public String authoTest1() {
        return "LV1 and LV2";
    }

    @PreAuthorize("hasAnyRole('level2')")
    @GetMapping("/autho2")
    public String authoTest2() {
        return "only LV2";
    }
}
