package com.lei.tang.demo.config.log;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lei.tang.demo.service.log.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author tanglei
 * @date 2020/1/3
 */
@Slf4j
@Component
public class LogHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private LogService logService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("=========>in LogHandlerInterceptor preHandle");
        logService.onPre();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("=========>in LogHandlerInterceptor postHandle {} {}");
        logService.onAfter();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex){
        log.info("=========>in LogHandlerInterceptor afterCompletion {} {}");
        logService.onError();
    }
}
