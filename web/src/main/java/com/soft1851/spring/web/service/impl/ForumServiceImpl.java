package com.soft1851.spring.web.service.impl;
import com.soft1851.spring.web.dao.ForumDao;
import com.soft1851.spring.web.dao.impl.ForumDaoImpl;
import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.service.ForumService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ForumServiceImpl
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/20
 **/
@Service
public class ForumServiceImpl implements ForumService {
    private final ForumDao forumDao;
    public ForumServiceImpl(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Override
    public List<Forum> selectAll() {
        return forumDao.selectAll();
    }

    @Override
    public Forum get(int forumId) {
        return forumDao.get(forumId);
    }

    @Override
    public int delete(int forumId) {
        return forumDao.delete(forumId);
    }
//
//    @Override
//    public int insert(Forum forum) {
//        return forumDao.insert(forum);
//    }
}