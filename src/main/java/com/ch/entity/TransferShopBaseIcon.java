package com.ch.entity;

public class TransferShopBaseIcon {
    private Long id;

    private Long transferShopId;

    private Long baseIconId;

    private String url;

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

    public Long getBaseIconId() {
        return baseIconId;
    }

    public void setBaseIconId(Long baseIconId) {
        this.baseIconId = baseIconId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}