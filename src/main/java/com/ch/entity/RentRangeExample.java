package com.ch.entity;

import java.util.ArrayList;
import java.util.List;

public class RentRangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RentRangeExample() {
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

        public Criteria andSmallRentIsNull() {
            addCriterion("small_rent is null");
            return (Criteria) this;
        }

        public Criteria andSmallRentIsNotNull() {
            addCriterion("small_rent is not null");
            return (Criteria) this;
        }

        public Criteria andSmallRentEqualTo(Long value) {
            addCriterion("small_rent =", value, "smallRent");
            return (Criteria) this;
        }

        public Criteria andSmallRentNotEqualTo(Long value) {
            addCriterion("small_rent <>", value, "smallRent");
            return (Criteria) this;
        }

        public Criteria andSmallRentGreaterThan(Long value) {
            addCriterion("small_rent >", value, "smallRent");
            return (Criteria) this;
        }

        public Criteria andSmallRentGreaterThanOrEqualTo(Long value) {
            addCriterion("small_rent >=", value, "smallRent");
            return (Criteria) this;
        }

        public Criteria andSmallRentLessThan(Long value) {
            addCriterion("small_rent <", value, "smallRent");
            return (Criteria) this;
        }

        public Criteria andSmallRentLessThanOrEqualTo(Long value) {
            addCriterion("small_rent <=", value, "smallRent");
            return (Criteria) this;
        }

        public Criteria andSmallRentIn(List<Long> values) {
            addCriterion("small_rent in", values, "smallRent");
            return (Criteria) this;
        }

        public Criteria andSmallRentNotIn(List<Long> values) {
            addCriterion("small_rent not in", values, "smallRent");
            return (Criteria) this;
        }

        public Criteria andSmallRentBetween(Long value1, Long value2) {
            addCriterion("small_rent between", value1, value2, "smallRent");
            return (Criteria) this;
        }

        public Criteria andSmallRentNotBetween(Long value1, Long value2) {
            addCriterion("small_rent not between", value1, value2, "smallRent");
            return (Criteria) this;
        }

        public Criteria andTopRentIsNull() {
            addCriterion("top_rent is null");
            return (Criteria) this;
        }

        public Criteria andTopRentIsNotNull() {
            addCriterion("top_rent is not null");
            return (Criteria) this;
        }

        public Criteria andTopRentEqualTo(Long value) {
            addCriterion("top_rent =", value, "topRent");
            return (Criteria) this;
        }

        public Criteria andTopRentNotEqualTo(Long value) {
            addCriterion("top_rent <>", value, "topRent");
            return (Criteria) this;
        }

        public Criteria andTopRentGreaterThan(Long value) {
            addCriterion("top_rent >", value, "topRent");
            return (Criteria) this;
        }

        public Criteria andTopRentGreaterThanOrEqualTo(Long value) {
            addCriterion("top_rent >=", value, "topRent");
            return (Criteria) this;
        }

        public Criteria andTopRentLessThan(Long value) {
            addCriterion("top_rent <", value, "topRent");
            return (Criteria) this;
        }

        public Criteria andTopRentLessThanOrEqualTo(Long value) {
            addCriterion("top_rent <=", value, "topRent");
            return (Criteria) this;
        }

        public Criteria andTopRentIn(List<Long> values) {
            addCriterion("top_rent in", values, "topRent");
            return (Criteria) this;
        }

        public Criteria andTopRentNotIn(List<Long> values) {
            addCriterion("top_rent not in", values, "topRent");
            return (Criteria) this;
        }

        public Criteria andTopRentBetween(Long value1, Long value2) {
            addCriterion("top_rent between", value1, value2, "topRent");
            return (Criteria) this;
        }

        public Criteria andTopRentNotBetween(Long value1, Long value2) {
            addCriterion("top_rent not between", value1, value2, "topRent");
            return (Criteria) this;
        }

        public Criteria andRentDescIsNull() {
            addCriterion("rent_desc is null");
            return (Criteria) this;
        }

        public Criteria andRentDescIsNotNull() {
            addCriterion("rent_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRentDescEqualTo(String value) {
            addCriterion("rent_desc =", value, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescNotEqualTo(String value) {
            addCriterion("rent_desc <>", value, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescGreaterThan(String value) {
            addCriterion("rent_desc >", value, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescGreaterThanOrEqualTo(String value) {
            addCriterion("rent_desc >=", value, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescLessThan(String value) {
            addCriterion("rent_desc <", value, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescLessThanOrEqualTo(String value) {
            addCriterion("rent_desc <=", value, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescLike(String value) {
            addCriterion("rent_desc like", value, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescNotLike(String value) {
            addCriterion("rent_desc not like", value, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescIn(List<String> values) {
            addCriterion("rent_desc in", values, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescNotIn(List<String> values) {
            addCriterion("rent_desc not in", values, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescBetween(String value1, String value2) {
            addCriterion("rent_desc between", value1, value2, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andRentDescNotBetween(String value1, String value2) {
            addCriterion("rent_desc not between", value1, value2, "rentDesc");
            return (Criteria) this;
        }

        public Criteria andLabelIsNull() {
            addCriterion("label is null");
            return (Criteria) this;
        }

        public Criteria andLabelIsNotNull() {
            addCriterion("label is not null");
            return (Criteria) this;
        }

        public Criteria andLabelEqualTo(Integer value) {
            addCriterion("label =", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotEqualTo(Integer value) {
            addCriterion("label <>", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThan(Integer value) {
            addCriterion("label >", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelGreaterThanOrEqualTo(Integer value) {
            addCriterion("label >=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThan(Integer value) {
            addCriterion("label <", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelLessThanOrEqualTo(Integer value) {
            addCriterion("label <=", value, "label");
            return (Criteria) this;
        }

        public Criteria andLabelIn(List<Integer> values) {
            addCriterion("label in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotIn(List<Integer> values) {
            addCriterion("label not in", values, "label");
            return (Criteria) this;
        }

        public Criteria andLabelBetween(Integer value1, Integer value2) {
            addCriterion("label between", value1, value2, "label");
            return (Criteria) this;
        }

        public Criteria andLabelNotBetween(Integer value1, Integer value2) {
            addCriterion("label not between", value1, value2, "label");
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