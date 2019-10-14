package com.igeekhome.colloa.dto;

import com.igeekhome.colloa.domain.EmployeeInfo;
import com.igeekhome.colloa.domain.MessageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 消息封装
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageInfoDTO extends MessageInfo {

    /**
     * 1.管理员查询时，employee1作为接收者,employee2作为发送者
     * 2.个人查询时，employee1作为接收者+发送者
     */
    private EmployeeInfo employee1;

    private EmployeeInfo employee2;

    /**
     * 我的身份
     */
    private EmployeeInfo self;
}
