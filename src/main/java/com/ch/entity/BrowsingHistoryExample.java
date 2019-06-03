package com.ch.entity;

import java.util.ArrayList;
import java.util.List;

public class BrowsingHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrowsingHistoryExample() {
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

        public Criteria andLookShopIdIsNull() {
            addCriterion("look_shop_id is null");
            return (Criteria) this;
        }

        public Criteria andLookShopIdIsNotNull() {
            addCriterion("look_shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andLookShopIdEqualTo(Long value) {
            addCriterion("look_shop_id =", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdNotEqualTo(Long value) {
            addCriterion("look_shop_id <>", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdGreaterThan(Long value) {
            addCriterion("look_shop_id >", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("look_shop_id >=", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdLessThan(Long value) {
            addCriterion("look_shop_id <", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdLessThanOrEqualTo(Long value) {
            addCriterion("look_shop_id <=", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdIn(List<Long> values) {
            addCriterion("look_shop_id in", values, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdNotIn(List<Long> values) {
            addCriterion("look_shop_id not in", values, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdBetween(Long value1, Long value2) {
            addCriterion("look_shop_id between", value1, value2, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdNotBetween(Long value1, Long value2) {
            addCriterion("look_shop_id not between", value1, value2, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdIsNull() {
            addCriterion("transfer_shop_id is null");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdIsNotNull() {
            addCriterion("transfer_shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdEqualTo(Long value) {
            addCriterion("transfer_shop_id =", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdNotEqualTo(Long value) {
            addCriterion("transfer_shop_id <>", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdGreaterThan(Long value) {
            addCriterion("transfer_shop_id >", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("transfer_shop_id >=", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdLessThan(Long value) {
            addCriterion("transfer_shop_id <", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdLessThanOrEqualTo(Long value) {
            addCriterion("transfer_shop_id <=", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdIn(List<Long> values) {
            addCriterion("transfer_shop_id in", values, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdNotIn(List<Long> values) {
            addCriterion("transfer_shop_id not in", values, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdBetween(Long value1, Long value2) {
            addCriterion("transfer_shop_id between", value1, value2, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdNotBetween(Long value1, Long value2) {
            addCriterion("transfer_shop_id not between", value1, value2, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNull() {
            addCriterion("sys_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNotNull() {
            addCriterion("sys_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdEqualTo(Long value) {
            addCriterion("sys_user_id =", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotEqualTo(Long value) {
            addCriterion("sys_user_id <>", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThan(Long value) {
            addCriterion("sys_user_id >", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sys_user_id >=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThan(Long value) {
            addCriterion("sys_user_id <", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThanOrEqualTo(Long value) {
            addCriterion("sys_user_id <=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIn(List<Long> values) {
            addCriterion("sys_user_id in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotIn(List<Long> values) {
            addCriterion("sys_user_id not in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdBetween(Long value1, Long value2) {
            addCriterion("sys_user_id between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotBetween(Long value1, Long value2) {
            addCriterion("sys_user_id not between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdIsNull() {
            addCriterion("success_case_id is null");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdIsNotNull() {
            addCriterion("success_case_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdEqualTo(Long value) {
            addCriterion("success_case_id =", value, "successCaseId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdNotEqualTo(Long value) {
            addCriterion("success_case_id <>", value, "successCaseId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdGreaterThan(Long value) {
            addCriterion("success_case_id >", value, "successCaseId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("success_case_id >=", value, "successCaseId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdLessThan(Long value) {
            addCriterion("success_case_id <", value, "successCaseId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdLessThanOrEqualTo(Long value) {
            addCriterion("success_case_id <=", value, "successCaseId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdIn(List<Long> values) {
            addCriterion("success_case_id in", values, "successCaseId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdNotIn(List<Long> values) {
            addCriterion("success_case_id not in", values, "successCaseId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdBetween(Long value1, Long value2) {
            addCriterion("success_case_id between", value1, value2, "successCaseId");
            return (Criteria) this;
        }

        public Criteria andSuccessCaseIdNotBetween(Long value1, Long value2) {
            addCriterion("success_case_id not between", value1, value2, "successCaseId");
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