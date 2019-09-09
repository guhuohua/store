/**
 * Author: 常富文
 * Date:   2019/6/5 17:21
 * Description:
 */

package com.ch.dto;

public class ShowShopDto {


    private Integer pageNum;

    private Integer pageSize;

    private String username;

    private String tel;

    private Integer doneStatus;

    private Integer checkStatus;

    private Integer recommendType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getDoneStatus() {
        return doneStatus;
    }

    public void setDoneStatus(Integer doneStatus) {
        this.doneStatus = doneStatus;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(Integer recommendType) {
        this.recommendType = recommendType;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
