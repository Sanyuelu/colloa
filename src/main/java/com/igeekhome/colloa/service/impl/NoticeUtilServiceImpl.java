package com.igeekhome.colloa.service.impl;

import com.igeekhome.colloa.domain.*;
import com.igeekhome.colloa.dto.DepartmentInfoDTO;
import com.igeekhome.colloa.enums.DictCategoryEnum;
import com.igeekhome.colloa.mapper.DepartmentInfoMapper;
import com.igeekhome.colloa.mapper.DictCategoryMapper;
import com.igeekhome.colloa.mapper.EmployeeInfoMapper;
import com.igeekhome.colloa.service.NoticeUtilService;
import com.igeekhome.colloa.util.ResultObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NoticeUtilServiceImpl implements NoticeUtilService {

    @Autowired
    private DictCategoryMapper dictCategoryMapper;

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    @Autowired
    private DepartmentInfoMapper departmentInfoMapper;

    /**
     * Li Chuang
     */
    @Override
    public ResultObject queryNoticeCategory() {

        DictCategoryExample dictCategoryExample = new DictCategoryExample();
        dictCategoryExample.createCriteria()
                .andDictTypeIdEqualTo(DictCategoryEnum.NOTICE_TYPE.getDictTypeId());
        List<DictCategory> dictCategoryList = dictCategoryMapper.selectByExample(dictCategoryExample);
        return ResultObject.ok(dictCategoryList);
    }

    /**
     * Li Chuang
     */
    @Override
    public ResultObject queryDepartment(String editorCode) {
        // 1.根据责任人查询所在公司
        EmployeeInfoExample example = new EmployeeInfoExample();
        example.createCriteria()
                .andEmplCodeEqualTo(editorCode);
        List<EmployeeInfo> editor = employeeInfoMapper.selectByExample(example);
        // 所在公司编号
        String companyCode = editor.get(0).getCompanyCode();

        // 2.根据公司查询下属的部门列表
        // 得到的是department和dict_category表的联系
        DepartmentInfoExample departmentInfoExample = new DepartmentInfoExample();
        departmentInfoExample.createCriteria()
                .andAvailableEqualTo(DictCategoryEnum.IS_AVAILABLE.getDictTypeId())
                .andCompanyCodeEqualTo(companyCode);
        List<DepartmentInfo> departmentInfos = departmentInfoMapper.selectByExample(departmentInfoExample);
        List<String> deparCateCodeList =
                departmentInfos.stream().map(departmentInfo -> departmentInfo.getCategoryCode()).collect(Collectors.toList());

        DictCategoryExample dictCategoryExample = new DictCategoryExample();
        dictCategoryExample.createCriteria()
                .andAvailableEqualTo(DictCategoryEnum.IS_AVAILABLE.getDictTypeId())
                .andCategoryCodeIn(deparCateCodeList);
        List<DictCategory> departmentList = dictCategoryMapper.selectByExample(dictCategoryExample);
        Map<String, DictCategory> departmentMap =
                departmentList.stream().collect(Collectors.toMap(department -> department.getCategoryCode(), department -> department));

        List<DepartmentInfoDTO> departmentInfoDTOList = new ArrayList<>();
        for (DepartmentInfo info : departmentInfos) {
            DepartmentInfoDTO infoDTO = new DepartmentInfoDTO();
            BeanUtils.copyProperties(info, infoDTO);
            infoDTO.setDictCategory(departmentMap.get(info.getCategoryCode()));
            departmentInfoDTOList.add(infoDTO);
        }

        // 3.返回部门列表
        return ResultObject.ok(departmentInfoDTOList);
    }

    /**
     * Li Chuang
     */
    @Override
    public ResultObject queryEmployeeByName(String editorCode, String name) {
        EmployeeInfoExample example = new EmployeeInfoExample();
        example.createCriteria()
                .andEmplCodeEqualTo(editorCode);
        List<EmployeeInfo> editor = employeeInfoMapper.selectByExample(example);
        // 责任人所在公司编号
        String companyCode = editor.get(0).getCompanyCode();

        EmployeeInfoExample employeeInfoExample = new EmployeeInfoExample();
        employeeInfoExample.createCriteria()
                .andNameLike("%" + name + "%")
                .andCompanyCodeEqualTo(companyCode) // 本公司员工
                .andWorkStatusEqualTo(0); // 在职状态的员工
        List<EmployeeInfo> employeeInfoList = employeeInfoMapper.selectByExample(employeeInfoExample);

        return ResultObject.ok(employeeInfoList);
    }
}
