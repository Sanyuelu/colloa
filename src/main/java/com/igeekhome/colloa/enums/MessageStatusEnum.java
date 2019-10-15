package com.igeekhome.colloa.enums;

/**
 * 消息状态枚举
 * 消息读取状态[0:未读,1:已读]
 * 消息发送状态[0:草稿箱,1:已发送]
 * 星标消息[0:非星标,1:星标]
 * 对发送者是否可见[0:不可见,1:可见]
 * 对接收者是否可见[0:不可见,1:可见]
 * 此邮件是否有效[0:无效,1:有效]
 */

public enum MessageStatusEnum {
    UNREAD("未读", 0),
    READ("已读", 1),
    DRAFT("草稿箱", 0),
    SENT("已发送", 1),
    NOT_STAR("非星标", 0),
    IS_STAR("星标", 1),
    SENDER_IS_AVAILABLE("发送者可见",1),
    SENDER_NOT_AVAILABLE("发送者不可见",0),
    RECEIVER_IS_AVAILABLE("接收者可见",1),
    RECEIVER_NOT_AVAILABLE("接收者不可见",0),
    IS_AVAILABLE("有效",1),
    NOT_AVAILABLE("无效",0),
    SENDER_DELETE("发送方删除",0),
    RECEIVER_DELETE("接收者删除",1);

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 状态码
     */
    private Integer code;

    MessageStatusEnum(String statusName, Integer code) {
        this.statusName = statusName;
        this.code = code;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
