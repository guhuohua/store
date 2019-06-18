package com.ch.dto;

import java.util.Date;

public class SuccessCaseDTO {

    /**
     * 找铺人
     */
    private String looker;

    /**
     * 找铺电话
     */
    private String lookTel;
    /**
     * 转铺人
     */

    private String transfer;

    /**
     * 转铺电话
     */
    private String transferTel;
    /**
     * 中介
     */

    private String sysUser;
    /**
     * 城市
     */

    private String city;

    /**
     * 成交时间
     */
    private Date successTime;

    /**
     * 转铺id
     */

    private Long storeId;

    private String formartTime;

    public String getFormartTime() {
        return formartTime;
    }

    public void setFormartTime(String formartTime) {
        this.formartTime = formartTime;
    }

    public String getLooker() {
        return looker;
    }

    public void setLooker(String looker) {
        this.looker = looker;
    }

    public String getLookTel() {
        return lookTel;
    }

    public void setLookTel(String lookTel) {
        this.lookTel = lookTel;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getTransferTel() {
        return transferTel;
    }

    public void setTransferTel(String transferTel) {
        this.transferTel = transferTel;
    }

    public String getSysUser() {
        return sysUser;
    }

    public void setSysUser(String sysUser) {
        this.sysUser = sysUser;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
