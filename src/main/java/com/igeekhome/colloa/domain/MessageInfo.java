package com.igeekhome.colloa.domain;

import java.util.Date;

public class MessageInfo {
    private Long id;

    private String messageCode;

    private String senderCode;

    private String receiverCode;

    private String theme;

    private String content;

    private String fileUrl;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private Integer isStar;

    private Integer priority;

    private Integer senderAvaliable;

    private Integer receiverAvaliable;

    private Integer avaliable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode == null ? null : messageCode.trim();
    }

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode == null ? null : senderCode.trim();
    }

    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode == null ? null : receiverCode.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsStar() {
        return isStar;
    }

    public void setIsStar(Integer isStar) {
        this.isStar = isStar;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getSenderAvaliable() {
        return senderAvaliable;
    }

    public void setSenderAvaliable(Integer senderAvaliable) {
        this.senderAvaliable = senderAvaliable;
    }

    public Integer getReceiverAvaliable() {
        return receiverAvaliable;
    }

    public void setReceiverAvaliable(Integer receiverAvaliable) {
        this.receiverAvaliable = receiverAvaliable;
    }

    public Integer getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(Integer avaliable) {
        this.avaliable = avaliable;
    }
}