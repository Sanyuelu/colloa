package com.igeekhome.colloa.enums;

/**
 * 公告状态枚举
 * 公告发送状态[0:未发送,1:已发送]
 * 此公告是否有效[0:无效,1:有效]
 */

public enum NoticeEnum {
    NOT_PUBLISH("未发布", 0),
    PUBLISH("已发布", 1),
    NOT_AVAILABLE("无效", 0),
    IS_AVAILABLE("有效", 1),
    NEWS_CATEGORY("新闻资讯", "10001"),
    INFORM_CATEGORY("通知公告", "10002"),
    RULES_CATEGORY("规章制度", "10003"),
    TRENDS_CATEGORY("行业动态", "10004"),
    ;

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 公告类别名称
     */
    private String categoryName;

    /**
     * 公告类别编号
     */
    private String categoryCode;

    NoticeEnum(String statusName, Integer code) {
        this.statusName = statusName;
        this.code = code;
    }

    NoticeEnum(String categoryName, String categoryCode) {
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
