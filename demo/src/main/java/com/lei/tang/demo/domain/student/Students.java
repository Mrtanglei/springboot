package com.lei.tang.demo.domain.student;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tanglei
 * @date 2019/12/25
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "many")
public class Students {

    private List<Student> students;
}