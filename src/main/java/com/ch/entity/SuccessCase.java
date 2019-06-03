package com.ch.entity;

import java.util.Date;

public class SuccessCase {
    private Long id;

    private String lookShopId;

    private String transferShopId;

    private Integer satisfactionDegree;

    private Date successTime;

    private String introduction;

    private Long browseNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getSatisfactionDegree() {
        return satisfactionDegree;
    }

    public void setSatisfactionDegree(Integer satisfactionDegree) {
        this.satisfactionDegree = satisfactionDegree;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Long getBrowseNumber() {
        return browseNumber;
    }

    public void setBrowseNumber(Long browseNumber) {
        this.browseNumber = browseNumber;
    }
}