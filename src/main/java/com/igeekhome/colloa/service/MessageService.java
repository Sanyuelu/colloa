package com.igeekhome.colloa.service;

import com.igeekhome.colloa.condition.MessageCondition;
import com.igeekhome.colloa.domain.MessageInfo;
import com.igeekhome.colloa.util.ResultObject;
import com.igeekhome.colloa.util.TableDataNode;

/**
 * 电子消息服务接口
 * 消息状态[0:未读,1:已读,2:已发送,3:草稿箱]
 * 星标消息[0:非星标,1:星标]
 */

public interface MessageService {

    /**
     * 1.检索所有未读消息[0]
     *
     * @param page
     * @param limit
     * @param receiverEmplCode 员工(消息接收人)编号
     * @return
     */
    TableDataNode queryUnReadMessage(Integer page,
                                     Integer limit,
                                     String receiverEmplCode);

    /**
     * 2.检索所有已读消息[1]
     *
     * @param page
     * @param limit
     * @param receiverEmplCode 员工(消息接收人)编号
     * @return
     */
    TableDataNode queryReadMessage(Integer page,
                                   Integer limit,
                                   String receiverEmplCode);

    /**
     * 3.检索所有已经发送的消息[2]
     *
     * @param page
     * @param limit
     * @param receiverEmplCode 员工(消息接收人)编号
     * @return
     */
    TableDataNode querySentMessage(Integer page,
                                   Integer limit,
                                   String receiverEmplCode);

    /**
     * 4.检索保存在草稿箱中的消息[3]
     *
     * @param page
     * @param limit
     * @param receiverEmplCode 员工(消息接收人)编号
     * @return
     */
    TableDataNode queryDraftMessage(Integer page,
                                    Integer limit,
                                    String receiverEmplCode);

    /**
     * 5.检索设为星标的消息
     * 星标消息[0:非星标,1:星标]
     *
     * @param page
     * @param limit
     * @param receiverEmplCode 员工(消息接收人)编号
     * @return
     */
    TableDataNode queryStarMessage(Integer page,
                                   Integer limit,
                                   String receiverEmplCode);

    /**
     * 6.模糊查询 (时间条件查询不实现)
     *
     * @param condition 查询条件[主题、收件人、发件人、时间段]
     * @return
     */
    TableDataNode queryMessageByCondition(MessageCondition condition);

    /**
     * 7.查看消息详情
     *
     * @param messageCode 消息编号
     * @return
     */
    ResultObject queryMessageByMessageCode(String messageCode);

    /**
     * 8.设置消息为已读状态
     *
     * @param messageCode 消息编号
     * @return
     */
    ResultObject setMessageToRead(String messageCode);

    /**
     * 9.将消息设为星标消息
     *
     * @param messageCode 消息编号
     * @return
     */
    ResultObject setMessageToStar(String messageCode);

    /**
     * 10.发送消息
     *
     * @param message 消息内容
     * @return
     */
    ResultObject sendMessage(MessageInfo message);

    /**
     * 11.保存消息到草稿箱
     *
     * @param message 消息内容
     * @return
     */
    ResultObject saveMessageToDraft(MessageInfo message);

    /**
     * 12.删除消息记录(逻辑删除,标记信息为不可读状态)
     *
     * @param messageCode 消息编号
     * @return
     */
    ResultObject removeMessage(String messageCode);

}
