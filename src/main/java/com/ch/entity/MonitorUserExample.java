package com.ch.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MonitorUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitorUserExample() {
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

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(Long value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(Long value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(Long value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(Long value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(Long value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(Long value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<Long> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<Long> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(Long value1, Long value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(Long value1, Long value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdIsNull() {
            addCriterion("browse_look_id is null");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdIsNotNull() {
            addCriterion("browse_look_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdEqualTo(String value) {
            addCriterion("browse_look_id =", value, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdNotEqualTo(String value) {
            addCriterion("browse_look_id <>", value, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdGreaterThan(String value) {
            addCriterion("browse_look_id >", value, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdGreaterThanOrEqualTo(String value) {
            addCriterion("browse_look_id >=", value, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdLessThan(String value) {
            addCriterion("browse_look_id <", value, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdLessThanOrEqualTo(String value) {
            addCriterion("browse_look_id <=", value, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdLike(String value) {
            addCriterion("browse_look_id like", value, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdNotLike(String value) {
            addCriterion("browse_look_id not like", value, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdIn(List<String> values) {
            addCriterion("browse_look_id in", values, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdNotIn(List<String> values) {
            addCriterion("browse_look_id not in", values, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdBetween(String value1, String value2) {
            addCriterion("browse_look_id between", value1, value2, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andBrowseLookIdNotBetween(String value1, String value2) {
            addCriterion("browse_look_id not between", value1, value2, "browseLookId");
            return (Criteria) this;
        }

        public Criteria andQuitTimeIsNull() {
            addCriterion("quit_time is null");
            return (Criteria) this;
        }

        public Criteria andQuitTimeIsNotNull() {
            addCriterion("quit_time is not null");
            return (Criteria) this;
        }

        public Criteria andQuitTimeEqualTo(Date value) {
            addCriterion("quit_time =", value, "quitTime");
            return (Criteria) this;
        }

        public Criteria andQuitTimeNotEqualTo(Date value) {
            addCriterion("quit_time <>", value, "quitTime");
            return (Criteria) this;
        }

        public Criteria andQuitTimeGreaterThan(Date value) {
            addCriterion("quit_time >", value, "quitTime");
            return (Criteria) this;
        }

        public Criteria andQuitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("quit_time >=", value, "quitTime");
            return (Criteria) this;
        }

        public Criteria andQuitTimeLessThan(Date value) {
            addCriterion("quit_time <", value, "quitTime");
            return (Criteria) this;
        }

        public Criteria andQuitTimeLessThanOrEqualTo(Date value) {
            addCriterion("quit_time <=", value, "quitTime");
            return (Criteria) this;
        }

        public Criteria andQuitTimeIn(List<Date> values) {
            addCriterion("quit_time in", values, "quitTime");
            return (Criteria) this;
        }

        public Criteria andQuitTimeNotIn(List<Date> values) {
            addCriterion("quit_time not in", values, "quitTime");
            return (Criteria) this;
        }

        public Criteria andQuitTimeBetween(Date value1, Date value2) {
            addCriterion("quit_time between", value1, value2, "quitTime");
            return (Criteria) this;
        }

        public Criteria andQuitTimeNotBetween(Date value1, Date value2) {
            addCriterion("quit_time not between", value1, value2, "quitTime");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdIsNull() {
            addCriterion("shop_type_id is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdIsNotNull() {
            addCriterion("shop_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdEqualTo(Long value) {
            addCriterion("shop_type_id =", value, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdNotEqualTo(Long value) {
            addCriterion("shop_type_id <>", value, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdGreaterThan(Long value) {
            addCriterion("shop_type_id >", value, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_type_id >=", value, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdLessThan(Long value) {
            addCriterion("shop_type_id <", value, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_type_id <=", value, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdIn(List<Long> values) {
            addCriterion("shop_type_id in", values, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdNotIn(List<Long> values) {
            addCriterion("shop_type_id not in", values, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdBetween(Long value1, Long value2) {
            addCriterion("shop_type_id between", value1, value2, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andShopTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_type_id not between", value1, value2, "shopTypeId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdIsNull() {
            addCriterion("browse_transfer_id is null");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdIsNotNull() {
            addCriterion("browse_transfer_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdEqualTo(Long value) {
            addCriterion("browse_transfer_id =", value, "browseTransferId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdNotEqualTo(Long value) {
            addCriterion("browse_transfer_id <>", value, "browseTransferId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdGreaterThan(Long value) {
            addCriterion("browse_transfer_id >", value, "browseTransferId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdGreaterThanOrEqualTo(Long value) {
            addCriterion("browse_transfer_id >=", value, "browseTransferId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdLessThan(Long value) {
            addCriterion("browse_transfer_id <", value, "browseTransferId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdLessThanOrEqualTo(Long value) {
            addCriterion("browse_transfer_id <=", value, "browseTransferId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdIn(List<Long> values) {
            addCriterion("browse_transfer_id in", values, "browseTransferId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdNotIn(List<Long> values) {
            addCriterion("browse_transfer_id not in", values, "browseTransferId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdBetween(Long value1, Long value2) {
            addCriterion("browse_transfer_id between", value1, value2, "browseTransferId");
            return (Criteria) this;
        }

        public Criteria andBrowseTransferIdNotBetween(Long value1, Long value2) {
            addCriterion("browse_transfer_id not between", value1, value2, "browseTransferId");
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