package com.lei.tang.demo.config.common;

import javax.servlet.*;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tanglei
 * @date 2020/1/8
 */
@Slf4j
//@WebListener
public class CustomListener implements HttpSessionListener, HttpSessionAttributeListener, ServletContextListener,
        ServletContextAttributeListener, ServletRequestListener,ServletRequestAttributeListener {

    /**
     * 实现HttpSessionListener监听session状态
     * @param httpSessionEvent
     */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("监听session的创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("监听session的销毁");
    }

    /**
     * 实现HttpSessionAttributeListener监听session属性
     * @param httpSessionBindingEvent
     */
    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        log.info("监听session属性的增加");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        log.info("监听session属性的移除");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        log.info("监听session属性的修改");
    }

    /**
     * 实现ServletContextListener监听上下文状态
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("监听context的销毁");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("监听context的销毁");
    }

    /**
     * 实现ServletContextAttributeListener监听上下文属性变化
     * @param servletContextAttributeEvent
     */
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        log.info("监听context属性的增加");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        log.info("监听context属性的移除");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        log.info("监听context属性的修改");
    }

    /**
     * 实现ServletRequestListener监听请求request状态
     * @param servletRequestEvent
     */
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        log.info("监听request的创建");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("监听request的销毁");
    }

    /**
     * 实现ServletRequestAttributeListener监听请求request属性
     * @param servletRequestAttributeEvent
     */
    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        log.info("监听request属性的增加");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        log.info("监听request属性的移除");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        log.info("监听request属性的修改");
    }
}