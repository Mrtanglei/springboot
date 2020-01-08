package com.lei.tang.demo.controller;

import com.lei.tang.common.annotation.CurrentLimit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanglei
 * @date 2019/12/26
 */
@Slf4j
@RestController
@RequestMapping("/currentLimit")
public class CurrentLimitController {

    @CurrentLimit(number = 1, time = 5)
    @GetMapping("/test")
    public String test() {
        return "正常访问";
    }
}
