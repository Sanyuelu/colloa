package com.igeekhome.colloa.service.impl;

import com.github.pagehelper.PageHelper;
import com.igeekhome.colloa.domain.*;
import com.igeekhome.colloa.dto.NoticeInfoDTO;
import com.igeekhome.colloa.enums.DictCategoryEnum;
import com.igeekhome.colloa.enums.MessageStatusEnum;
import com.igeekhome.colloa.enums.NoticeEnum;
import com.igeekhome.colloa.mapper.*;
import com.igeekhome.colloa.service.NoticeQueryService;
import com.igeekhome.colloa.util.CheckNullParameter;
import com.igeekhome.colloa.util.ResultObject;
import com.igeekhome.colloa.util.TableDataNode;
import com.igeekhome.colloa.util.TableDataNodeUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoticeQueryServiceImpl1 implements NoticeQueryService {

    @Autowired
    private NoticeInfoMapper noticeInfoMapper;
    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;
    @Autowired
    private DepartmentInfoMapper departmentInfoMapper;
    @Autowired
    private DictCategoryMapper dictCategoryMapper;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    /**
     * @Author muyaqi
     * @param page
     * @param limit
     * @return
     */
    @Override
    public TableDataNode queryAllNotice(Integer page, Integer limit) {
        /**
         * 1.检查参数
         */
        if (CheckNullParameter.haveNullParameter(page,limit)){
            return TableDataNode.ok(0,null);
        }
        /**
         * 2.开始查询
         */
        PageHelper.startPage(page,limit);
        List<NoticeInfoDTO> noticeInfoDTOList = null;
        try {
            NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
            noticeInfoExample.setOrderByClause("priority DESC,update_time DESC");
            noticeInfoExample.createCriteria()
                    .andAvaliableEqualTo(1);
            noticeInfoDTOList = noticeInfoMapper.selectDTOByExampleWithBLOBs(noticeInfoExample);
        }catch (Exception e){
            return TableDataNode.ok(0,null);
        }
        /**
         * 3.封装数据并返回
         */
        if (null != noticeInfoDTOList && 0 != noticeInfoDTOList.size()){
            noticeInfoDTOList = getNoticeInfoDTOList1(noticeInfoDTOList);
        }
        return TableDataNodeUtil.getTableDataNode(noticeInfoDTOList);
    }

    /**
     * @Author muyaqi
     * @param page
     * @param limit
     * @return
     */
    @Override
    public TableDataNode queryNewsNotice(Integer page, Integer limit) {
        /**
         * 1.检查参数
         */
        if (CheckNullParameter.haveNullParameter(page,limit)){
            return TableDataNode.ok(0,null);
        }
        /**
         * 2.开始查询
         */
        PageHelper.startPage(page,limit);
        List<NoticeInfoDTO> noticeInfoDTOList = null;
        try {
            NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
            noticeInfoExample.setOrderByClause("priority DESC,update_time DESC");
            noticeInfoExample.createCriteria()
                    .andCategoryCodeEqualTo(NoticeEnum.NEWS_CATEGORY.getCategoryCode())
                    .andAvaliableEqualTo(NoticeEnum.IS_AVAILABLE.getCode());
            noticeInfoDTOList = noticeInfoMapper.selectDTOByExampleWithBLOBs(noticeInfoExample);
        }catch (Exception e){
            return TableDataNode.ok(0,null);
        }
        /**
         * 3.封装数据并返回
         */
        if (null != noticeInfoDTOList && 0 != noticeInfoDTOList.size()){
            noticeInfoDTOList = getNoticeInfoDTOList1(noticeInfoDTOList);
        }
        return TableDataNodeUtil.getTableDataNode(noticeInfoDTOList);
    }

    /**
     * @Author muyaqi
     * @param page
     * @param limit
     * @return
     */
    @Override
    public TableDataNode queryInformNotice(Integer page, Integer limit) {
        /**
         * 1.检查参数
         */
        if (CheckNullParameter.haveNullParameter(page,limit)){
            return TableDataNode.ok(0,null);
        }
        /**
         * 2.开始查询
         */
        PageHelper.startPage(page,limit);
        List<NoticeInfoDTO> noticeInfoDTOList = null;
        try {
            NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
            noticeInfoExample.setOrderByClause("priority DESC,update_time DESC");
            noticeInfoExample.createCriteria()
                    .andCategoryCodeEqualTo(NoticeEnum.INFORM_CATEGORY.getCategoryCode())
                    .andAvaliableEqualTo(NoticeEnum.IS_AVAILABLE.getCode());
            noticeInfoDTOList = noticeInfoMapper.selectDTOByExampleWithBLOBs(noticeInfoExample);
        }catch (Exception e){
            return TableDataNode.ok(0,null);
        }
        /**
         * 3.封装数据并返回
         */
        if (null != noticeInfoDTOList && 0 != noticeInfoDTOList.size()){
            noticeInfoDTOList = getNoticeInfoDTOList1(noticeInfoDTOList);
        }
        return TableDataNodeUtil.getTableDataNode(noticeInfoDTOList);
    }

    /**
     * @Author muyaqi
     * @param page
     * @param limit
     * @return
     */
    @Override
    public TableDataNode queryRulesNotice(Integer page, Integer limit) {
        /**
         * 1.检查参数
         */
        if (CheckNullParameter.haveNullParameter(page,limit)){
            return TableDataNode.ok(0,null);
        }
        /**
         * 2.开始查询
         */
        PageHelper.startPage(page,limit);
        List<NoticeInfoDTO> noticeInfoDTOList = null;
        try {
            NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
            noticeInfoExample.setOrderByClause("priority DESC,update_time DESC");
            noticeInfoExample.createCriteria()
                    .andCategoryCodeEqualTo(NoticeEnum.RULES_CATEGORY.getCategoryCode())
                    .andAvaliableEqualTo(NoticeEnum.IS_AVAILABLE.getCode());
            noticeInfoDTOList = noticeInfoMapper.selectDTOByExampleWithBLOBs(noticeInfoExample);
        }catch (Exception e){
            return TableDataNode.ok(0,null);
        }
        /**
         * 3.封装数据并返回
         */
        if (null != noticeInfoDTOList && 0 != noticeInfoDTOList.size()){
            noticeInfoDTOList = getNoticeInfoDTOList1(noticeInfoDTOList);
        }
        return TableDataNodeUtil.getTableDataNode(noticeInfoDTOList);
    }

    /**
     * @Author muyaqi
     * @param page
     * @param limit
     * @return
     */
    @Override
    public TableDataNode queryTrendsNotice(Integer page, Integer limit) {
        /**
         * 1.检查参数
         */
        if (CheckNullParameter.haveNullParameter(page,limit)){
            return TableDataNode.ok(0,null);
        }
        /**
         * 2.开始查询
         */
        PageHelper.startPage(page,limit);
        List<NoticeInfoDTO> noticeInfoDTOList = null;
        try {
            NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
            noticeInfoExample.setOrderByClause("priority DESC,update_time DESC");
            noticeInfoExample.createCriteria()
                    .andCategoryCodeEqualTo(NoticeEnum.TRENDS_CATEGORY.getCategoryCode())
                    .andAvaliableEqualTo(NoticeEnum.IS_AVAILABLE.getCode());
            noticeInfoDTOList = noticeInfoMapper.selectDTOByExampleWithBLOBs(noticeInfoExample);
        }catch (Exception e){
            return TableDataNode.ok(0,null);
        }
        /**
         * 3.封装数据并返回
         */
        if (null != noticeInfoDTOList && 0 != noticeInfoDTOList.size()){
            noticeInfoDTOList = getNoticeInfoDTOList1(noticeInfoDTOList);
        }
        return TableDataNodeUtil.getTableDataNode(noticeInfoDTOList);
    }

    /**
     * @Author muyaqi
     * @param page
     * @param limit
     * @param condition 条件
     * @return
     */
    @Override
    public TableDataNode queryNoticeByCondition(Integer page, Integer limit, NoticeInfoDTO condition) {
        /**
         * 1.参数检查
         */
        if (CheckNullParameter.haveNullParameter(page, limit, condition)) {
            return TableDataNode.ok(0, null);
        }
        /**
         * 2.判断是否根据 发布部门 查询
         */
        String depaName = null;
        if (null != condition.getDepartment() && null != condition.getDepartment().getCategoryName()) {
            depaName = condition.getDepartment().getCategoryName();
        }
        List<DictCategory> depaCategoryList = null;
        if (StringUtils.isNotBlank(depaName)) {
            DictCategoryExample dictCategoryExample = new DictCategoryExample();
            dictCategoryExample.createCriteria()
                    .andAvailableEqualTo(DictCategoryEnum.IS_AVAILABLE.getDictTypeId())
                    .andCategoryNameLike("%" + depaName + "%");
            depaCategoryList = dictCategoryMapper.selectByExample(dictCategoryExample);
        }
        List<String> depaCategoryCodeList = new ArrayList<>();
        if (null != depaCategoryList && 0 != depaCategoryList.size()){
            for (DictCategory depaCategory : depaCategoryList){
                if (null != depaCategory.getDictTypeId()
                        && DictCategoryEnum.DEPARTMENT.getDictTypeId() == depaCategory.getDictTypeId()
                        && null != depaCategory.getCategoryCode()){
                    depaCategoryCodeList.add(depaCategory.getCategoryCode());
                }
            }
        }
        List<DepartmentInfo> depaList = null;
        if (null != depaCategoryCodeList && 0 != depaCategoryCodeList.size()){
            DepartmentInfoExample departmentInfoExample = new DepartmentInfoExample();
            departmentInfoExample.createCriteria()
                    .andAvailableEqualTo(1)
                    .andCategoryCodeIn(depaCategoryCodeList);
            depaList = departmentInfoMapper.selectByExample(departmentInfoExample);
        }
        List<String> depaCodeList = new ArrayList<>();
        if (null != depaList && 0 != depaList.size()){
            for (DepartmentInfo depa : depaList){
                depaCodeList.add(depa.getDepaCode());
            }
        }
        /**
         * 3.查询公告列表
         */
        PageHelper.startPage(page,limit);
        List<NoticeInfoDTO> noticeInfoDTOList = null;
        try {
            NoticeInfoExample noticeInfoExample = new NoticeInfoExample();
            noticeInfoExample.setOrderByClause("priority DESC,update_time DESC");
            NoticeInfoExample.Criteria noticeCriteria = noticeInfoExample.createCriteria();
            noticeCriteria.andAvaliableEqualTo(NoticeEnum.IS_AVAILABLE.getCode());
            //模糊查询（按主题、发布部门、创建时间、更新时间、关键字）
            if (StringUtils.isNotBlank(condition.getNoticeName())){
                noticeCriteria.andNoticeNameLike("%" + condition.getNoticeName() + "%");
            }
            if (null !=  depaCodeList && 0 != depaCodeList.size()){
                noticeCriteria.andDepaCodeIn(depaCodeList);
            }
            if (StringUtils.isNotBlank(condition.getKeyWord())){
                noticeCriteria.andKeyWordLike("%" + condition.getKeyWord() + "%");
            }
            noticeInfoDTOList = noticeInfoMapper.selectDTOByExampleWithBLOBs(noticeInfoExample);
        }catch (Exception e){
            return TableDataNode.ok(0,null);
        }
        /**
         * 4.封装数据并返回
         */
        if (null != noticeInfoDTOList && 0 != noticeInfoDTOList.size()){
            noticeInfoDTOList = getNoticeInfoDTOList1(noticeInfoDTOList);
        }
        return TableDataNodeUtil.getTableDataNode(noticeInfoDTOList);
    }

    @Override
    public TableDataNode queryWeekNotice(Integer page, Integer limit) {
        return null;
    }

    @Override
    public TableDataNode queryMonthNotice(Integer page, Integer limit) {
        return null;
    }

    @Override
    public TableDataNode queryQuarterNotice(Integer page, Integer limit) {
        return null;
    }

    @Override
    public ResultObject queryNoticeByNoticeCode(String noticeCode) {
        return null;
    }

    /**
     * 封装公告数据1
     *
     * @Author muyaqi
     *
     * @param noticeInfoDTOList
     * @return
     */
    private List<NoticeInfoDTO> getNoticeInfoDTOList1(List<NoticeInfoDTO> noticeInfoDTOList) {
        /**
         * 1.获取责任人Code集合(editorCodeSet)、部门Code集合(depaCodeSet)
         */
        Set<String> editorCodeSet = new HashSet<>();
        Set<String> depaCodeSet = new HashSet<>();
        for (NoticeInfoDTO noticeInfoDTO : noticeInfoDTOList) {
            editorCodeSet.add(noticeInfoDTO.getEditorCode());
            depaCodeSet.add(noticeInfoDTO.getDepaCode());
        }
        /**
         * 2.获取 责任人集合(editorList),部门集合(depaList)
         */
        List<String> editorCodeList = new ArrayList<>();
        editorCodeList.addAll(depaCodeSet);
        EmployeeInfoExample employeeInfoExample = new EmployeeInfoExample();
        employeeInfoExample.createCriteria()
                .andAvailableEqualTo(MessageStatusEnum.IS_AVAILABLE.getCode())
                .andEmplCodeIn(editorCodeList);
        List<EmployeeInfo> editorList = employeeInfoMapper.selectByExample(employeeInfoExample);

        List<String> depaCodeList = new ArrayList<>();
        depaCodeList.addAll(depaCodeSet);
        DepartmentInfoExample departmentInfoExample = new DepartmentInfoExample();
        departmentInfoExample.createCriteria()
                .andAvailableEqualTo(1)
                .andDepaCodeIn(depaCodeList);
        List<DepartmentInfo> depaList = departmentInfoMapper.selectByExample(departmentInfoExample);
        /**
         * 3.根据 部门集合(depaList) 获取 公司集合(CompanyList) 及 部门类别集合(DepaCategoryList)
         */
        Set<String> companyCodeSet = new HashSet<>();
        Set<String> depaCategoryCodeSet = new HashSet<>();
        for (DepartmentInfo depa : depaList){
            companyCodeSet.add(depa.getCompanyCode());
            depaCategoryCodeSet.add(depa.getCategoryCode());
        }

        List<String> companyCodeList = new ArrayList<>();
        companyCodeList.addAll(companyCodeSet);
        CompanyInfoExample companyInfoExample = new CompanyInfoExample();
        companyInfoExample.createCriteria()
                .andAvailableEqualTo(1)
                .andCompanyCodeIn(companyCodeList);
        List<CompanyInfo> companyInfoList = companyInfoMapper.selectByExample(companyInfoExample);

        List<String> depaCategoryCodeList = new ArrayList<>();
        depaCategoryCodeList.addAll(depaCategoryCodeSet);
        DictCategoryExample dictCategoryExample = new DictCategoryExample();
        dictCategoryExample.createCriteria()
                .andAvailableEqualTo(1)
                .andCategoryCodeIn(depaCategoryCodeList);
        List<DictCategory> depaCategoryList = dictCategoryMapper.selectByExample(dictCategoryExample);
        /**
         * 4.获取 责任人Map集合,部门Map集合,公司Map集合,部门类别Map集合
         */
        Map<String,EmployeeInfo> editorMap = new HashMap<>();
        for (EmployeeInfo editor : editorList) {
            editorMap.put(editor.getEmplCode(), editor);
        }
        Map<String,DepartmentInfo> depaMap = new HashMap<>();
        for (DepartmentInfo depa : depaList) {
            depaMap.put(depa.getDepaCode(), depa);
        }
        Map<String,CompanyInfo> companyMap  = new HashMap<>();
        for (CompanyInfo company : companyInfoList) {
            companyMap.put(company.getCompanyCode(), company);
        }
        Map<String,DictCategory> depaCategoryMap = new HashMap<>();
        for (DictCategory depaCategory : depaCategoryList) {
            depaCategoryMap.put(depaCategory.getCategoryCode(), depaCategory);
        }
        /**
         * 5.封装 noticeInfoDTOList
         */
        int len = noticeInfoDTOList.size();
        List<NoticeInfoDTO> returnNoticeInfoDTOList = new ArrayList<>();
        for (NoticeInfoDTO noticeInfoDTO : noticeInfoDTOList) {
            noticeInfoDTO.setEditor(editorMap.get(noticeInfoDTO.getEditorCode()));
            noticeInfoDTO.setCompany(companyMap.get(depaMap.get(noticeInfoDTO.getDepaCode()).getCompanyCode()));
            noticeInfoDTO.setDepartment(depaCategoryMap.get(depaMap.get(noticeInfoDTO.getDepaCode()).getCategoryCode()));
            returnNoticeInfoDTOList.add(noticeInfoDTO);
        }
        return returnNoticeInfoDTOList;
    }
}