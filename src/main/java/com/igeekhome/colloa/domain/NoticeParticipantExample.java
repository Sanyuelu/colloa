package com.igeekhome.colloa.domain;

import java.util.ArrayList;
import java.util.List;

public class NoticeParticipantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoticeParticipantExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

        public Criteria andNoticeCodeIsNull() {
            addCriterion("notice_code is null");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeIsNotNull() {
            addCriterion("notice_code is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeEqualTo(String value) {
            addCriterion("notice_code =", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeNotEqualTo(String value) {
            addCriterion("notice_code <>", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeGreaterThan(String value) {
            addCriterion("notice_code >", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("notice_code >=", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeLessThan(String value) {
            addCriterion("notice_code <", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeLessThanOrEqualTo(String value) {
            addCriterion("notice_code <=", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeLike(String value) {
            addCriterion("notice_code like", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeNotLike(String value) {
            addCriterion("notice_code not like", value, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeIn(List<String> values) {
            addCriterion("notice_code in", values, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeNotIn(List<String> values) {
            addCriterion("notice_code not in", values, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeBetween(String value1, String value2) {
            addCriterion("notice_code between", value1, value2, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andNoticeCodeNotBetween(String value1, String value2) {
            addCriterion("notice_code not between", value1, value2, "noticeCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeIsNull() {
            addCriterion("participant_code is null");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeIsNotNull() {
            addCriterion("participant_code is not null");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeEqualTo(String value) {
            addCriterion("participant_code =", value, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeNotEqualTo(String value) {
            addCriterion("participant_code <>", value, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeGreaterThan(String value) {
            addCriterion("participant_code >", value, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("participant_code >=", value, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeLessThan(String value) {
            addCriterion("participant_code <", value, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeLessThanOrEqualTo(String value) {
            addCriterion("participant_code <=", value, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeLike(String value) {
            addCriterion("participant_code like", value, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeNotLike(String value) {
            addCriterion("participant_code not like", value, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeIn(List<String> values) {
            addCriterion("participant_code in", values, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeNotIn(List<String> values) {
            addCriterion("participant_code not in", values, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeBetween(String value1, String value2) {
            addCriterion("participant_code between", value1, value2, "participantCode");
            return (Criteria) this;
        }

        public Criteria andParticipantCodeNotBetween(String value1, String value2) {
            addCriterion("participant_code not between", value1, value2, "participantCode");
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

        public Criteria andAvaliableIsNull() {
            addCriterion("avaliable is null");
            return (Criteria) this;
        }

        public Criteria andAvaliableIsNotNull() {
            addCriterion("avaliable is not null");
            return (Criteria) this;
        }

        public Criteria andAvaliableEqualTo(Integer value) {
            addCriterion("avaliable =", value, "avaliable");
            return (Criteria) this;
        }

        public Criteria andAvaliableNotEqualTo(Integer value) {
            addCriterion("avaliable <>", value, "avaliable");
            return (Criteria) this;
        }

        public Criteria andAvaliableGreaterThan(Integer value) {
            addCriterion("avaliable >", value, "avaliable");
            return (Criteria) this;
        }

        public Criteria andAvaliableGreaterThanOrEqualTo(Integer value) {
            addCriterion("avaliable >=", value, "avaliable");
            return (Criteria) this;
        }

        public Criteria andAvaliableLessThan(Integer value) {
            addCriterion("avaliable <", value, "avaliable");
            return (Criteria) this;
        }

        public Criteria andAvaliableLessThanOrEqualTo(Integer value) {
            addCriterion("avaliable <=", value, "avaliable");
            return (Criteria) this;
        }

        public Criteria andAvaliableIn(List<Integer> values) {
            addCriterion("avaliable in", values, "avaliable");
            return (Criteria) this;
        }

        public Criteria andAvaliableNotIn(List<Integer> values) {
            addCriterion("avaliable not in", values, "avaliable");
            return (Criteria) this;
        }

        public Criteria andAvaliableBetween(Integer value1, Integer value2) {
            addCriterion("avaliable between", value1, value2, "avaliable");
            return (Criteria) this;
        }

        public Criteria andAvaliableNotBetween(Integer value1, Integer value2) {
            addCriterion("avaliable not between", value1, value2, "avaliable");
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
    }
}