package com.igeekhome.colloa.mapper;

import com.igeekhome.colloa.domain.EmployeeInfo;
import com.igeekhome.colloa.domain.EmployeeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeInfoMapper {
    long countByExample(EmployeeInfoExample example);

    int deleteByExample(EmployeeInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EmployeeInfo record);

    int insertSelective(EmployeeInfo record);

    List<EmployeeInfo> selectByExample(EmployeeInfoExample example);

    EmployeeInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EmployeeInfo record, @Param("example") EmployeeInfoExample example);

    int updateByExample(@Param("record") EmployeeInfo record, @Param("example") EmployeeInfoExample example);

    int updateByPrimaryKeySelective(EmployeeInfo record);

    int updateByPrimaryKey(EmployeeInfo record);
}