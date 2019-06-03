package com.ch.entity;

public class ShopRentType {
    private Long id;

    private String shopRentType;

    private String typeDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopRentType() {
        return shopRentType;
    }

    public void setShopRentType(String shopRentType) {
        this.shopRentType = shopRentType == null ? null : shopRentType.trim();
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc == null ? null : typeDesc.trim();
    }
}