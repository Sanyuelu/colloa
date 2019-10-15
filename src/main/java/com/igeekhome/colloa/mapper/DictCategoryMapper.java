package com.igeekhome.colloa.mapper;

import com.igeekhome.colloa.domain.DictCategory;
import com.igeekhome.colloa.domain.DictCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictCategoryMapper {
    long countByExample(DictCategoryExample example);

    int deleteByExample(DictCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DictCategory record);

    int insertSelective(DictCategory record);

    List<DictCategory> selectByExample(DictCategoryExample example);

    DictCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DictCategory record, @Param("example") DictCategoryExample example);

    int updateByExample(@Param("record") DictCategory record, @Param("example") DictCategoryExample example);

    int updateByPrimaryKeySelective(DictCategory record);

    int updateByPrimaryKey(DictCategory record);
}