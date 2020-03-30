package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Book
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/24
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String name;
    private Double price;
    private String des;
    private String author;
    private String cover;
}