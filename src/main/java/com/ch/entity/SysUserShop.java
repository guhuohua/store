package com.ch.entity;

public class SysUserShop {
    private Integer sysUserId;

    private String lookShopId;

    private String transferShopId;

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getLookShopId() {
        return lookShopId;
    }

    public void setLookShopId(String lookShopId) {
        this.lookShopId = lookShopId == null ? null : lookShopId.trim();
    }

    public String getTransferShopId() {
        return transferShopId;
    }

    public void setTransferShopId(String transferShopId) {
        this.transferShopId = transferShopId == null ? null : transferShopId.trim();
    }
}