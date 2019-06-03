package com.ch.entity;

import java.util.Date;

public class TransferImage {
    private Long id;

    private Date createTime;

    private String imageUrl;

    private String transferShopId;

    private String status;

    private String successImageUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getTransferShopId() {
        return transferShopId;
    }

    public void setTransferShopId(String transferShopId) {
        this.transferShopId = transferShopId == null ? null : transferShopId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSuccessImageUrl() {
        return successImageUrl;
    }

    public void setSuccessImageUrl(String successImageUrl) {
        this.successImageUrl = successImageUrl == null ? null : successImageUrl.trim();
    }
}