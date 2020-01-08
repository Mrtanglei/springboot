package com.lei.tang.demo.service.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author tanglei
 * @date 2020/1/3
 */
@Slf4j
@Service("logService")
public class LogServiceImpl implements LogService {

    final ThreadLocal<Long> logDate = new ThreadLocal<>();

    @Override
    public void onPre() {
        logDate.set(System.currentTimeMillis());
        log.info("进入请求时间 {}", logDate.get());
    }

    @Override
    public void onAfter() {
        log.info("结束请求时间 {}", logDate.get());
        logDate.remove();
    }

    @Override
    public void onError() {
        if(logDate.get() != null) {
            log.info("发生错误引发结束请求时间 {}", logDate.get());
            logDate.remove();
        }
    }
}