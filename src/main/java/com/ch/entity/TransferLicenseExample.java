package com.ch.entity;

import java.util.ArrayList;
import java.util.List;

public class TransferLicenseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransferLicenseExample() {
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

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseIsNull() {
            addCriterion("hygienic_license is null");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseIsNotNull() {
            addCriterion("hygienic_license is not null");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseEqualTo(String value) {
            addCriterion("hygienic_license =", value, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseNotEqualTo(String value) {
            addCriterion("hygienic_license <>", value, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseGreaterThan(String value) {
            addCriterion("hygienic_license >", value, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("hygienic_license >=", value, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseLessThan(String value) {
            addCriterion("hygienic_license <", value, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseLessThanOrEqualTo(String value) {
            addCriterion("hygienic_license <=", value, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseLike(String value) {
            addCriterion("hygienic_license like", value, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseNotLike(String value) {
            addCriterion("hygienic_license not like", value, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseIn(List<String> values) {
            addCriterion("hygienic_license in", values, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseNotIn(List<String> values) {
            addCriterion("hygienic_license not in", values, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseBetween(String value1, String value2) {
            addCriterion("hygienic_license between", value1, value2, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andHygienicLicenseNotBetween(String value1, String value2) {
            addCriterion("hygienic_license not between", value1, value2, "hygienicLicense");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentIsNull() {
            addCriterion("environmental_assessment is null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentIsNotNull() {
            addCriterion("environmental_assessment is not null");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentEqualTo(String value) {
            addCriterion("environmental_assessment =", value, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentNotEqualTo(String value) {
            addCriterion("environmental_assessment <>", value, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentGreaterThan(String value) {
            addCriterion("environmental_assessment >", value, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentGreaterThanOrEqualTo(String value) {
            addCriterion("environmental_assessment >=", value, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentLessThan(String value) {
            addCriterion("environmental_assessment <", value, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentLessThanOrEqualTo(String value) {
            addCriterion("environmental_assessment <=", value, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentLike(String value) {
            addCriterion("environmental_assessment like", value, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentNotLike(String value) {
            addCriterion("environmental_assessment not like", value, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentIn(List<String> values) {
            addCriterion("environmental_assessment in", values, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentNotIn(List<String> values) {
            addCriterion("environmental_assessment not in", values, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentBetween(String value1, String value2) {
            addCriterion("environmental_assessment between", value1, value2, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andEnvironmentalAssessmentNotBetween(String value1, String value2) {
            addCriterion("environmental_assessment not between", value1, value2, "environmentalAssessment");
            return (Criteria) this;
        }

        public Criteria andCateringPermitIsNull() {
            addCriterion("catering_permit is null");
            return (Criteria) this;
        }

        public Criteria andCateringPermitIsNotNull() {
            addCriterion("catering_permit is not null");
            return (Criteria) this;
        }

        public Criteria andCateringPermitEqualTo(String value) {
            addCriterion("catering_permit =", value, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitNotEqualTo(String value) {
            addCriterion("catering_permit <>", value, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitGreaterThan(String value) {
            addCriterion("catering_permit >", value, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitGreaterThanOrEqualTo(String value) {
            addCriterion("catering_permit >=", value, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitLessThan(String value) {
            addCriterion("catering_permit <", value, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitLessThanOrEqualTo(String value) {
            addCriterion("catering_permit <=", value, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitLike(String value) {
            addCriterion("catering_permit like", value, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitNotLike(String value) {
            addCriterion("catering_permit not like", value, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitIn(List<String> values) {
            addCriterion("catering_permit in", values, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitNotIn(List<String> values) {
            addCriterion("catering_permit not in", values, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitBetween(String value1, String value2) {
            addCriterion("catering_permit between", value1, value2, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andCateringPermitNotBetween(String value1, String value2) {
            addCriterion("catering_permit not between", value1, value2, "cateringPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitIsNull() {
            addCriterion("food_processing_permit is null");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitIsNotNull() {
            addCriterion("food_processing_permit is not null");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitEqualTo(String value) {
            addCriterion("food_processing_permit =", value, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitNotEqualTo(String value) {
            addCriterion("food_processing_permit <>", value, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitGreaterThan(String value) {
            addCriterion("food_processing_permit >", value, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitGreaterThanOrEqualTo(String value) {
            addCriterion("food_processing_permit >=", value, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitLessThan(String value) {
            addCriterion("food_processing_permit <", value, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitLessThanOrEqualTo(String value) {
            addCriterion("food_processing_permit <=", value, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitLike(String value) {
            addCriterion("food_processing_permit like", value, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitNotLike(String value) {
            addCriterion("food_processing_permit not like", value, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitIn(List<String> values) {
            addCriterion("food_processing_permit in", values, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitNotIn(List<String> values) {
            addCriterion("food_processing_permit not in", values, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitBetween(String value1, String value2) {
            addCriterion("food_processing_permit between", value1, value2, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodProcessingPermitNotBetween(String value1, String value2) {
            addCriterion("food_processing_permit not between", value1, value2, "foodProcessingPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitIsNull() {
            addCriterion("food_circulation_permit is null");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitIsNotNull() {
            addCriterion("food_circulation_permit is not null");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitEqualTo(String value) {
            addCriterion("food_circulation_permit =", value, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitNotEqualTo(String value) {
            addCriterion("food_circulation_permit <>", value, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitGreaterThan(String value) {
            addCriterion("food_circulation_permit >", value, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitGreaterThanOrEqualTo(String value) {
            addCriterion("food_circulation_permit >=", value, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitLessThan(String value) {
            addCriterion("food_circulation_permit <", value, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitLessThanOrEqualTo(String value) {
            addCriterion("food_circulation_permit <=", value, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitLike(String value) {
            addCriterion("food_circulation_permit like", value, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitNotLike(String value) {
            addCriterion("food_circulation_permit not like", value, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitIn(List<String> values) {
            addCriterion("food_circulation_permit in", values, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitNotIn(List<String> values) {
            addCriterion("food_circulation_permit not in", values, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitBetween(String value1, String value2) {
            addCriterion("food_circulation_permit between", value1, value2, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodCirculationPermitNotBetween(String value1, String value2) {
            addCriterion("food_circulation_permit not between", value1, value2, "foodCirculationPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitIsNull() {
            addCriterion("food_permit is null");
            return (Criteria) this;
        }

        public Criteria andFoodPermitIsNotNull() {
            addCriterion("food_permit is not null");
            return (Criteria) this;
        }

        public Criteria andFoodPermitEqualTo(String value) {
            addCriterion("food_permit =", value, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitNotEqualTo(String value) {
            addCriterion("food_permit <>", value, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitGreaterThan(String value) {
            addCriterion("food_permit >", value, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitGreaterThanOrEqualTo(String value) {
            addCriterion("food_permit >=", value, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitLessThan(String value) {
            addCriterion("food_permit <", value, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitLessThanOrEqualTo(String value) {
            addCriterion("food_permit <=", value, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitLike(String value) {
            addCriterion("food_permit like", value, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitNotLike(String value) {
            addCriterion("food_permit not like", value, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitIn(List<String> values) {
            addCriterion("food_permit in", values, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitNotIn(List<String> values) {
            addCriterion("food_permit not in", values, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitBetween(String value1, String value2) {
            addCriterion("food_permit between", value1, value2, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andFoodPermitNotBetween(String value1, String value2) {
            addCriterion("food_permit not between", value1, value2, "foodPermit");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceIsNull() {
            addCriterion("cigarette_licence is null");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceIsNotNull() {
            addCriterion("cigarette_licence is not null");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceEqualTo(String value) {
            addCriterion("cigarette_licence =", value, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceNotEqualTo(String value) {
            addCriterion("cigarette_licence <>", value, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceGreaterThan(String value) {
            addCriterion("cigarette_licence >", value, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceGreaterThanOrEqualTo(String value) {
            addCriterion("cigarette_licence >=", value, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceLessThan(String value) {
            addCriterion("cigarette_licence <", value, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceLessThanOrEqualTo(String value) {
            addCriterion("cigarette_licence <=", value, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceLike(String value) {
            addCriterion("cigarette_licence like", value, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceNotLike(String value) {
            addCriterion("cigarette_licence not like", value, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceIn(List<String> values) {
            addCriterion("cigarette_licence in", values, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceNotIn(List<String> values) {
            addCriterion("cigarette_licence not in", values, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceBetween(String value1, String value2) {
            addCriterion("cigarette_licence between", value1, value2, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andCigaretteLicenceNotBetween(String value1, String value2) {
            addCriterion("cigarette_licence not between", value1, value2, "cigaretteLicence");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseIsNull() {
            addCriterion("liquor_license is null");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseIsNotNull() {
            addCriterion("liquor_license is not null");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseEqualTo(String value) {
            addCriterion("liquor_license =", value, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseNotEqualTo(String value) {
            addCriterion("liquor_license <>", value, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseGreaterThan(String value) {
            addCriterion("liquor_license >", value, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("liquor_license >=", value, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseLessThan(String value) {
            addCriterion("liquor_license <", value, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseLessThanOrEqualTo(String value) {
            addCriterion("liquor_license <=", value, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseLike(String value) {
            addCriterion("liquor_license like", value, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseNotLike(String value) {
            addCriterion("liquor_license not like", value, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseIn(List<String> values) {
            addCriterion("liquor_license in", values, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseNotIn(List<String> values) {
            addCriterion("liquor_license not in", values, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseBetween(String value1, String value2) {
            addCriterion("liquor_license between", value1, value2, "liquorLicense");
            return (Criteria) this;
        }

        public Criteria andLiquorLicenseNotBetween(String value1, String value2) {
            addCriterion("liquor_license not between", value1, value2, "liquorLicense");
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