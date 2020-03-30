package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TopicServiceImpl
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/27
 * @Transactional:表示本类启动了事务，那么这个类里面的方法抛出异常，就会回滚，数据库里面的数据也会回滚
 **/
@Service
@Transactional(rollbackFor = Exception.class)

public class TopicServiceImpl implements TopicService {

    @Resource
    private TopicDao topicDao;
    @Override
    public List<Topic> selectAll() {
        return topicDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        return topicDao.batchInsert(topics);
    }

    @Override
    public void insert(Topic topic) {
        topicDao.insert(topic);
        try {
            int a = 1/0;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}