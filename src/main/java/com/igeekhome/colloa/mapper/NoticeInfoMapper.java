package com.igeekhome.colloa.mapper;

import com.igeekhome.colloa.domain.NoticeInfo;
import com.igeekhome.colloa.domain.NoticeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeInfoMapper {
    long countByExample(NoticeInfoExample example);

    int deleteByExample(NoticeInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NoticeInfo record);

    int insertSelective(NoticeInfo record);

    List<NoticeInfo> selectByExampleWithBLOBs(NoticeInfoExample example);

    List<NoticeInfo> selectByExample(NoticeInfoExample example);

    NoticeInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NoticeInfo record, @Param("example") NoticeInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") NoticeInfo record, @Param("example") NoticeInfoExample example);

    int updateByExample(@Param("record") NoticeInfo record, @Param("example") NoticeInfoExample example);

    int updateByPrimaryKeySelective(NoticeInfo record);

    int updateByPrimaryKeyWithBLOBs(NoticeInfo record);

    int updateByPrimaryKey(NoticeInfo record);
}