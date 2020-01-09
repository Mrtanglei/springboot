package com.lei.tang.demo.config.common;

import com.lei.tang.demo.config.log.LogHandlerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author tanglei
 * @date 2020/1/3
 * <p>
 * 自定义MVC容器配置
 */
@Slf4j
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    LogHandlerInterceptor logHandlerInterceptor;

    /**
     * 添加自定义的拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logHandlerInterceptor).addPathPatterns("/global/**").order(2);
    }
}
