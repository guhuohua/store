/**
 * Author: 常富文
 * Date:   2019/6/11 17:43
 * Description:
 */

package com.ch.dto;

public class SysBaseDTO {
    private Integer pageNum;
    private Integer pageSize;
    private Integer cityId;

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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
