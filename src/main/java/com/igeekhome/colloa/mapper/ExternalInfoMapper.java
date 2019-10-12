package com.igeekhome.colloa.mapper;

import com.igeekhome.colloa.domain.ExternalInfo;
import com.igeekhome.colloa.domain.ExternalInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExternalInfoMapper {
    long countByExample(ExternalInfoExample example);

    int deleteByExample(ExternalInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExternalInfo record);

    int insertSelective(ExternalInfo record);

    List<ExternalInfo> selectByExample(ExternalInfoExample example);

    ExternalInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExternalInfo record, @Param("example") ExternalInfoExample example);

    int updateByExample(@Param("record") ExternalInfo record, @Param("example") ExternalInfoExample example);

    int updateByPrimaryKeySelective(ExternalInfo record);

    int updateByPrimaryKey(ExternalInfo record);
}