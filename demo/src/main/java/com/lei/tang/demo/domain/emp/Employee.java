package com.lei.tang.demo.domain.emp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tanglei
 * @date 2020/1/2
 */
@Getter
@Setter
@ToString
public class Employee {

    private String name;

    private Department department;
}
