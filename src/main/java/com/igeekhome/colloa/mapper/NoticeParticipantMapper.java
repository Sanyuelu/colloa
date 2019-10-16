package com.igeekhome.colloa.mapper;

import com.igeekhome.colloa.domain.NoticeParticipant;
import com.igeekhome.colloa.domain.NoticeParticipantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeParticipantMapper {
    long countByExample(NoticeParticipantExample example);

    int deleteByExample(NoticeParticipantExample example);

    int deleteByPrimaryKey(Long id);

    int batchInsert(List<NoticeParticipant> noticeParticipantList);

    int insert(NoticeParticipant record);

    int insertSelective(NoticeParticipant record);

    List<NoticeParticipant> selectByExample(NoticeParticipantExample example);

    NoticeParticipant selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NoticeParticipant record, @Param("example") NoticeParticipantExample example);

    int updateByExample(@Param("record") NoticeParticipant record, @Param("example") NoticeParticipantExample example);

    int updateByPrimaryKeySelective(NoticeParticipant record);

    int updateByPrimaryKey(NoticeParticipant record);
}