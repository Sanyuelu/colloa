package com.igeekhome.colloa.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMessageCodeIsNull() {
            addCriterion("message_code is null");
            return (Criteria) this;
        }

        public Criteria andMessageCodeIsNotNull() {
            addCriterion("message_code is not null");
            return (Criteria) this;
        }

        public Criteria andMessageCodeEqualTo(String value) {
            addCriterion("message_code =", value, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeNotEqualTo(String value) {
            addCriterion("message_code <>", value, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeGreaterThan(String value) {
            addCriterion("message_code >", value, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeGreaterThanOrEqualTo(String value) {
            addCriterion("message_code >=", value, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeLessThan(String value) {
            addCriterion("message_code <", value, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeLessThanOrEqualTo(String value) {
            addCriterion("message_code <=", value, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeLike(String value) {
            addCriterion("message_code like", value, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeNotLike(String value) {
            addCriterion("message_code not like", value, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeIn(List<String> values) {
            addCriterion("message_code in", values, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeNotIn(List<String> values) {
            addCriterion("message_code not in", values, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeBetween(String value1, String value2) {
            addCriterion("message_code between", value1, value2, "messageCode");
            return (Criteria) this;
        }

        public Criteria andMessageCodeNotBetween(String value1, String value2) {
            addCriterion("message_code not between", value1, value2, "messageCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeIsNull() {
            addCriterion("sender_code is null");
            return (Criteria) this;
        }

        public Criteria andSenderCodeIsNotNull() {
            addCriterion("sender_code is not null");
            return (Criteria) this;
        }

        public Criteria andSenderCodeEqualTo(String value) {
            addCriterion("sender_code =", value, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeNotEqualTo(String value) {
            addCriterion("sender_code <>", value, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeGreaterThan(String value) {
            addCriterion("sender_code >", value, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sender_code >=", value, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeLessThan(String value) {
            addCriterion("sender_code <", value, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeLessThanOrEqualTo(String value) {
            addCriterion("sender_code <=", value, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeLike(String value) {
            addCriterion("sender_code like", value, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeNotLike(String value) {
            addCriterion("sender_code not like", value, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeIn(List<String> values) {
            addCriterion("sender_code in", values, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeNotIn(List<String> values) {
            addCriterion("sender_code not in", values, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeBetween(String value1, String value2) {
            addCriterion("sender_code between", value1, value2, "senderCode");
            return (Criteria) this;
        }

        public Criteria andSenderCodeNotBetween(String value1, String value2) {
            addCriterion("sender_code not between", value1, value2, "senderCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeIsNull() {
            addCriterion("receiver_code is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeIsNotNull() {
            addCriterion("receiver_code is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeEqualTo(String value) {
            addCriterion("receiver_code =", value, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeNotEqualTo(String value) {
            addCriterion("receiver_code <>", value, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeGreaterThan(String value) {
            addCriterion("receiver_code >", value, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_code >=", value, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeLessThan(String value) {
            addCriterion("receiver_code <", value, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeLessThanOrEqualTo(String value) {
            addCriterion("receiver_code <=", value, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeLike(String value) {
            addCriterion("receiver_code like", value, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeNotLike(String value) {
            addCriterion("receiver_code not like", value, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeIn(List<String> values) {
            addCriterion("receiver_code in", values, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeNotIn(List<String> values) {
            addCriterion("receiver_code not in", values, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeBetween(String value1, String value2) {
            addCriterion("receiver_code between", value1, value2, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andReceiverCodeNotBetween(String value1, String value2) {
            addCriterion("receiver_code not between", value1, value2, "receiverCode");
            return (Criteria) this;
        }

        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }

        public Criteria andThemeEqualTo(String value) {
            addCriterion("theme =", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(String value) {
            addCriterion("theme <>", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(String value) {
            addCriterion("theme >", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addCriterion("theme >=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(String value) {
            addCriterion("theme <", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(String value) {
            addCriterion("theme <=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLike(String value) {
            addCriterion("theme like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(String value) {
            addCriterion("theme not like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeIn(List<String> values) {
            addCriterion("theme in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<String> values) {
            addCriterion("theme not in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(String value1, String value2) {
            addCriterion("theme between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(String value1, String value2) {
            addCriterion("theme not between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNull() {
            addCriterion("file_url is null");
            return (Criteria) this;
        }

        public Criteria andFileUrlIsNotNull() {
            addCriterion("file_url is not null");
            return (Criteria) this;
        }

        public Criteria andFileUrlEqualTo(String value) {
            addCriterion("file_url =", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotEqualTo(String value) {
            addCriterion("file_url <>", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThan(String value) {
            addCriterion("file_url >", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlGreaterThanOrEqualTo(String value) {
            addCriterion("file_url >=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThan(String value) {
            addCriterion("file_url <", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLessThanOrEqualTo(String value) {
            addCriterion("file_url <=", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlLike(String value) {
            addCriterion("file_url like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotLike(String value) {
            addCriterion("file_url not like", value, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlIn(List<String> values) {
            addCriterion("file_url in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotIn(List<String> values) {
            addCriterion("file_url not in", values, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlBetween(String value1, String value2) {
            addCriterion("file_url between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andFileUrlNotBetween(String value1, String value2) {
            addCriterion("file_url not between", value1, value2, "fileUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIsStarIsNull() {
            addCriterion("is_star is null");
            return (Criteria) this;
        }

        public Criteria andIsStarIsNotNull() {
            addCriterion("is_star is not null");
            return (Criteria) this;
        }

        public Criteria andIsStarEqualTo(Integer value) {
            addCriterion("is_star =", value, "isStar");
            return (Criteria) this;
        }

        public Criteria andIsStarNotEqualTo(Integer value) {
            addCriterion("is_star <>", value, "isStar");
            return (Criteria) this;
        }

        public Criteria andIsStarGreaterThan(Integer value) {
            addCriterion("is_star >", value, "isStar");
            return (Criteria) this;
        }

        public Criteria andIsStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_star >=", value, "isStar");
            return (Criteria) this;
        }

        public Criteria andIsStarLessThan(Integer value) {
            addCriterion("is_star <", value, "isStar");
            return (Criteria) this;
        }

        public Criteria andIsStarLessThanOrEqualTo(Integer value) {
            addCriterion("is_star <=", value, "isStar");
            return (Criteria) this;
        }

        public Criteria andIsStarIn(List<Integer> values) {
            addCriterion("is_star in", values, "isStar");
            return (Criteria) this;
        }

        public Criteria andIsStarNotIn(List<Integer> values) {
            addCriterion("is_star not in", values, "isStar");
            return (Criteria) this;
        }

        public Criteria andIsStarBetween(Integer value1, Integer value2) {
            addCriterion("is_star between", value1, value2, "isStar");
            return (Criteria) this;
        }

        public Criteria andIsStarNotBetween(Integer value1, Integer value2) {
            addCriterion("is_star not between", value1, value2, "isStar");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableIsNull() {
            addCriterion("sender_available is null");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableIsNotNull() {
            addCriterion("sender_available is not null");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableEqualTo(Integer value) {
            addCriterion("sender_available =", value, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableNotEqualTo(Integer value) {
            addCriterion("sender_available <>", value, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableGreaterThan(Integer value) {
            addCriterion("sender_available >", value, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableGreaterThanOrEqualTo(Integer value) {
            addCriterion("sender_available >=", value, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableLessThan(Integer value) {
            addCriterion("sender_available <", value, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableLessThanOrEqualTo(Integer value) {
            addCriterion("sender_available <=", value, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableIn(List<Integer> values) {
            addCriterion("sender_available in", values, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableNotIn(List<Integer> values) {
            addCriterion("sender_available not in", values, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableBetween(Integer value1, Integer value2) {
            addCriterion("sender_available between", value1, value2, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andSenderAvailableNotBetween(Integer value1, Integer value2) {
            addCriterion("sender_available not between", value1, value2, "senderAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableIsNull() {
            addCriterion("receiver_available is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableIsNotNull() {
            addCriterion("receiver_available is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableEqualTo(Integer value) {
            addCriterion("receiver_available =", value, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableNotEqualTo(Integer value) {
            addCriterion("receiver_available <>", value, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableGreaterThan(Integer value) {
            addCriterion("receiver_available >", value, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiver_available >=", value, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableLessThan(Integer value) {
            addCriterion("receiver_available <", value, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableLessThanOrEqualTo(Integer value) {
            addCriterion("receiver_available <=", value, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableIn(List<Integer> values) {
            addCriterion("receiver_available in", values, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableNotIn(List<Integer> values) {
            addCriterion("receiver_available not in", values, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableBetween(Integer value1, Integer value2) {
            addCriterion("receiver_available between", value1, value2, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andReceiverAvailableNotBetween(Integer value1, Integer value2) {
            addCriterion("receiver_available not between", value1, value2, "receiverAvailable");
            return (Criteria) this;
        }

        public Criteria andAvailableIsNull() {
            addCriterion("available is null");
            return (Criteria) this;
        }

        public Criteria andAvailableIsNotNull() {
            addCriterion("available is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableEqualTo(Integer value) {
            addCriterion("available =", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotEqualTo(Integer value) {
            addCriterion("available <>", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThan(Integer value) {
            addCriterion("available >", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThanOrEqualTo(Integer value) {
            addCriterion("available >=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThan(Integer value) {
            addCriterion("available <", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThanOrEqualTo(Integer value) {
            addCriterion("available <=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableIn(List<Integer> values) {
            addCriterion("available in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotIn(List<Integer> values) {
            addCriterion("available not in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableBetween(Integer value1, Integer value2) {
            addCriterion("available between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotBetween(Integer value1, Integer value2) {
            addCriterion("available not between", value1, value2, "available");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}