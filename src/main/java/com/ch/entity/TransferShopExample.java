package com.ch.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransferShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransferShopExample() {
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

        public Criteria andBusinessTypeIdIsNull() {
            addCriterion("business_type_id is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdIsNotNull() {
            addCriterion("business_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdEqualTo(Long value) {
            addCriterion("business_type_id =", value, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdNotEqualTo(Long value) {
            addCriterion("business_type_id <>", value, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdGreaterThan(Long value) {
            addCriterion("business_type_id >", value, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("business_type_id >=", value, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdLessThan(Long value) {
            addCriterion("business_type_id <", value, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("business_type_id <=", value, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdIn(List<Long> values) {
            addCriterion("business_type_id in", values, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdNotIn(List<Long> values) {
            addCriterion("business_type_id not in", values, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdBetween(Long value1, Long value2) {
            addCriterion("business_type_id between", value1, value2, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("business_type_id not between", value1, value2, "businessTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdIsNull() {
            addCriterion("property_type_id is null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdIsNotNull() {
            addCriterion("property_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdEqualTo(Long value) {
            addCriterion("property_type_id =", value, "propertyTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdNotEqualTo(Long value) {
            addCriterion("property_type_id <>", value, "propertyTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdGreaterThan(Long value) {
            addCriterion("property_type_id >", value, "propertyTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("property_type_id >=", value, "propertyTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdLessThan(Long value) {
            addCriterion("property_type_id <", value, "propertyTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("property_type_id <=", value, "propertyTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdIn(List<Long> values) {
            addCriterion("property_type_id in", values, "propertyTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdNotIn(List<Long> values) {
            addCriterion("property_type_id not in", values, "propertyTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdBetween(Long value1, Long value2) {
            addCriterion("property_type_id between", value1, value2, "propertyTypeId");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("property_type_id not between", value1, value2, "propertyTypeId");
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

        public Criteria andRentIsNull() {
            addCriterion("rent is null");
            return (Criteria) this;
        }

        public Criteria andRentIsNotNull() {
            addCriterion("rent is not null");
            return (Criteria) this;
        }

        public Criteria andRentEqualTo(Long value) {
            addCriterion("rent =", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotEqualTo(Long value) {
            addCriterion("rent <>", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThan(Long value) {
            addCriterion("rent >", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThanOrEqualTo(Long value) {
            addCriterion("rent >=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThan(Long value) {
            addCriterion("rent <", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThanOrEqualTo(Long value) {
            addCriterion("rent <=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentIn(List<Long> values) {
            addCriterion("rent in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotIn(List<Long> values) {
            addCriterion("rent not in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentBetween(Long value1, Long value2) {
            addCriterion("rent between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotBetween(Long value1, Long value2) {
            addCriterion("rent not between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Integer value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Integer value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Integer value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Integer value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Integer value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Integer value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Integer> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Integer> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Integer value1, Integer value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Integer value1, Integer value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andTransferStatusIsNull() {
            addCriterion("transfer_status is null");
            return (Criteria) this;
        }

        public Criteria andTransferStatusIsNotNull() {
            addCriterion("transfer_status is not null");
            return (Criteria) this;
        }

        public Criteria andTransferStatusEqualTo(Integer value) {
            addCriterion("transfer_status =", value, "transferStatus");
            return (Criteria) this;
        }

        public Criteria andTransferStatusNotEqualTo(Integer value) {
            addCriterion("transfer_status <>", value, "transferStatus");
            return (Criteria) this;
        }

        public Criteria andTransferStatusGreaterThan(Integer value) {
            addCriterion("transfer_status >", value, "transferStatus");
            return (Criteria) this;
        }

        public Criteria andTransferStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("transfer_status >=", value, "transferStatus");
            return (Criteria) this;
        }

        public Criteria andTransferStatusLessThan(Integer value) {
            addCriterion("transfer_status <", value, "transferStatus");
            return (Criteria) this;
        }

        public Criteria andTransferStatusLessThanOrEqualTo(Integer value) {
            addCriterion("transfer_status <=", value, "transferStatus");
            return (Criteria) this;
        }

        public Criteria andTransferStatusIn(List<Integer> values) {
            addCriterion("transfer_status in", values, "transferStatus");
            return (Criteria) this;
        }

        public Criteria andTransferStatusNotIn(List<Integer> values) {
            addCriterion("transfer_status not in", values, "transferStatus");
            return (Criteria) this;
        }

        public Criteria andTransferStatusBetween(Integer value1, Integer value2) {
            addCriterion("transfer_status between", value1, value2, "transferStatus");
            return (Criteria) this;
        }

        public Criteria andTransferStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("transfer_status not between", value1, value2, "transferStatus");
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNull() {
            addCriterion("city_id is null");
            return (Criteria) this;
        }

        public Criteria andCityIdIsNotNull() {
            addCriterion("city_id is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdEqualTo(Integer value) {
            addCriterion("city_id =", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotEqualTo(Integer value) {
            addCriterion("city_id <>", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThan(Integer value) {
            addCriterion("city_id >", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("city_id >=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThan(Integer value) {
            addCriterion("city_id <", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("city_id <=", value, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdIn(List<Integer> values) {
            addCriterion("city_id in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotIn(List<Integer> values) {
            addCriterion("city_id not in", values, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdBetween(Integer value1, Integer value2) {
            addCriterion("city_id between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("city_id not between", value1, value2, "cityId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdIsNull() {
            addCriterion("decorate_type_id is null");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdIsNotNull() {
            addCriterion("decorate_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdEqualTo(Long value) {
            addCriterion("decorate_type_id =", value, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdNotEqualTo(Long value) {
            addCriterion("decorate_type_id <>", value, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdGreaterThan(Long value) {
            addCriterion("decorate_type_id >", value, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("decorate_type_id >=", value, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdLessThan(Long value) {
            addCriterion("decorate_type_id <", value, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("decorate_type_id <=", value, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdIn(List<Long> values) {
            addCriterion("decorate_type_id in", values, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdNotIn(List<Long> values) {
            addCriterion("decorate_type_id not in", values, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdBetween(Long value1, Long value2) {
            addCriterion("decorate_type_id between", value1, value2, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andDecorateTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("decorate_type_id not between", value1, value2, "decorateTypeId");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsIsNull() {
            addCriterion("requirement_details is null");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsIsNotNull() {
            addCriterion("requirement_details is not null");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsEqualTo(String value) {
            addCriterion("requirement_details =", value, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsNotEqualTo(String value) {
            addCriterion("requirement_details <>", value, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsGreaterThan(String value) {
            addCriterion("requirement_details >", value, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsGreaterThanOrEqualTo(String value) {
            addCriterion("requirement_details >=", value, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsLessThan(String value) {
            addCriterion("requirement_details <", value, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsLessThanOrEqualTo(String value) {
            addCriterion("requirement_details <=", value, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsLike(String value) {
            addCriterion("requirement_details like", value, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsNotLike(String value) {
            addCriterion("requirement_details not like", value, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsIn(List<String> values) {
            addCriterion("requirement_details in", values, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsNotIn(List<String> values) {
            addCriterion("requirement_details not in", values, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsBetween(String value1, String value2) {
            addCriterion("requirement_details between", value1, value2, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andRequirementDetailsNotBetween(String value1, String value2) {
            addCriterion("requirement_details not between", value1, value2, "requirementDetails");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsIsNull() {
            addCriterion("\"accessory _requirements\" is null");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsIsNotNull() {
            addCriterion("\"accessory _requirements\" is not null");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsEqualTo(String value) {
            addCriterion("\"accessory _requirements\" =", value, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsNotEqualTo(String value) {
            addCriterion("\"accessory _requirements\" <>", value, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsGreaterThan(String value) {
            addCriterion("\"accessory _requirements\" >", value, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsGreaterThanOrEqualTo(String value) {
            addCriterion("\"accessory _requirements\" >=", value, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsLessThan(String value) {
            addCriterion("\"accessory _requirements\" <", value, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsLessThanOrEqualTo(String value) {
            addCriterion("\"accessory _requirements\" <=", value, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsLike(String value) {
            addCriterion("\"accessory _requirements\" like", value, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsNotLike(String value) {
            addCriterion("\"accessory _requirements\" not like", value, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsIn(List<String> values) {
            addCriterion("\"accessory _requirements\" in", values, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsNotIn(List<String> values) {
            addCriterion("\"accessory _requirements\" not in", values, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsBetween(String value1, String value2) {
            addCriterion("\"accessory _requirements\" between", value1, value2, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andAccessoryRequirementsNotBetween(String value1, String value2) {
            addCriterion("\"accessory _requirements\" not between", value1, value2, "accessoryRequirements");
            return (Criteria) this;
        }

        public Criteria andGateWidthIsNull() {
            addCriterion("gate_width is null");
            return (Criteria) this;
        }

        public Criteria andGateWidthIsNotNull() {
            addCriterion("gate_width is not null");
            return (Criteria) this;
        }

        public Criteria andGateWidthEqualTo(Long value) {
            addCriterion("gate_width =", value, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andGateWidthNotEqualTo(Long value) {
            addCriterion("gate_width <>", value, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andGateWidthGreaterThan(Long value) {
            addCriterion("gate_width >", value, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andGateWidthGreaterThanOrEqualTo(Long value) {
            addCriterion("gate_width >=", value, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andGateWidthLessThan(Long value) {
            addCriterion("gate_width <", value, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andGateWidthLessThanOrEqualTo(Long value) {
            addCriterion("gate_width <=", value, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andGateWidthIn(List<Long> values) {
            addCriterion("gate_width in", values, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andGateWidthNotIn(List<Long> values) {
            addCriterion("gate_width not in", values, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andGateWidthBetween(Long value1, Long value2) {
            addCriterion("gate_width between", value1, value2, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andGateWidthNotBetween(Long value1, Long value2) {
            addCriterion("gate_width not between", value1, value2, "gateWidth");
            return (Criteria) this;
        }

        public Criteria andTransferFeeIsNull() {
            addCriterion("transfer_fee is null");
            return (Criteria) this;
        }

        public Criteria andTransferFeeIsNotNull() {
            addCriterion("transfer_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTransferFeeEqualTo(Long value) {
            addCriterion("transfer_fee =", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeNotEqualTo(Long value) {
            addCriterion("transfer_fee <>", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeGreaterThan(Long value) {
            addCriterion("transfer_fee >", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("transfer_fee >=", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeLessThan(Long value) {
            addCriterion("transfer_fee <", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeLessThanOrEqualTo(Long value) {
            addCriterion("transfer_fee <=", value, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeIn(List<Long> values) {
            addCriterion("transfer_fee in", values, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeNotIn(List<Long> values) {
            addCriterion("transfer_fee not in", values, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeBetween(Long value1, Long value2) {
            addCriterion("transfer_fee between", value1, value2, "transferFee");
            return (Criteria) this;
        }

        public Criteria andTransferFeeNotBetween(Long value1, Long value2) {
            addCriterion("transfer_fee not between", value1, value2, "transferFee");
            return (Criteria) this;
        }

        public Criteria andShopSnIsNull() {
            addCriterion("shop_sn is null");
            return (Criteria) this;
        }

        public Criteria andShopSnIsNotNull() {
            addCriterion("shop_sn is not null");
            return (Criteria) this;
        }

        public Criteria andShopSnEqualTo(String value) {
            addCriterion("shop_sn =", value, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnNotEqualTo(String value) {
            addCriterion("shop_sn <>", value, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnGreaterThan(String value) {
            addCriterion("shop_sn >", value, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnGreaterThanOrEqualTo(String value) {
            addCriterion("shop_sn >=", value, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnLessThan(String value) {
            addCriterion("shop_sn <", value, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnLessThanOrEqualTo(String value) {
            addCriterion("shop_sn <=", value, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnLike(String value) {
            addCriterion("shop_sn like", value, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnNotLike(String value) {
            addCriterion("shop_sn not like", value, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnIn(List<String> values) {
            addCriterion("shop_sn in", values, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnNotIn(List<String> values) {
            addCriterion("shop_sn not in", values, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnBetween(String value1, String value2) {
            addCriterion("shop_sn between", value1, value2, "shopSn");
            return (Criteria) this;
        }

        public Criteria andShopSnNotBetween(String value1, String value2) {
            addCriterion("shop_sn not between", value1, value2, "shopSn");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNull() {
            addCriterion("service_type is null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIsNotNull() {
            addCriterion("service_type is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTypeEqualTo(Long value) {
            addCriterion("service_type =", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotEqualTo(Long value) {
            addCriterion("service_type <>", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThan(Long value) {
            addCriterion("service_type >", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeGreaterThanOrEqualTo(Long value) {
            addCriterion("service_type >=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThan(Long value) {
            addCriterion("service_type <", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeLessThanOrEqualTo(Long value) {
            addCriterion("service_type <=", value, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeIn(List<Long> values) {
            addCriterion("service_type in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotIn(List<Long> values) {
            addCriterion("service_type not in", values, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeBetween(Long value1, Long value2) {
            addCriterion("service_type between", value1, value2, "serviceType");
            return (Criteria) this;
        }

        public Criteria andServiceTypeNotBetween(Long value1, Long value2) {
            addCriterion("service_type not between", value1, value2, "serviceType");
            return (Criteria) this;
        }



        public Criteria andLongitudeEqualTo(String value) {
            addCriterion(" longitude =", value, " longitude");
            return (Criteria) this;
        }



        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andMediumStatusIsNull() {
            addCriterion("medium_status is null");
            return (Criteria) this;
        }

        public Criteria andMediumStatusIsNotNull() {
            addCriterion("medium_status is not null");
            return (Criteria) this;
        }

        public Criteria andMediumStatusEqualTo(Integer value) {
            addCriterion("medium_status =", value, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andMediumStatusNotEqualTo(Integer value) {
            addCriterion("medium_status <>", value, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andMediumStatusGreaterThan(Integer value) {
            addCriterion("medium_status >", value, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andMediumStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("medium_status >=", value, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andMediumStatusLessThan(Integer value) {
            addCriterion("medium_status <", value, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andMediumStatusLessThanOrEqualTo(Integer value) {
            addCriterion("medium_status <=", value, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andMediumStatusIn(List<Integer> values) {
            addCriterion("medium_status in", values, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andMediumStatusNotIn(List<Integer> values) {
            addCriterion("medium_status not in", values, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andMediumStatusBetween(Integer value1, Integer value2) {
            addCriterion("medium_status between", value1, value2, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andMediumStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("medium_status not between", value1, value2, "mediumStatus");
            return (Criteria) this;
        }

        public Criteria andShopReadmeIsNull() {
            addCriterion("shop_readme is null");
            return (Criteria) this;
        }

        public Criteria andShopReadmeIsNotNull() {
            addCriterion("shop_readme is not null");
            return (Criteria) this;
        }

        public Criteria andShopReadmeEqualTo(String value) {
            addCriterion("shop_readme =", value, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeNotEqualTo(String value) {
            addCriterion("shop_readme <>", value, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeGreaterThan(String value) {
            addCriterion("shop_readme >", value, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_readme >=", value, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeLessThan(String value) {
            addCriterion("shop_readme <", value, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeLessThanOrEqualTo(String value) {
            addCriterion("shop_readme <=", value, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeLike(String value) {
            addCriterion("shop_readme like", value, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeNotLike(String value) {
            addCriterion("shop_readme not like", value, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeIn(List<String> values) {
            addCriterion("shop_readme in", values, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeNotIn(List<String> values) {
            addCriterion("shop_readme not in", values, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeBetween(String value1, String value2) {
            addCriterion("shop_readme between", value1, value2, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andShopReadmeNotBetween(String value1, String value2) {
            addCriterion("shop_readme not between", value1, value2, "shopReadme");
            return (Criteria) this;
        }

        public Criteria andFloorNumberIsNull() {
            addCriterion("floor_number is null");
            return (Criteria) this;
        }

        public Criteria andFloorNumberIsNotNull() {
            addCriterion("floor_number is not null");
            return (Criteria) this;
        }

        public Criteria andFloorNumberEqualTo(Integer value) {
            addCriterion("floor_number =", value, "floorNumber");
            return (Criteria) this;
        }

        public Criteria andFloorNumberNotEqualTo(Integer value) {
            addCriterion("floor_number <>", value, "floorNumber");
            return (Criteria) this;
        }

        public Criteria andFloorNumberGreaterThan(Integer value) {
            addCriterion("floor_number >", value, "floorNumber");
            return (Criteria) this;
        }

        public Criteria andFloorNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("floor_number >=", value, "floorNumber");
            return (Criteria) this;
        }

        public Criteria andFloorNumberLessThan(Integer value) {
            addCriterion("floor_number <", value, "floorNumber");
            return (Criteria) this;
        }

        public Criteria andFloorNumberLessThanOrEqualTo(Integer value) {
            addCriterion("floor_number <=", value, "floorNumber");
            return (Criteria) this;
        }

        public Criteria andFloorNumberIn(List<Integer> values) {
            addCriterion("floor_number in", values, "floorNumber");
            return (Criteria) this;
        }

        public Criteria andFloorNumberNotIn(List<Integer> values) {
            addCriterion("floor_number not in", values, "floorNumber");
            return (Criteria) this;
        }

        public Criteria andFloorNumberBetween(Integer value1, Integer value2) {
            addCriterion("floor_number between", value1, value2, "floorNumber");
            return (Criteria) this;
        }

        public Criteria andFloorNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("floor_number not between", value1, value2, "floorNumber");
            return (Criteria) this;
        }



        public Criteria andOrientationIdEqualTo(Long value) {
            addCriterion(" orientation_id =", value, " orientationId");
            return (Criteria) this;
        }


        public Criteria andLoopLineIdIsNull() {
            addCriterion("loop_line_id is null");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdIsNotNull() {
            addCriterion("loop_line_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdEqualTo(Long value) {
            addCriterion("loop_line_id =", value, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdNotEqualTo(Long value) {
            addCriterion("loop_line_id <>", value, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdGreaterThan(Long value) {
            addCriterion("loop_line_id >", value, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdGreaterThanOrEqualTo(Long value) {
            addCriterion("loop_line_id >=", value, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdLessThan(Long value) {
            addCriterion("loop_line_id <", value, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdLessThanOrEqualTo(Long value) {
            addCriterion("loop_line_id <=", value, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdIn(List<Long> values) {
            addCriterion("loop_line_id in", values, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdNotIn(List<Long> values) {
            addCriterion("loop_line_id not in", values, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdBetween(Long value1, Long value2) {
            addCriterion("loop_line_id between", value1, value2, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andLoopLineIdNotBetween(Long value1, Long value2) {
            addCriterion("loop_line_id not between", value1, value2, "loopLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdIsNull() {
            addCriterion("subway_line_id is null");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdIsNotNull() {
            addCriterion("subway_line_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdEqualTo(Long value) {
            addCriterion("subway_line_id =", value, "subwayLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdNotEqualTo(Long value) {
            addCriterion("subway_line_id <>", value, "subwayLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdGreaterThan(Long value) {
            addCriterion("subway_line_id >", value, "subwayLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdGreaterThanOrEqualTo(Long value) {
            addCriterion("subway_line_id >=", value, "subwayLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdLessThan(Long value) {
            addCriterion("subway_line_id <", value, "subwayLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdLessThanOrEqualTo(Long value) {
            addCriterion("subway_line_id <=", value, "subwayLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdIn(List<Long> values) {
            addCriterion("subway_line_id in", values, "subwayLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdNotIn(List<Long> values) {
            addCriterion("subway_line_id not in", values, "subwayLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdBetween(Long value1, Long value2) {
            addCriterion("subway_line_id between", value1, value2, "subwayLineId");
            return (Criteria) this;
        }

        public Criteria andSubwayLineIdNotBetween(Long value1, Long value2) {
            addCriterion("subway_line_id not between", value1, value2, "subwayLineId");
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

        public Criteria andPublishedTimeIsNull() {
            addCriterion("published_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeIsNotNull() {
            addCriterion("published_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeEqualTo(Date value) {
            addCriterion("published_time =", value, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeNotEqualTo(Date value) {
            addCriterion("published_time <>", value, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeGreaterThan(Date value) {
            addCriterion("published_time >", value, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("published_time >=", value, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeLessThan(Date value) {
            addCriterion("published_time <", value, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeLessThanOrEqualTo(Date value) {
            addCriterion("published_time <=", value, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeIn(List<Date> values) {
            addCriterion("published_time in", values, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeNotIn(List<Date> values) {
            addCriterion("published_time not in", values, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeBetween(Date value1, Date value2) {
            addCriterion("published_time between", value1, value2, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andPublishedTimeNotBetween(Date value1, Date value2) {
            addCriterion("published_time not between", value1, value2, "publishedTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Date value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Date value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Date value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Date value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Date value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Date> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Date> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Date value1, Date value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Date value1, Date value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
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

        public Criteria andFreePeriodIsNull() {
            addCriterion("free_period is null");
            return (Criteria) this;
        }

        public Criteria andFreePeriodIsNotNull() {
            addCriterion("free_period is not null");
            return (Criteria) this;
        }

        public Criteria andFreePeriodEqualTo(Integer value) {
            addCriterion("free_period =", value, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andFreePeriodNotEqualTo(Integer value) {
            addCriterion("free_period <>", value, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andFreePeriodGreaterThan(Integer value) {
            addCriterion("free_period >", value, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andFreePeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("free_period >=", value, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andFreePeriodLessThan(Integer value) {
            addCriterion("free_period <", value, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andFreePeriodLessThanOrEqualTo(Integer value) {
            addCriterion("free_period <=", value, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andFreePeriodIn(List<Integer> values) {
            addCriterion("free_period in", values, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andFreePeriodNotIn(List<Integer> values) {
            addCriterion("free_period not in", values, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andFreePeriodBetween(Integer value1, Integer value2) {
            addCriterion("free_period between", value1, value2, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andFreePeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("free_period not between", value1, value2, "freePeriod");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdIsNull() {
            addCriterion("transfer_icon_id is null");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdIsNotNull() {
            addCriterion("transfer_icon_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdEqualTo(Long value) {
            addCriterion("transfer_icon_id =", value, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdNotEqualTo(Long value) {
            addCriterion("transfer_icon_id <>", value, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdGreaterThan(Long value) {
            addCriterion("transfer_icon_id >", value, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdGreaterThanOrEqualTo(Long value) {
            addCriterion("transfer_icon_id >=", value, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdLessThan(Long value) {
            addCriterion("transfer_icon_id <", value, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdLessThanOrEqualTo(Long value) {
            addCriterion("transfer_icon_id <=", value, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdIn(List<Long> values) {
            addCriterion("transfer_icon_id in", values, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdNotIn(List<Long> values) {
            addCriterion("transfer_icon_id not in", values, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdBetween(Long value1, Long value2) {
            addCriterion("transfer_icon_id between", value1, value2, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andTransferIconIdNotBetween(Long value1, Long value2) {
            addCriterion("transfer_icon_id not between", value1, value2, "transferIconId");
            return (Criteria) this;
        }

        public Criteria andFakeTelIsNull() {
            addCriterion("fake_tel is null");
            return (Criteria) this;
        }

        public Criteria andFakeTelIsNotNull() {
            addCriterion("fake_tel is not null");
            return (Criteria) this;
        }

        public Criteria andFakeTelEqualTo(String value) {
            addCriterion("fake_tel =", value, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelNotEqualTo(String value) {
            addCriterion("fake_tel <>", value, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelGreaterThan(String value) {
            addCriterion("fake_tel >", value, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelGreaterThanOrEqualTo(String value) {
            addCriterion("fake_tel >=", value, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelLessThan(String value) {
            addCriterion("fake_tel <", value, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelLessThanOrEqualTo(String value) {
            addCriterion("fake_tel <=", value, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelLike(String value) {
            addCriterion("fake_tel like", value, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelNotLike(String value) {
            addCriterion("fake_tel not like", value, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelIn(List<String> values) {
            addCriterion("fake_tel in", values, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelNotIn(List<String> values) {
            addCriterion("fake_tel not in", values, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelBetween(String value1, String value2) {
            addCriterion("fake_tel between", value1, value2, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andFakeTelNotBetween(String value1, String value2) {
            addCriterion("fake_tel not between", value1, value2, "fakeTel");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Integer value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Integer value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Integer value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Integer value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Integer> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Integer> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andStreetIdIsNull() {
            addCriterion("street_id is null");
            return (Criteria) this;
        }

        public Criteria andStreetIdIsNotNull() {
            addCriterion("street_id is not null");
            return (Criteria) this;
        }

        public Criteria andStreetIdEqualTo(Integer value) {
            addCriterion("street_id =", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotEqualTo(Integer value) {
            addCriterion("street_id <>", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdGreaterThan(Integer value) {
            addCriterion("street_id >", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("street_id >=", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdLessThan(Integer value) {
            addCriterion("street_id <", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdLessThanOrEqualTo(Integer value) {
            addCriterion("street_id <=", value, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdIn(List<Integer> values) {
            addCriterion("street_id in", values, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotIn(List<Integer> values) {
            addCriterion("street_id not in", values, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdBetween(Integer value1, Integer value2) {
            addCriterion("street_id between", value1, value2, "streetId");
            return (Criteria) this;
        }

        public Criteria andStreetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("street_id not between", value1, value2, "streetId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNull() {
            addCriterion("province_id is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIsNotNull() {
            addCriterion("province_id is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceIdEqualTo(Integer value) {
            addCriterion("province_id =", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotEqualTo(Integer value) {
            addCriterion("province_id <>", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThan(Integer value) {
            addCriterion("province_id >", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("province_id >=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThan(Integer value) {
            addCriterion("province_id <", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdLessThanOrEqualTo(Integer value) {
            addCriterion("province_id <=", value, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdIn(List<Integer> values) {
            addCriterion("province_id in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotIn(List<Integer> values) {
            addCriterion("province_id not in", values, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdBetween(Integer value1, Integer value2) {
            addCriterion("province_id between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andProvinceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("province_id not between", value1, value2, "provinceId");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeIsNull() {
            addCriterion("recommend_type is null");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeIsNotNull() {
            addCriterion("recommend_type is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeEqualTo(Integer value) {
            addCriterion("recommend_type =", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeNotEqualTo(Integer value) {
            addCriterion("recommend_type <>", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeGreaterThan(Integer value) {
            addCriterion("recommend_type >", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_type >=", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeLessThan(Integer value) {
            addCriterion("recommend_type <", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_type <=", value, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeIn(List<Integer> values) {
            addCriterion("recommend_type in", values, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeNotIn(List<Integer> values) {
            addCriterion("recommend_type not in", values, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeBetween(Integer value1, Integer value2) {
            addCriterion("recommend_type between", value1, value2, "recommendType");
            return (Criteria) this;
        }

        public Criteria andRecommendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_type not between", value1, value2, "recommendType");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Integer value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Integer value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Integer value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Integer value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Integer> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Integer> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
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