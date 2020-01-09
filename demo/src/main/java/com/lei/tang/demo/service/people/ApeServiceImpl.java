package com.lei.tang.demo.service.people;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tanglei
 * @date 2020/1/9
 */
@Slf4j
@Service("apeService")
public class ApeServiceImpl implements ApeService {

    @Override
    public String haveMeal(Boolean status) throws InterruptedException {
        log.info("吃饭");
        if (!status) {
            throw new RuntimeException("同事醉酒进医院");
        }
        return "吃饭";
    }

    @Override
    public void call(String msg) {
        log.info("电话====》{}", msg);
    }
}
