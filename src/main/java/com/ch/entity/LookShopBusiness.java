package com.ch.entity;

public class LookShopBusiness {
    private Long id;

    private Long lookShopId;

    private Long businessTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLookShopId() {
        return lookShopId;
    }

    public void setLookShopId(Long lookShopId) {
        this.lookShopId = lookShopId;
    }

    public Long getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(Long businessTypeId) {
        this.businessTypeId = businessTypeId;
    }
}