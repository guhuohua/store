package com.ch.model;

public class SysSuccessCaseParm {
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


    private Integer pageSize;

    private Integer pageNum;


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
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
}
