package com.igeekhome.colloa.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LayUI Table 数据项
 * {"code":0,"msg":"","count":1000,"data"}
 * 此类用于分页向页面传输员工通讯的信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableDataNode {
    /**
     * 状态 0 成功
     */
    private Integer code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 数据的总条数
     */
    private Integer count;
    /**
     * 当前需要显示的数据
     */
    private Object data;

    public static TableDataNode ok(Integer count, Object data){
        return new TableDataNode(0,"成功",count,data);
    }
}

