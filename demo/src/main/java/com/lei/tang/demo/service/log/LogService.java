package com.lei.tang.demo.service.log;

/**
 * @author tanglei
 * @date 2020/1/3
 */
public interface LogService {

    void onPre();

    void onAfter();

    void onError();
}
