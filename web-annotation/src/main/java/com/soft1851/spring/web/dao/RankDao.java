package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Rank;

import java.util.List;

/**
 * @InterfaceName RankDao
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/28
 **/
public interface RankDao {
    /**
     * 搜索全部
     * @return
     */
    List<Rank> selectAll();

    /**
     * 批量插入
     * @param ranks
     * @return
     */
    int [] batchInsert(List<Rank> ranks);

    /**
     * 新增单个
     * @param
     * @return
     */
    int insert(Rank rank);
}
