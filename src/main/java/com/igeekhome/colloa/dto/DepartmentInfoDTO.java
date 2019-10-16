package com.igeekhome.colloa.dto;

import com.igeekhome.colloa.domain.DepartmentInfo;
import com.igeekhome.colloa.domain.DictCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装部门消息的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentInfoDTO extends DepartmentInfo {

    private DictCategory dictCategory;
}
