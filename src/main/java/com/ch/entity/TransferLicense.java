package com.ch.entity;

public class TransferLicense {
    private Long id;

    private String businessLicense;

    private String hygienicLicense;

    private String environmentalAssessment;

    private String cateringPermit;

    private String foodProcessingPermit;

    private String foodCirculationPermit;

    private String foodPermit;

    private String cigaretteLicence;

    private String liquorLicense;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    public String getHygienicLicense() {
        return hygienicLicense;
    }

    public void setHygienicLicense(String hygienicLicense) {
        this.hygienicLicense = hygienicLicense == null ? null : hygienicLicense.trim();
    }

    public String getEnvironmentalAssessment() {
        return environmentalAssessment;
    }

    public void setEnvironmentalAssessment(String environmentalAssessment) {
        this.environmentalAssessment = environmentalAssessment == null ? null : environmentalAssessment.trim();
    }

    public String getCateringPermit() {
        return cateringPermit;
    }

    public void setCateringPermit(String cateringPermit) {
        this.cateringPermit = cateringPermit == null ? null : cateringPermit.trim();
    }

    public String getFoodProcessingPermit() {
        return foodProcessingPermit;
    }

    public void setFoodProcessingPermit(String foodProcessingPermit) {
        this.foodProcessingPermit = foodProcessingPermit == null ? null : foodProcessingPermit.trim();
    }

    public String getFoodCirculationPermit() {
        return foodCirculationPermit;
    }

    public void setFoodCirculationPermit(String foodCirculationPermit) {
        this.foodCirculationPermit = foodCirculationPermit == null ? null : foodCirculationPermit.trim();
    }

    public String getFoodPermit() {
        return foodPermit;
    }

    public void setFoodPermit(String foodPermit) {
        this.foodPermit = foodPermit == null ? null : foodPermit.trim();
    }

    public String getCigaretteLicence() {
        return cigaretteLicence;
    }

    public void setCigaretteLicence(String cigaretteLicence) {
        this.cigaretteLicence = cigaretteLicence == null ? null : cigaretteLicence.trim();
    }

    public String getLiquorLicense() {
        return liquorLicense;
    }

    public void setLiquorLicense(String liquorLicense) {
        this.liquorLicense = liquorLicense == null ? null : liquorLicense.trim();
    }
}