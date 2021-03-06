package com.springboot.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tanglei
 * @date 2020/1/10
 */
@Getter
@Setter
@ToString
public class Student {

    private Long id;

    private String name;

    private String sex;

    private Integer age;
}
