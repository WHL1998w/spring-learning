package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @author hyj
 */
public interface TopicDao {
    /**
     * 查询所有topic
     * @return list<Topic></>
     */
    List<Topic> selectAll();
}
