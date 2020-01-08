package com.lei.tang.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tanglei
 * @date 2019/12/26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentLimit {

    /**
     * 请求次数
     *
     * @return
     */
    int number();

    /**
     * 时间限制
     *
     * @return
     */
    long time();
}
