package com.igeekhome.colloa.dto;

import com.igeekhome.colloa.domain.DepartmentInfo;
import com.igeekhome.colloa.domain.EmployeeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePhoneBookDTO extends EmployeeInfo {
    //员工所属部门
    private DepartmentInfo departmentInfo;
}
