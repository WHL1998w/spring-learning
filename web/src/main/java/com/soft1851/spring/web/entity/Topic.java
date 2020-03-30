package com.soft1851.spring.web.entity;

import lombok.Data;

/**
 * @author hyj
 * @data 2020/3/26
 */
@Data
public class Topic {
    private Integer id;
    private String topicName;
    private String topicIcon;
    private Integer pins;
    private Integer follows;
}
