package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @InterfaceName TopicService
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/27
 **/
public interface TopicService {
    /**
     * 查询所有topic
     * @return list<Topic>
     */
    List<Topic> selectAll();

    /**
     * 批量插入
     * @param topics
     * @return
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增一个
     * @param topic
     * @return
     */
    void insert(Topic topic);
}
