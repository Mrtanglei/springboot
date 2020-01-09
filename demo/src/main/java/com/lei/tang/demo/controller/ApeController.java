package com.lei.tang.demo.controller;

import com.lei.tang.demo.service.people.ApeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanglei
 * @date 2020/1/9
 */
@RestController
@RequestMapping("/ape")
public class ApeController {

    @Autowired
    ApeService apeService;

    /**
     * true代表正常吃饭，false表示有人醉酒
     *
     * @param status
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/haveMeal")
    public String haveMeal(@RequestParam Boolean status) throws InterruptedException {
        return apeService.haveMeal(status);
    }
}