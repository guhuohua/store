package com.ch.entity;

public class LookShopBaseIcon {
    private Long id;

    private Long lookShopId;

    private Long baseIconId;

    private String url;

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