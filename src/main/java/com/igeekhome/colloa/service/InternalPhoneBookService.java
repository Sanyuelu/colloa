package com.igeekhome.colloa.service;

import com.igeekhome.colloa.condition.EmployeeCondition;
import com.igeekhome.colloa.util.ResultObject;
import com.igeekhome.colloa.util.TableDataNode;

/**
 * 内部通讯录业务层接口
 */

public interface InternalPhoneBookService {

    /**
     * 获取公司内部全部职员信息,将从数据库中检索到的职员信息封装到TableDataNode对象中
     * 用于支持LayUI Table 数据项
     *
     * @param page  当前页
     * @param limit 每页的条数
     * @return 整个公司内部全部职员信息
     */
    TableDataNode queryAllEmployee(Integer page, Integer limit);

    /**
     * 获取子公司的全部职员信息
     *
     * @param page        当前页
     * @param limit       每页的条数
     * @param CompanyCode 子公司编号
     * @return
     */
    TableDataNode queryEmployeeByCompany(Integer page,
                                         Integer limit,
                                         String CompanyCode);

    /**
     * 获取子公司的某个部门的全部职员信息
     *
     * @param page        当前页
     * @param limit       每页的条数
     * @param CompanyCode 子公司编号
     * @param DepaCode    部门编号
     * @return
     */
    TableDataNode queryEmployeeByDepartment(Integer page,
                                            Integer limit,
                                            String CompanyCode,
                                            String DepaCode);

    /**
     * 模糊查询员工
     *
     * @param page      当前页
     * @param limit     每页的条数
     * @param condition 相关员工的部分信息
     * @return
     */
    TableDataNode queryEmployeeByCondition(Integer page,
                                           Integer limit,
                                           EmployeeCondition condition);

    /**
     * 获取所有的公司信息
     *
     * @return
     */
    ResultObject queryAllCompany();

    /**
     * 查询某个公司下面的所有部门
     *
     * @param CompanyCode 公司编号
     * @return
     */
    ResultObject queryDepartmentByCompany(String CompanyCode);

    /**
     * 更新员工的通讯信息
     *
     * @param condition 员工通讯信息
     * @return
     */
    ResultObject updateEmployeeInfo(EmployeeCondition condition);
}
