package com.lei.tang.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanglei
 * @date 2019/12/24
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/say")
    public String sayHello() {
        return "first spring boot";
    }
}