package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @ClassName ClassVo
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClazzVo {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherName;
    private Integer studentId;
    private String studentName;
    private String homeTown;
    private LocalDate birthday;

}