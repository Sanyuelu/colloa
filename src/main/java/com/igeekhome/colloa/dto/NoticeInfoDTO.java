package com.igeekhome.colloa.dto;

import com.igeekhome.colloa.domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 公告封装类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeInfoDTO extends NoticeInfo {

    /**
     * 发布部门名称
     */
    private DictCategory department;

    /**
     * 发布部门所属公司名称
     */
    private CompanyInfo company;

    /**
     * 责任人
     */
    private EmployeeInfo editor;

    /**
     * 参与人[多个]
     */
    private List<EmployeeInfo> participantList = new ArrayList<>();

}
