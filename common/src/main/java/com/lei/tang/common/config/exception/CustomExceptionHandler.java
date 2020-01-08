package com.lei.tang.common.config.exception;

import java.util.Map;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author tanglei
 * @date 2020/1/2
 */
@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    //成功
    private final static int success = 0;

    //校验
    private final static int invalid = 100;

    /**
     * 当发生的异常在全局异常处理中进行了捕获处理时就不会进入此处
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Map<String, Object> allException(Exception e) {
        log.error("捕获Exception异常", e);
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", invalid);
        map.put("msg", e.getMessage());
        return map;
    }

    /**
     * 只当发生IllegalArgumentException异常时进入
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, Object> checkHandler(IllegalArgumentException e) {
        log.error("捕获IllegalArgumentException异常", e);
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", invalid);
        map.put("msg", e.getMessage());
        return map;
    }
}