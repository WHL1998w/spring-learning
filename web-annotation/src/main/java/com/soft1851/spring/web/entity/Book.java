package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Book
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/28
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String title;
    private String desc;
    private String profile;
    private String userName;
    private Double price;
    private String img;
}