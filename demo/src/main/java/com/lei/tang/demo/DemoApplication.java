package com.lei.tang.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ServletComponentScan//扫描Filter、Servlet和Listener
@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {"com.lei.tang.demo.*","com.lei.tang.common.*"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}