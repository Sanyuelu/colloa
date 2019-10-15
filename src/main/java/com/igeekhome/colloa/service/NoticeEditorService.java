package com.igeekhome.colloa.service;

import com.igeekhome.colloa.domain.NoticeInfo;
import com.igeekhome.colloa.util.ResultObject;

import java.util.List;

/**
 * 公告的增、删、改
 */

public interface NoticeEditorService {

    /**
     * 1.保存公告
     *
     * @param noticeInfo          公告信息
     * @param participantCodeList 参与人的工号
     * @return
     */
    ResultObject saveNotice(NoticeInfo noticeInfo,
                            List<String> participantCodeList);

    /**
     * 2.发布公告
     *
     * @param noticeInfo 公告信息
     * @return
     */
    ResultObject publishNotice(NoticeInfo noticeInfo,
                               List<String> participantCodeList);

    /**
     * 3.修改公告
     *
     * @param noticeInfo          公告信息
     * @param participantCodeList
     * @return
     */
    ResultObject updateNotice(NoticeInfo noticeInfo,
                              List<String> participantCodeList);

    /**
     * 4.删除公告
     *
     * @param noticeCode 公告编号
     * @return
     */
    ResultObject deleteNotice(String noticeCode);

}
