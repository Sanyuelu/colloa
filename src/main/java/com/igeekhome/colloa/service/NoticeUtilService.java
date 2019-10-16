package com.igeekhome.colloa.service;

import com.igeekhome.colloa.util.ResultObject;

/**
 * 给公告编辑提供服务的接口
 */

public interface NoticeUtilService {

    /**
     * 1.检索公告类型
     *
     * @return data=List<DictCategory>
     */
    ResultObject queryNoticeCategory();

    /**
     * 2、检索责任人所在公司的所有部门
     *
     * @param editorCode 责任人工号
     * @return data = List<DepartmentDTO>
     */
    ResultObject queryDepartment(String editorCode);

    /**
     * 3.根据名字模糊查询本公司的参与人
     *
     * @param editorCode 责任人工号
     * @param name       检索的参与人姓名
     * @return data=List<EmployeeInfo>
     */
    ResultObject queryEmployeeByName(String editorCode,
                                     String name);
}
