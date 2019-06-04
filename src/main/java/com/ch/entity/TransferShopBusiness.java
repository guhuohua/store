package com.ch.entity;

public class TransferShopBusiness {
    private Long id;

    private Long transferShopId;

    private Long businessTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransferShopId() {
        return transferShopId;
    }

    public void setTransferShopId(Long transferShopId) {
        this.transferShopId = transferShopId;
    }

    public Long getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(Long businessTypeId) {
        this.businessTypeId = businessTypeId;
    }
}