package com.ch.entity;

import java.util.Date;

public class ClientCollectionRecord {
    private Long id;

    private Long transferShopId;

    private Long lookShopId;

    private Long clientId;

    private Date createDate;

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

    public Long getLookShopId() {
        return lookShopId;
    }

    public void setLookShopId(Long lookShopId) {
        this.lookShopId = lookShopId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}