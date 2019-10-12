package com.igeekhome.colloa.service.impl;

import com.github.pagehelper.PageHelper;
import com.igeekhome.colloa.domain.DictCategory;
import com.igeekhome.colloa.domain.DictCategoryExample;
import com.igeekhome.colloa.domain.ExternalInfo;
import com.igeekhome.colloa.domain.ExternalInfoExample;
import com.igeekhome.colloa.enums.DictCategoryEnum;
import com.igeekhome.colloa.mapper.DictCategoryMapper;
import com.igeekhome.colloa.mapper.ExternalInfoMapper;
import com.igeekhome.colloa.service.ExternalPhoneBookService;
import com.igeekhome.colloa.util.ResultObject;
import com.igeekhome.colloa.util.TableDataNode;
import com.igeekhome.colloa.util.TableDataNodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ExternalPhoneBookServiceImpl implements ExternalPhoneBookService {

    @Autowired
    private ExternalInfoMapper externalInfoMapper;
    @Autowired
    private DictCategoryMapper dictCategoryMapper;

    @Override
    public ResultObject queryAllCategory() {
        DictCategoryExample example = new DictCategoryExample();
        example.createCriteria()
                .andDictTypeIdEqualTo(DictCategoryEnum.EXTERNAL.getDictTypeId())
                .andAvailableEqualTo(1); // 搜索状态为可用的类别
        List<DictCategory> categoryList = dictCategoryMapper.selectByExample(example);
        return ResultObject.build(200, "成功", categoryList);
    }

    @Override
    public TableDataNode queryAllContacts(Integer page, Integer limit) {
        //开启分页查询
        PageHelper.startPage(page, limit);
        //从数据库查询
        ExternalInfoExample example = new ExternalInfoExample();
        // 搜索状态为可用的联系人信息
        example.createCriteria().andAvailableEqualTo(1);
        List<ExternalInfo> externalInfoList = externalInfoMapper.selectByExample(example);
        //获取页面显示数据并返回
        return TableDataNodeUtil.getTableDataNode(externalInfoList);
    }

    @Override
    public TableDataNode queryContactsByCategory(Integer page, Integer limit, String cateCode) {
        //开启分页查询
        PageHelper.startPage(page, limit);
        //从数据库查询
        ExternalInfoExample example = new ExternalInfoExample();
        example.createCriteria()
                .andCategoryCodeEqualTo(cateCode)
                .andAvailableEqualTo(1); // 搜索状态为可用的联系人信息
        List<ExternalInfo> externalInfoList = externalInfoMapper.selectByExample(example);
        //获取页面显示数据并返回
        return TableDataNodeUtil.getTableDataNode(externalInfoList);
    }

    @Override
    public TableDataNode queryContactsByCondition(Integer page, Integer limit, ExternalInfo condition) {

        //开启分页查询
        PageHelper.startPage(page, limit);

        ExternalInfoExample example = new ExternalInfoExample();
        ExternalInfoExample.Criteria criteria = example.createCriteria();
        // 搜索状态为可用的联系人信息
        criteria.andAvailableEqualTo(1);
        // 判断是否输入名称
        if (condition.getName() != null && !condition.getName().equals("")) {
            criteria.andNameLike("%" + condition.getName() + "%");
        }
        // 判断是否输入公司名称
        if (condition.getCompanyName() != null && !condition.getCompanyName().equals("")) {
            criteria.andCompanyNameLike("%" + condition.getCompanyName() + "%");
        }
        // 判断是否输入固定电话
        if (condition.getTel() != null && !condition.getTel().equals("")) {
            criteria.andTelLike("%" + condition.getTel() + "%");
        }
        // 判断是否输入移动电话
        if (condition.getMobileTel() != null && !condition.getMobileTel().equals("")) {
            criteria.andMobileTelLike("%" + condition.getMobileTel() + "%");
        }
        // 判断是否输入电子邮件
        if (condition.getEmail() != null && !condition.getEmail().equals("")) {
            criteria.andEmailLike("%" + condition.getEmail() + "%");
        }
        // 判断是否输入微信号
        if (condition.getWechat() != null && !condition.getWechat().equals("")) {
            criteria.andWechatLike("%" + condition.getWechat() + "%");
        }
        List<ExternalInfo> externalInfoList = externalInfoMapper.selectByExample(example);
        //获取页面显示数据并返回
        return TableDataNodeUtil.getTableDataNode(externalInfoList);
    }

    @Override
    public ResultObject addContact(ExternalInfo contact) {
        /**
         * 1.参数检查
         */
        if (null == contact || null == contact.getCategoryCode()){
            return ResultObject.fail(500,"参数有误");
        }
        /**
         * 2.检查是否有此服务类别
         */
        //自定义条件进行查询
        DictCategoryExample dictCategoryExample = new DictCategoryExample();
        DictCategoryExample.Criteria externalCategoryExampleCriteria = dictCategoryExample.createCriteria();
        externalCategoryExampleCriteria.andCategoryCodeEqualTo(contact.getCategoryCode());
        List<DictCategory> externalCategoryList = dictCategoryMapper.selectByExample(dictCategoryExample);
        if (null == externalCategoryList || 0 == externalCategoryList.size()){
            return ResultObject.fail(500,"该服务类别不存在");
        }
        /**
         * 3.添加 ExternalInfo
         */
        contact.setContactCode(UUID.randomUUID().toString().replace("-",""));
        contact.setCreateTime(new Date());
        contact.setUpdateTime(new Date());
        int effectedNum = 0;
        try {
            effectedNum = externalInfoMapper.insertSelective(contact);
        }catch (Exception e){
            return ResultObject.fail(500,e.getMessage());
        }
        if (effectedNum <= 0){
            return ResultObject.fail(500,"操作失败");
        }
        return ResultObject.ok();
    }

    @Override
    public ResultObject updateContact(ExternalInfo contact) {
        /**
         * 1.参数检查
         */
        if (null == contact || null == contact.getContactCode()){
            return ResultObject.fail(500,"参数有误");
        }
        /**
         * 2.检查是否有此服务通讯录
         */
        //自定义条件进行查询
        ExternalInfoExample externalInfoExample = new ExternalInfoExample();
        ExternalInfoExample.Criteria externalInfoExampleCriteria = externalInfoExample.createCriteria();
        externalInfoExampleCriteria.andContactCodeEqualTo(contact.getContactCode());
        List<ExternalInfo> externalInfoList = externalInfoMapper.selectByExample(externalInfoExample);
        if (null == externalInfoList || 0 == externalInfoList.size()){
            return ResultObject.fail(500,"该服务通讯录不存在");
        }
        /**
         * 3.更新通讯录
         */
        ExternalInfo queryExternalInfo = externalInfoList.get(0);
        contact.setId(queryExternalInfo.getId());
        contact.setCategoryCode(queryExternalInfo.getCategoryCode());
        contact.setUpdateTime(new Date());
        int effectedNum = externalInfoMapper.updateByExampleSelective(contact,externalInfoExample);
        if (effectedNum <= 0){
            return ResultObject.fail(500,"操作失败");
        }
        return ResultObject.ok();
    }

    @Override
    public ResultObject removeContact(String contactCode) {
        /**
         * 1.参数检查
         */
        if (null == contactCode){
            return ResultObject.fail(500,"参数有误");
        }
        /**
         * 2.检查是否有此服务通讯录
         */
        //自定义条件进行查询
        ExternalInfoExample externalInfoExample = new ExternalInfoExample();
        ExternalInfoExample.Criteria externalInfoExampleCriteria = externalInfoExample.createCriteria();
        externalInfoExampleCriteria.andContactCodeEqualTo(contactCode);
        List<ExternalInfo> externalInfoList = externalInfoMapper.selectByExample(externalInfoExample);
        if (null == externalInfoList || 0 == externalInfoList.size()){
            return ResultObject.fail(500,"该服务通讯录不存在！");
        }
        /**
         * 3.将此外部通讯录设为不可用（逻辑删除）
         */
        ExternalInfo queryExternalInfo = externalInfoList.get(0);
        queryExternalInfo.setAvailable(0);//[0:不可用,1:可用]
        int effectedNum = externalInfoMapper.updateByExample(queryExternalInfo,externalInfoExample);
        if(effectedNum <= 0){
            return ResultObject.fail(500,"删除失败！");
        }
        return ResultObject.ok();
    }
}
