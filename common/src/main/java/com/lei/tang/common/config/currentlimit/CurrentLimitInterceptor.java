package com.lei.tang.common.config.currentlimit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

import com.lei.tang.common.annotation.CurrentLimit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author tanglei
 * @date 2019/12/26
 * <p>
 * 自定义限流拦截器
 */
@Slf4j
@Component
public class CurrentLimitInterceptor implements HandlerInterceptor {

    private final static String SEPARATOR = "-";

    @Autowired
    private RedisTemplate<String, Long> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //通过HandlerMethod获取方法CurrentLimit注解
            CurrentLimit currentLimit = handlerMethod.getMethodAnnotation(CurrentLimit.class);
            //如果此方法存在限流注解
            if (currentLimit != null) {
                log.info("进入限流拦截器");
                int number = currentLimit.number();
                long time = currentLimit.time();
                //如果次数和时间限制都大于0证明此处需要限流
                if (time > 0 && number > 0) {
                    String key = request.getContextPath() + SEPARATOR + request.getServletPath() + SEPARATOR + "ip";
                    Long numberRedis = redisTemplate.opsForValue().get(key);
                    log.debug("redis中的number[{}]", numberRedis);
                    if (null == numberRedis) {
                        redisTemplate.opsForValue().set(key, 1L, time, TimeUnit.SECONDS);
                        return true;
                    }
                    if (numberRedis >= number) {
                        throw new RuntimeException("请求频繁，请稍后重试！");
                    }
                    redisTemplate.opsForValue().set(key, numberRedis + 1);
                }
            }
        }
        return true;
    }
}
