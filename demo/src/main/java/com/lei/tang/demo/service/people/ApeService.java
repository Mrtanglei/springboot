package com.lei.tang.demo.service.people;

/**
 * @author tanglei
 * @date 2020/1/9
 */
public interface ApeService {

    /**
     * 吃饭
     * @return
     */
    String haveMeal(Boolean status) throws InterruptedException;

    /**
     * 电话
     * @param msg
     */
    void call(String msg);
}
