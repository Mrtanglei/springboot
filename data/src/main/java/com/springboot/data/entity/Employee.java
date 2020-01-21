package com.springboot.data.entity;

import javax.persistence.*;

import lombok.*;

/**
 * @author tanglei
 * @date 2020/1/20
 */
@Getter
@Setter
@ToString
@Entity(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "age",nullable = false)
    private Integer age;
}