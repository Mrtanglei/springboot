package com.lei.tang.demo.config.common;

import javax.servlet.*;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tanglei
 * @date 2020/1/8
 */
@Slf4j
//@WebFilter("/*")
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("==========in CustomFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("in CustomFilter doFilter");
        filterChain.doFilter(servletRequest,servletResponse );
    }

    @Override
    public void destroy() {
        log.info("in CustomFilter destroy");
    }
}