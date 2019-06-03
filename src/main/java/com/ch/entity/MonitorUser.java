package com.ch.entity;

import java.util.Date;

public class MonitorUser {
    private Long id;

    private Long clientId;

    private Date startTime;

    private String browseLookId;

    private Date quitTime;

    private Long shopTypeId;

    private Long browseTransferId;

    private Long sysUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getBrowseLookId() {
        return browseLookId;
    }

    public void setBrowseLookId(String browseLookId) {
        this.browseLookId = browseLookId == null ? null : browseLookId.trim();
    }

    public Date getQuitTime() {
        return quitTime;
    }

    public void setQuitTime(Date quitTime) {
        this.quitTime = quitTime;
    }

    public Long getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(Long shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public Long getBrowseTransferId() {
        return browseTransferId;
    }

    public void setBrowseTransferId(Long browseTransferId) {
        this.browseTransferId = browseTransferId;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }
}