package com.igeekhome.colloa.service;

import com.igeekhome.colloa.domain.ExternalInfo;
import com.igeekhome.colloa.util.ResultObject;
import com.igeekhome.colloa.util.TableDataNode;

/**
 * 外部通讯录接口
 */

public interface ExternalPhoneBookService {

    /**
     * 获取所有的外部通讯录的类别信息
     *
     * @return
     */
    ResultObject queryAllCategory();

    /**
     * 获取外部通讯录所有联系人的联系方式
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryAllContacts(Integer page,
                                   Integer limit);

    /**
     * 获取外部通讯录中某一类别中所有联系人方式
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryContactsByCategory(Integer page,
                                          Integer limit,
                                          String cateCode);

    /**
     * 模糊查询外部联系人信息
     *
     * @param page      当前页
     * @param limit     每页的条数
     * @param condition 查询条件
     * @return
     */
    TableDataNode queryContactsByCondition(Integer page,
                                           Integer limit,
                                           ExternalInfo condition);
    /**
     * 新增外部联系人
     *
     * @param contact
     * @return
     */
    ResultObject addContact(ExternalInfo contact);

    /**
     * 更新外部联系人
     *
     * @param contact
     * @return
     */
    ResultObject updateContact(ExternalInfo contact);

    /**
     * 修改外部联系人可用状态(逻辑删除)
     *
     * @param contactCode 外部联系人编号
     * @return
     */
    ResultObject removeContact(String contactCode);

}
