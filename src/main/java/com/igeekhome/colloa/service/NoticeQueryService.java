package com.igeekhome.colloa.service;

import com.igeekhome.colloa.dto.NoticeInfoDTO;
import com.igeekhome.colloa.util.ResultObject;
import com.igeekhome.colloa.util.TableDataNode;

/**
 * 公告查询接口
 */

public interface NoticeQueryService {

    /**
     * 1.查询所有公告
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryAllNotice(Integer page,
                                 Integer limit);

    /**
     * 2.查询新闻资讯
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryNewsNotice(Integer page,
                                  Integer limit);

    /**
     * 3.查询通知公告
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryInformNotice(Integer page,
                                    Integer limit);

    /**
     * 4.查询规章制度
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryRulesNotice(Integer page,
                                   Integer limit);

    /**
     * 5.查询行业动态
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryTrendsNotice(Integer page,
                                    Integer limit);

    /**
     * 6.模糊查询（按主题、发布部门、创建时间、更新时间、关键字）
     *
     * @param page
     * @param limit
     * @param condition 条件
     * @return
     */
    TableDataNode queryNoticeByCondition(Integer page,
                                         Integer limit,
                                         NoticeInfoDTO condition);

    /**
     * 7.本周发布
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryWeekNotice(Integer page,
                                  Integer limit);

    /**
     * 8.本月发布
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryMonthNotice(Integer page,
                                   Integer limit);

    /**
     * 9.本季度发布
     *
     * @param page
     * @param limit
     * @return
     */
    TableDataNode queryQuarterNotice(Integer page,
                                     Integer limit);

    /**
     * 10.查看公告详情
     *
     * @param noticeCode 公告编号
     * @return
     */
    ResultObject queryNoticeByNoticeCode(String noticeCode);

}
