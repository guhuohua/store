package com.ch.entity;

public class BrowsingHistory {
    private Long id;

    private Long lookShopId;

    private Long transferShopId;

    private Long sysUserId;

    private Long successCaseId;

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

    public Long getTransferShopId() {
        return transferShopId;
    }

    public void setTransferShopId(Long transferShopId) {
        this.transferShopId = transferShopId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public Long getSuccessCaseId() {
        return successCaseId;
    }

    public void setSuccessCaseId(Long successCaseId) {
        this.successCaseId = successCaseId;
    }
}