package com.igeekhome.colloa.mapper;

import com.igeekhome.colloa.domain.MessageInfo;
import com.igeekhome.colloa.domain.MessageInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface MessageInfoMapper {

    /**
     * 模糊条件查询 没有接收人/发送人条件
     *
     * @param theme
     * @param emplCode
     * @return
     */
    List<MessageInfo> selectByCondition(@Param("theme") String theme,
                                        @Param("emplCode") String emplCode);

    /**
     * 模糊条件查询 有接收人/发送人条件
     *
     * @param theme
     * @param emplCodes
     * @param selfCode
     * @return
     */
    List<MessageInfo> selectByEmplCondition(@Param("theme") String theme,
                                            @Param("emplCodes") Collection<String> emplCodes,
                                            @Param("selfCode") String selfCode);

    long countByExample(MessageInfoExample example);

    int deleteByExample(MessageInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageInfo record);

    int insertSelective(MessageInfo record);

    List<MessageInfo> selectByExample(MessageInfoExample example);

    MessageInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageInfo record, @Param("example") MessageInfoExample example);

    int updateByExample(@Param("record") MessageInfo record, @Param("example") MessageInfoExample example);

    int updateByPrimaryKeySelective(MessageInfo record);

    int updateByPrimaryKey(MessageInfo record);
}