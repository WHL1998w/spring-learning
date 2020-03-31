package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Clazz;

/**
 * @InterfaceName ClazzMapper
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/31
 **/
public interface ClazzMapper {
    /**
     * 根据clazzId一对多关联查询本班所有的学生
     * @param clazzId
     * @return
     */
    Clazz getClazzOneToMany(int clazzId);
}
