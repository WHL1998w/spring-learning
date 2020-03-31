package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Student
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Integer studentId;
    private Integer clazzId;
    private String studentName;
    private String hometown;
    private LocalDate birthday;
    /**学生所属班级*/
    private Clazz clazz;
    /**所学课程*/
    private List<Course> courses;

}