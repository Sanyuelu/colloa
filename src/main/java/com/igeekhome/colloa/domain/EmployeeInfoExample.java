package com.igeekhome.colloa.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCompanyCodeIsNull() {
            addCriterion("company_code is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIsNotNull() {
            addCriterion("company_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeEqualTo(String value) {
            addCriterion("company_code =", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotEqualTo(String value) {
            addCriterion("company_code <>", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThan(String value) {
            addCriterion("company_code >", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("company_code >=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThan(String value) {
            addCriterion("company_code <", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLessThanOrEqualTo(String value) {
            addCriterion("company_code <=", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeLike(String value) {
            addCriterion("company_code like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotLike(String value) {
            addCriterion("company_code not like", value, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeIn(List<String> values) {
            addCriterion("company_code in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotIn(List<String> values) {
            addCriterion("company_code not in", values, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeBetween(String value1, String value2) {
            addCriterion("company_code between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andCompanyCodeNotBetween(String value1, String value2) {
            addCriterion("company_code not between", value1, value2, "companyCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeIsNull() {
            addCriterion("depa_code is null");
            return (Criteria) this;
        }

        public Criteria andDepaCodeIsNotNull() {
            addCriterion("depa_code is not null");
            return (Criteria) this;
        }

        public Criteria andDepaCodeEqualTo(String value) {
            addCriterion("depa_code =", value, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeNotEqualTo(String value) {
            addCriterion("depa_code <>", value, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeGreaterThan(String value) {
            addCriterion("depa_code >", value, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("depa_code >=", value, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeLessThan(String value) {
            addCriterion("depa_code <", value, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeLessThanOrEqualTo(String value) {
            addCriterion("depa_code <=", value, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeLike(String value) {
            addCriterion("depa_code like", value, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeNotLike(String value) {
            addCriterion("depa_code not like", value, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeIn(List<String> values) {
            addCriterion("depa_code in", values, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeNotIn(List<String> values) {
            addCriterion("depa_code not in", values, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeBetween(String value1, String value2) {
            addCriterion("depa_code between", value1, value2, "depaCode");
            return (Criteria) this;
        }

        public Criteria andDepaCodeNotBetween(String value1, String value2) {
            addCriterion("depa_code not between", value1, value2, "depaCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeIsNull() {
            addCriterion("header_code is null");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeIsNotNull() {
            addCriterion("header_code is not null");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeEqualTo(String value) {
            addCriterion("header_code =", value, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeNotEqualTo(String value) {
            addCriterion("header_code <>", value, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeGreaterThan(String value) {
            addCriterion("header_code >", value, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("header_code >=", value, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeLessThan(String value) {
            addCriterion("header_code <", value, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeLessThanOrEqualTo(String value) {
            addCriterion("header_code <=", value, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeLike(String value) {
            addCriterion("header_code like", value, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeNotLike(String value) {
            addCriterion("header_code not like", value, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeIn(List<String> values) {
            addCriterion("header_code in", values, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeNotIn(List<String> values) {
            addCriterion("header_code not in", values, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeBetween(String value1, String value2) {
            addCriterion("header_code between", value1, value2, "headerCode");
            return (Criteria) this;
        }

        public Criteria andHeaderCodeNotBetween(String value1, String value2) {
            addCriterion("header_code not between", value1, value2, "headerCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeIsNull() {
            addCriterion("empl_code is null");
            return (Criteria) this;
        }

        public Criteria andEmplCodeIsNotNull() {
            addCriterion("empl_code is not null");
            return (Criteria) this;
        }

        public Criteria andEmplCodeEqualTo(String value) {
            addCriterion("empl_code =", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeNotEqualTo(String value) {
            addCriterion("empl_code <>", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeGreaterThan(String value) {
            addCriterion("empl_code >", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeGreaterThanOrEqualTo(String value) {
            addCriterion("empl_code >=", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeLessThan(String value) {
            addCriterion("empl_code <", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeLessThanOrEqualTo(String value) {
            addCriterion("empl_code <=", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeLike(String value) {
            addCriterion("empl_code like", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeNotLike(String value) {
            addCriterion("empl_code not like", value, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeIn(List<String> values) {
            addCriterion("empl_code in", values, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeNotIn(List<String> values) {
            addCriterion("empl_code not in", values, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeBetween(String value1, String value2) {
            addCriterion("empl_code between", value1, value2, "emplCode");
            return (Criteria) this;
        }

        public Criteria andEmplCodeNotBetween(String value1, String value2) {
            addCriterion("empl_code not between", value1, value2, "emplCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNull() {
            addCriterion("category_code is null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIsNotNull() {
            addCriterion("category_code is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeEqualTo(String value) {
            addCriterion("category_code =", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotEqualTo(String value) {
            addCriterion("category_code <>", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThan(String value) {
            addCriterion("category_code >", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("category_code >=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThan(String value) {
            addCriterion("category_code <", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLessThanOrEqualTo(String value) {
            addCriterion("category_code <=", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeLike(String value) {
            addCriterion("category_code like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotLike(String value) {
            addCriterion("category_code not like", value, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeIn(List<String> values) {
            addCriterion("category_code in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotIn(List<String> values) {
            addCriterion("category_code not in", values, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeBetween(String value1, String value2) {
            addCriterion("category_code between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andCategoryCodeNotBetween(String value1, String value2) {
            addCriterion("category_code not between", value1, value2, "categoryCode");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNull() {
            addCriterion("work_status is null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIsNotNull() {
            addCriterion("work_status is not null");
            return (Criteria) this;
        }

        public Criteria andWorkStatusEqualTo(Integer value) {
            addCriterion("work_status =", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotEqualTo(Integer value) {
            addCriterion("work_status <>", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThan(Integer value) {
            addCriterion("work_status >", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("work_status >=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThan(Integer value) {
            addCriterion("work_status <", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusLessThanOrEqualTo(Integer value) {
            addCriterion("work_status <=", value, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusIn(List<Integer> values) {
            addCriterion("work_status in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotIn(List<Integer> values) {
            addCriterion("work_status not in", values, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusBetween(Integer value1, Integer value2) {
            addCriterion("work_status between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andWorkStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("work_status not between", value1, value2, "workStatus");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andMobileTelIsNull() {
            addCriterion("mobile_tel is null");
            return (Criteria) this;
        }

        public Criteria andMobileTelIsNotNull() {
            addCriterion("mobile_tel is not null");
            return (Criteria) this;
        }

        public Criteria andMobileTelEqualTo(String value) {
            addCriterion("mobile_tel =", value, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelNotEqualTo(String value) {
            addCriterion("mobile_tel <>", value, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelGreaterThan(String value) {
            addCriterion("mobile_tel >", value, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_tel >=", value, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelLessThan(String value) {
            addCriterion("mobile_tel <", value, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelLessThanOrEqualTo(String value) {
            addCriterion("mobile_tel <=", value, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelLike(String value) {
            addCriterion("mobile_tel like", value, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelNotLike(String value) {
            addCriterion("mobile_tel not like", value, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelIn(List<String> values) {
            addCriterion("mobile_tel in", values, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelNotIn(List<String> values) {
            addCriterion("mobile_tel not in", values, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelBetween(String value1, String value2) {
            addCriterion("mobile_tel between", value1, value2, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andMobileTelNotBetween(String value1, String value2) {
            addCriterion("mobile_tel not between", value1, value2, "mobileTel");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andWechatIsNull() {
            addCriterion("wechat is null");
            return (Criteria) this;
        }

        public Criteria andWechatIsNotNull() {
            addCriterion("wechat is not null");
            return (Criteria) this;
        }

        public Criteria andWechatEqualTo(String value) {
            addCriterion("wechat =", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotEqualTo(String value) {
            addCriterion("wechat <>", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThan(String value) {
            addCriterion("wechat >", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatGreaterThanOrEqualTo(String value) {
            addCriterion("wechat >=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThan(String value) {
            addCriterion("wechat <", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLessThanOrEqualTo(String value) {
            addCriterion("wechat <=", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatLike(String value) {
            addCriterion("wechat like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotLike(String value) {
            addCriterion("wechat not like", value, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatIn(List<String> values) {
            addCriterion("wechat in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotIn(List<String> values) {
            addCriterion("wechat not in", values, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatBetween(String value1, String value2) {
            addCriterion("wechat between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andWechatNotBetween(String value1, String value2) {
            addCriterion("wechat not between", value1, value2, "wechat");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNull() {
            addCriterion("entry_time is null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNotNull() {
            addCriterion("entry_time is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeEqualTo(Date value) {
            addCriterionForJDBCDate("entry_time =", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("entry_time <>", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("entry_time >", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entry_time >=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThan(Date value) {
            addCriterionForJDBCDate("entry_time <", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("entry_time <=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIn(List<Date> values) {
            addCriterionForJDBCDate("entry_time in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("entry_time not in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entry_time between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("entry_time not between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeIsNull() {
            addCriterion("regular_time is null");
            return (Criteria) this;
        }

        public Criteria andRegularTimeIsNotNull() {
            addCriterion("regular_time is not null");
            return (Criteria) this;
        }

        public Criteria andRegularTimeEqualTo(Date value) {
            addCriterionForJDBCDate("regular_time =", value, "regularTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("regular_time <>", value, "regularTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("regular_time >", value, "regularTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("regular_time >=", value, "regularTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeLessThan(Date value) {
            addCriterionForJDBCDate("regular_time <", value, "regularTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("regular_time <=", value, "regularTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeIn(List<Date> values) {
            addCriterionForJDBCDate("regular_time in", values, "regularTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("regular_time not in", values, "regularTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("regular_time between", value1, value2, "regularTime");
            return (Criteria) this;
        }

        public Criteria andRegularTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("regular_time not between", value1, value2, "regularTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeIsNull() {
            addCriterion("dimission_time is null");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeIsNotNull() {
            addCriterion("dimission_time is not null");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeEqualTo(Date value) {
            addCriterionForJDBCDate("dimission_time =", value, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("dimission_time <>", value, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("dimission_time >", value, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dimission_time >=", value, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeLessThan(Date value) {
            addCriterionForJDBCDate("dimission_time <", value, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dimission_time <=", value, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeIn(List<Date> values) {
            addCriterionForJDBCDate("dimission_time in", values, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("dimission_time not in", values, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dimission_time between", value1, value2, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andDimissionTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dimission_time not between", value1, value2, "dimissionTime");
            return (Criteria) this;
        }

        public Criteria andSelfDescIsNull() {
            addCriterion("self_desc is null");
            return (Criteria) this;
        }

        public Criteria andSelfDescIsNotNull() {
            addCriterion("self_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSelfDescEqualTo(String value) {
            addCriterion("self_desc =", value, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescNotEqualTo(String value) {
            addCriterion("self_desc <>", value, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescGreaterThan(String value) {
            addCriterion("self_desc >", value, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescGreaterThanOrEqualTo(String value) {
            addCriterion("self_desc >=", value, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescLessThan(String value) {
            addCriterion("self_desc <", value, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescLessThanOrEqualTo(String value) {
            addCriterion("self_desc <=", value, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescLike(String value) {
            addCriterion("self_desc like", value, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescNotLike(String value) {
            addCriterion("self_desc not like", value, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescIn(List<String> values) {
            addCriterion("self_desc in", values, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescNotIn(List<String> values) {
            addCriterion("self_desc not in", values, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescBetween(String value1, String value2) {
            addCriterion("self_desc between", value1, value2, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andSelfDescNotBetween(String value1, String value2) {
            addCriterion("self_desc not between", value1, value2, "selfDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescIsNull() {
            addCriterion("resume_desc is null");
            return (Criteria) this;
        }

        public Criteria andResumeDescIsNotNull() {
            addCriterion("resume_desc is not null");
            return (Criteria) this;
        }

        public Criteria andResumeDescEqualTo(String value) {
            addCriterion("resume_desc =", value, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescNotEqualTo(String value) {
            addCriterion("resume_desc <>", value, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescGreaterThan(String value) {
            addCriterion("resume_desc >", value, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescGreaterThanOrEqualTo(String value) {
            addCriterion("resume_desc >=", value, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescLessThan(String value) {
            addCriterion("resume_desc <", value, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescLessThanOrEqualTo(String value) {
            addCriterion("resume_desc <=", value, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescLike(String value) {
            addCriterion("resume_desc like", value, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescNotLike(String value) {
            addCriterion("resume_desc not like", value, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescIn(List<String> values) {
            addCriterion("resume_desc in", values, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescNotIn(List<String> values) {
            addCriterion("resume_desc not in", values, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescBetween(String value1, String value2) {
            addCriterion("resume_desc between", value1, value2, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andResumeDescNotBetween(String value1, String value2) {
            addCriterion("resume_desc not between", value1, value2, "resumeDesc");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("native_place <>", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLike(String value) {
            addCriterion("native_place like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotLike(String value) {
            addCriterion("native_place not like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusIsNull() {
            addCriterion("political_status is null");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusIsNotNull() {
            addCriterion("political_status is not null");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusEqualTo(String value) {
            addCriterion("political_status =", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotEqualTo(String value) {
            addCriterion("political_status <>", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusGreaterThan(String value) {
            addCriterion("political_status >", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusGreaterThanOrEqualTo(String value) {
            addCriterion("political_status >=", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLessThan(String value) {
            addCriterion("political_status <", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLessThanOrEqualTo(String value) {
            addCriterion("political_status <=", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusLike(String value) {
            addCriterion("political_status like", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotLike(String value) {
            addCriterion("political_status not like", value, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusIn(List<String> values) {
            addCriterion("political_status in", values, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotIn(List<String> values) {
            addCriterion("political_status not in", values, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusBetween(String value1, String value2) {
            addCriterion("political_status between", value1, value2, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andPoliticalStatusNotBetween(String value1, String value2) {
            addCriterion("political_status not between", value1, value2, "politicalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNull() {
            addCriterion("marital_status is null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIsNotNull() {
            addCriterion("marital_status is not null");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusEqualTo(Integer value) {
            addCriterion("marital_status =", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotEqualTo(Integer value) {
            addCriterion("marital_status <>", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThan(Integer value) {
            addCriterion("marital_status >", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("marital_status >=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThan(Integer value) {
            addCriterion("marital_status <", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusLessThanOrEqualTo(Integer value) {
            addCriterion("marital_status <=", value, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusIn(List<Integer> values) {
            addCriterion("marital_status in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotIn(List<Integer> values) {
            addCriterion("marital_status not in", values, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusBetween(Integer value1, Integer value2) {
            addCriterion("marital_status between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andMaritalStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("marital_status not between", value1, value2, "maritalStatus");
            return (Criteria) this;
        }

        public Criteria andIdNumIsNull() {
            addCriterion("id_num is null");
            return (Criteria) this;
        }

        public Criteria andIdNumIsNotNull() {
            addCriterion("id_num is not null");
            return (Criteria) this;
        }

        public Criteria andIdNumEqualTo(String value) {
            addCriterion("id_num =", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotEqualTo(String value) {
            addCriterion("id_num <>", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumGreaterThan(String value) {
            addCriterion("id_num >", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumGreaterThanOrEqualTo(String value) {
            addCriterion("id_num >=", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLessThan(String value) {
            addCriterion("id_num <", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLessThanOrEqualTo(String value) {
            addCriterion("id_num <=", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumLike(String value) {
            addCriterion("id_num like", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotLike(String value) {
            addCriterion("id_num not like", value, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumIn(List<String> values) {
            addCriterion("id_num in", values, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotIn(List<String> values) {
            addCriterion("id_num not in", values, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumBetween(String value1, String value2) {
            addCriterion("id_num between", value1, value2, "idNum");
            return (Criteria) this;
        }

        public Criteria andIdNumNotBetween(String value1, String value2) {
            addCriterion("id_num not between", value1, value2, "idNum");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceIsNull() {
            addCriterion("domicile_place is null");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceIsNotNull() {
            addCriterion("domicile_place is not null");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceEqualTo(String value) {
            addCriterion("domicile_place =", value, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceNotEqualTo(String value) {
            addCriterion("domicile_place <>", value, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceGreaterThan(String value) {
            addCriterion("domicile_place >", value, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("domicile_place >=", value, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceLessThan(String value) {
            addCriterion("domicile_place <", value, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceLessThanOrEqualTo(String value) {
            addCriterion("domicile_place <=", value, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceLike(String value) {
            addCriterion("domicile_place like", value, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceNotLike(String value) {
            addCriterion("domicile_place not like", value, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceIn(List<String> values) {
            addCriterion("domicile_place in", values, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceNotIn(List<String> values) {
            addCriterion("domicile_place not in", values, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceBetween(String value1, String value2) {
            addCriterion("domicile_place between", value1, value2, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andDomicilePlaceNotBetween(String value1, String value2) {
            addCriterion("domicile_place not between", value1, value2, "domicilePlace");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNull() {
            addCriterion("college is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIsNotNull() {
            addCriterion("college is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeEqualTo(String value) {
            addCriterion("college =", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotEqualTo(String value) {
            addCriterion("college <>", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThan(String value) {
            addCriterion("college >", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeGreaterThanOrEqualTo(String value) {
            addCriterion("college >=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThan(String value) {
            addCriterion("college <", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLessThanOrEqualTo(String value) {
            addCriterion("college <=", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeLike(String value) {
            addCriterion("college like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotLike(String value) {
            addCriterion("college not like", value, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeIn(List<String> values) {
            addCriterion("college in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotIn(List<String> values) {
            addCriterion("college not in", values, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeBetween(String value1, String value2) {
            addCriterion("college between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andCollegeNotBetween(String value1, String value2) {
            addCriterion("college not between", value1, value2, "college");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(Integer value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(Integer value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(Integer value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(Integer value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(Integer value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(Integer value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<Integer> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<Integer> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(Integer value1, Integer value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(Integer value1, Integer value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andAcademicRefIsNull() {
            addCriterion("academic_ref is null");
            return (Criteria) this;
        }

        public Criteria andAcademicRefIsNotNull() {
            addCriterion("academic_ref is not null");
            return (Criteria) this;
        }

        public Criteria andAcademicRefEqualTo(String value) {
            addCriterion("academic_ref =", value, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefNotEqualTo(String value) {
            addCriterion("academic_ref <>", value, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefGreaterThan(String value) {
            addCriterion("academic_ref >", value, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefGreaterThanOrEqualTo(String value) {
            addCriterion("academic_ref >=", value, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefLessThan(String value) {
            addCriterion("academic_ref <", value, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefLessThanOrEqualTo(String value) {
            addCriterion("academic_ref <=", value, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefLike(String value) {
            addCriterion("academic_ref like", value, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefNotLike(String value) {
            addCriterion("academic_ref not like", value, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefIn(List<String> values) {
            addCriterion("academic_ref in", values, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefNotIn(List<String> values) {
            addCriterion("academic_ref not in", values, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefBetween(String value1, String value2) {
            addCriterion("academic_ref between", value1, value2, "academicRef");
            return (Criteria) this;
        }

        public Criteria andAcademicRefNotBetween(String value1, String value2) {
            addCriterion("academic_ref not between", value1, value2, "academicRef");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNull() {
            addCriterion("hobby is null");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNotNull() {
            addCriterion("hobby is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyEqualTo(String value) {
            addCriterion("hobby =", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotEqualTo(String value) {
            addCriterion("hobby <>", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThan(String value) {
            addCriterion("hobby >", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("hobby >=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThan(String value) {
            addCriterion("hobby <", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThanOrEqualTo(String value) {
            addCriterion("hobby <=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLike(String value) {
            addCriterion("hobby like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotLike(String value) {
            addCriterion("hobby not like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyIn(List<String> values) {
            addCriterion("hobby in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotIn(List<String> values) {
            addCriterion("hobby not in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyBetween(String value1, String value2) {
            addCriterion("hobby between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotBetween(String value1, String value2) {
            addCriterion("hobby not between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIsNull() {
            addCriterion("avatar_url is null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIsNotNull() {
            addCriterion("avatar_url is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlEqualTo(String value) {
            addCriterion("avatar_url =", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotEqualTo(String value) {
            addCriterion("avatar_url <>", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlGreaterThan(String value) {
            addCriterion("avatar_url >", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlGreaterThanOrEqualTo(String value) {
            addCriterion("avatar_url >=", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLessThan(String value) {
            addCriterion("avatar_url <", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLessThanOrEqualTo(String value) {
            addCriterion("avatar_url <=", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlLike(String value) {
            addCriterion("avatar_url like", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotLike(String value) {
            addCriterion("avatar_url not like", value, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlIn(List<String> values) {
            addCriterion("avatar_url in", values, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotIn(List<String> values) {
            addCriterion("avatar_url not in", values, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlBetween(String value1, String value2) {
            addCriterion("avatar_url between", value1, value2, "avatarUrl");
            return (Criteria) this;
        }

        public Criteria andAvatarUrlNotBetween(String value1, String value2) {
            addCriterion("avatar_url not between", value1, value2, "avatarUrl");
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