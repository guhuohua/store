package com.ch.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SuccessCaseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SuccessCaseExample() {
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

        public Criteria andLookShopIdEqualTo(String value) {
            addCriterion("look_shop_id =", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdNotEqualTo(String value) {
            addCriterion("look_shop_id <>", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdGreaterThan(String value) {
            addCriterion("look_shop_id >", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("look_shop_id >=", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdLessThan(String value) {
            addCriterion("look_shop_id <", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdLessThanOrEqualTo(String value) {
            addCriterion("look_shop_id <=", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdLike(String value) {
            addCriterion("look_shop_id like", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdNotLike(String value) {
            addCriterion("look_shop_id not like", value, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdIn(List<String> values) {
            addCriterion("look_shop_id in", values, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdNotIn(List<String> values) {
            addCriterion("look_shop_id not in", values, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdBetween(String value1, String value2) {
            addCriterion("look_shop_id between", value1, value2, "lookShopId");
            return (Criteria) this;
        }

        public Criteria andLookShopIdNotBetween(String value1, String value2) {
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

        public Criteria andTransferShopIdEqualTo(String value) {
            addCriterion("transfer_shop_id =", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdNotEqualTo(String value) {
            addCriterion("transfer_shop_id <>", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdGreaterThan(String value) {
            addCriterion("transfer_shop_id >", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("transfer_shop_id >=", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdLessThan(String value) {
            addCriterion("transfer_shop_id <", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdLessThanOrEqualTo(String value) {
            addCriterion("transfer_shop_id <=", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdLike(String value) {
            addCriterion("transfer_shop_id like", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdNotLike(String value) {
            addCriterion("transfer_shop_id not like", value, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdIn(List<String> values) {
            addCriterion("transfer_shop_id in", values, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdNotIn(List<String> values) {
            addCriterion("transfer_shop_id not in", values, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdBetween(String value1, String value2) {
            addCriterion("transfer_shop_id between", value1, value2, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andTransferShopIdNotBetween(String value1, String value2) {
            addCriterion("transfer_shop_id not between", value1, value2, "transferShopId");
            return (Criteria) this;
        }

        public Criteria andLookDegreeIsNull() {
            addCriterion("look_degree is null");
            return (Criteria) this;
        }

        public Criteria andLookDegreeIsNotNull() {
            addCriterion("look_degree is not null");
            return (Criteria) this;
        }

        public Criteria andLookDegreeEqualTo(Integer value) {
            addCriterion("look_degree =", value, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andLookDegreeNotEqualTo(Integer value) {
            addCriterion("look_degree <>", value, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andLookDegreeGreaterThan(Integer value) {
            addCriterion("look_degree >", value, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andLookDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("look_degree >=", value, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andLookDegreeLessThan(Integer value) {
            addCriterion("look_degree <", value, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andLookDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("look_degree <=", value, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andLookDegreeIn(List<Integer> values) {
            addCriterion("look_degree in", values, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andLookDegreeNotIn(List<Integer> values) {
            addCriterion("look_degree not in", values, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andLookDegreeBetween(Integer value1, Integer value2) {
            addCriterion("look_degree between", value1, value2, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andLookDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("look_degree not between", value1, value2, "lookDegree");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeIsNull() {
            addCriterion("success_time is null");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeIsNotNull() {
            addCriterion("success_time is not null");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeEqualTo(Date value) {
            addCriterion("success_time =", value, "successTime");
            return (Criteria) this;
        }

        public Criteria andSysUserIdEqualTo(Long value) {
            addCriterion("sys_user =", value, "sysUser");
            return (Criteria) this;
        }


        public Criteria andSuccessTimeNotEqualTo(Date value) {
            addCriterion("success_time <>", value, "successTime");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeGreaterThan(Date value) {
            addCriterion("success_time >", value, "successTime");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("success_time >=", value, "successTime");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeLessThan(Date value) {
            addCriterion("success_time <", value, "successTime");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeLessThanOrEqualTo(Date value) {
            addCriterion("success_time <=", value, "successTime");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeIn(List<Date> values) {
            addCriterion("success_time in", values, "successTime");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeNotIn(List<Date> values) {
            addCriterion("success_time not in", values, "successTime");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeBetween(Date value1, Date value2) {
            addCriterion("success_time between", value1, value2, "successTime");
            return (Criteria) this;
        }

        public Criteria andSuccessTimeNotBetween(Date value1, Date value2) {
            addCriterion("success_time not between", value1, value2, "successTime");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberIsNull() {
            addCriterion("browse_number is null");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberIsNotNull() {
            addCriterion("browse_number is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberEqualTo(Long value) {
            addCriterion("browse_number =", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberNotEqualTo(Long value) {
            addCriterion("browse_number <>", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberGreaterThan(Long value) {
            addCriterion("browse_number >", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("browse_number >=", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberLessThan(Long value) {
            addCriterion("browse_number <", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberLessThanOrEqualTo(Long value) {
            addCriterion("browse_number <=", value, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberIn(List<Long> values) {
            addCriterion("browse_number in", values, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberNotIn(List<Long> values) {
            addCriterion("browse_number not in", values, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberBetween(Long value1, Long value2) {
            addCriterion("browse_number between", value1, value2, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andBrowseNumberNotBetween(Long value1, Long value2) {
            addCriterion("browse_number not between", value1, value2, "browseNumber");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeIsNull() {
            addCriterion("transfer_degree is null");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeIsNotNull() {
            addCriterion("transfer_degree is not null");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeEqualTo(Integer value) {
            addCriterion("transfer_degree =", value, "transferDegree");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeNotEqualTo(Integer value) {
            addCriterion("transfer_degree <>", value, "transferDegree");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeGreaterThan(Integer value) {
            addCriterion("transfer_degree >", value, "transferDegree");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeGreaterThanOrEqualTo(Integer value) {
            addCriterion("transfer_degree >=", value, "transferDegree");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeLessThan(Integer value) {
            addCriterion("transfer_degree <", value, "transferDegree");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeLessThanOrEqualTo(Integer value) {
            addCriterion("transfer_degree <=", value, "transferDegree");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeIn(List<Integer> values) {
            addCriterion("transfer_degree in", values, "transferDegree");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeNotIn(List<Integer> values) {
            addCriterion("transfer_degree not in", values, "transferDegree");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeBetween(Integer value1, Integer value2) {
            addCriterion("transfer_degree between", value1, value2, "transferDegree");
            return (Criteria) this;
        }

        public Criteria andTransferDegreeNotBetween(Integer value1, Integer value2) {
            addCriterion("transfer_degree not between", value1, value2, "transferDegree");
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