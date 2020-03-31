package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.ClazzVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName ClassMapper
 * @Description TODO
 * @Author wanghuanle
 * @Date 2020/3/31
 **/
@Transactional(rollbackFor = Exception.class)
public interface ClazzVoMapper {
    /**
     * 获取指定班课中的学生信息
     * @param clazzId
     * @return
     */
    List<ClazzVo> getClazzStudent(int clazzId);

    /**
     * 获取指定班课中所有教室的信息
     * @param id
     * @return
     */
    List<Map<String,Object>> getClazzStudent1(int id);

}
