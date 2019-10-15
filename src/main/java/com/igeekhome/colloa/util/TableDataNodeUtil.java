package com.igeekhome.colloa.util;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 封装列表数据到TableDataNode中
 */

public class TableDataNodeUtil {

    public static <T> TableDataNode getTableDataNode(List<T> list) {
        //分页对象：（当前页 总条数  总页数....）
        PageInfo<T> pageInfo = new PageInfo<>(list);
        // 参数：所有数据数目、当前页数据
        return TableDataNode.ok((int) pageInfo.getTotal(), list);
    }
}
