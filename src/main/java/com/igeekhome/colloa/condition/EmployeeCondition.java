package com.igeekhome.colloa.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 用于条件查询员工通讯信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCondition {
    //员工工号
    private String emplCode;
    //员工姓名
    private String name;

    //固定电话
    private String tel;
    //移动电话
    private String mobileTel;
    //电子邮件
    private String email;
    //微信
    private String wechat;

    //头像url
    private String avatarUrl;
    //在职状态
    private Integer workStatus;//非空，有默认值
    //简短说明
    private String selfDesc;
}
