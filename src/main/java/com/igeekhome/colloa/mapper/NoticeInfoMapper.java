package com.igeekhome.colloa.mapper;

import com.igeekhome.colloa.domain.EmployeeInfo;
import com.igeekhome.colloa.domain.NoticeInfo;
import com.igeekhome.colloa.domain.NoticeInfoExample;
import com.igeekhome.colloa.dto.NoticeInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeInfoMapper {
    long countByExample(NoticeInfoExample example);

    int deleteByExample(NoticeInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NoticeInfo record);

    int insertSelective(NoticeInfo record);

    List<EmployeeInfo> selectParticipantListByNoticeCode(String noticeCode);

    List<NoticeInfoDTO> selectDTOByExampleWithBLOBs(NoticeInfoExample example);

    List<NoticeInfo> selectByExampleWithBLOBs(NoticeInfoExample example);

    List<NoticeInfo> selectByExample(NoticeInfoExample example);

    NoticeInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NoticeInfo record, @Param("example") NoticeInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") NoticeInfo record, @Param("example") NoticeInfoExample example);

    int updateByExample(@Param("record") NoticeInfo record, @Param("example") NoticeInfoExample example);

    int updateByPrimaryKeySelective(NoticeInfo record);

    int updateByPrimaryKeyWithBLOBs(NoticeInfo record);

    int updateByPrimaryKey(NoticeInfo record);

    List<NoticeInfoDTO> selectWeekNotice();

    List<NoticeInfoDTO> selectMonthNotice();

    List<NoticeInfoDTO> selectQuarterNotice();
}