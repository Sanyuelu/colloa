package com.igeekhome.colloa.service;

import com.igeekhome.colloa.util.TableDataNode;

public interface NoticeService {
    /**
     * 1.查询所有公告
     * @return
     */
    TableDataNode queryAllNotice();
    /**
     * 2.查询新闻资讯
     * @return
     */
    TableDataNode queryNewsNotice();
    /**
     * 3.查询通知公告
     * @return
     */
    TableDataNode queryInformNotice();
    /**
     * 4.查询规章制度
     * @return
     */
    TableDataNode queryRulesNotice();
    /**
     * 5.查询行业动态
     * @return
     */
    TableDataNode queryTrendsNotice();
    /**
     * 6.模糊查询（按主题、发布部门、创建时间、更新时间、关键字）
     * @return
     */
    TableDataNode queryNoticeByCondition();
    /**
     * 7.本周发布
     * @return
     */
    TableDataNode queryWeekNotice();
    /**
     * 8.本月发布
     * @return
     */
    TableDataNode queryMonthNotice();
    /**
     * 9.本季度发布
     * @return
     */
    TableDataNode queryQuarterNotice();
    /**
     * 10.查看公告详情
     * @return
     */
    TableDataNode queryNoticeByNoticeCode();
    /**
     * 11.保存公告
     * @return
     */
    TableDataNode saveNotice();
    /**
     * 12.发布公告
     * @return
     */
    TableDataNode publishNotice();
    /**
     * 13.修改公告
     * @return
     */
    TableDataNode updateNotice();
    /**
     * 14.删除公告
     * @return
     */
    TableDataNode deleteNotice();
}
