package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName ForumService
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/20
 **/
@Component
public interface ForumService {
    /**
     * 查询所有论坛
     * @return
     */
    List<Forum> selectAll();

    /**
     * 根据Id查询forum
     * @param forumId
     * @return
     */
    Forum get(int forumId);

    /**
     * 删除
     * @param forumId
     * @return
     */
    int delete(int forumId);
//
//    /**
//     * 增加
//     * @param forum
//     * @return
//     */
//    int insert(Forum forum);
}
