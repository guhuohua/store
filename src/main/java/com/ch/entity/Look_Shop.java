package com.ch.entity;

import java.util.Date;

public class Look_Shop {
    private Long id;

    private Integer clientId;

    private String tel;

    private Long businessTypeId;

    private Long propertyTypeId;

    private Long shopTypeId;

    private Long rentRangeId;

    private Long smallRent;

    private Long topRent;

    private Long smallArea;

    private Long topArea;

    private Integer transferStatus;

    private Integer status;

    private String title;

    private String cityId;

    private String areaId;

    private Long decorateTypeId;

    private String requirementDetails;

    private String accessoryRequirements;

    private Long gateWidth;

    private Long serviceType;

    private String longitude;

    private String latitude;

    private Integer mediumStatus;

    private Integer sort;

    private Date craeateTime;

    private String otherTel;

    private String shopReadme;

    private Integer floor;

    private String orientationId;

    private String loopLineId;

    private String subwayLineId;

    private String successFee;

    private Date updateTime;

    private Date publishedTime;

    private Date successTime;

    private Date checkTime;

    private Integer recommendType;

    private Integer streetId;

    private Integer provinceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Long getBusinessTypeId() {
        return businessTypeId;
    }

    public void setBusinessTypeId(Long businessTypeId) {
        this.businessTypeId = businessTypeId;
    }

    public Long getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(Long propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    public Long getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(Long shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public Long getRentRangeId() {
        return rentRangeId;
    }

    public void setRentRangeId(Long rentRangeId) {
        this.rentRangeId = rentRangeId;
    }

    public Long getSmallRent() {
        return smallRent;
    }

    public void setSmallRent(Long smallRent) {
        this.smallRent = smallRent;
    }

    public Long getTopRent() {
        return topRent;
    }

    public void setTopRent(Long topRent) {
        this.topRent = topRent;
    }

    public Long getSmallArea() {
        return smallArea;
    }

    public void setSmallArea(Long smallArea) {
        this.smallArea = smallArea;
    }

    public Long getTopArea() {
        return topArea;
    }

    public void setTopArea(Long topArea) {
        this.topArea = topArea;
    }

    public Integer getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(Integer transferStatus) {
        this.transferStatus = transferStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public Long getDecorateTypeId() {
        return decorateTypeId;
    }

    public void setDecorateTypeId(Long decorateTypeId) {
        this.decorateTypeId = decorateTypeId;
    }

    public String getRequirementDetails() {
        return requirementDetails;
    }

    public void setRequirementDetails(String requirementDetails) {
        this.requirementDetails = requirementDetails == null ? null : requirementDetails.trim();
    }

    public String getAccessoryRequirements() {
        return accessoryRequirements;
    }

    public void setAccessoryRequirements(String accessoryRequirements) {
        this.accessoryRequirements = accessoryRequirements == null ? null : accessoryRequirements.trim();
    }

    public Long getGateWidth() {
        return gateWidth;
    }

    public void setGateWidth(Long gateWidth) {
        this.gateWidth = gateWidth;
    }

    public Long getServiceType() {
        return serviceType;
    }

    public void setServiceType(Long serviceType) {
        this.serviceType = serviceType;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public Integer getMediumStatus() {
        return mediumStatus;
    }

    public void setMediumStatus(Integer mediumStatus) {
        this.mediumStatus = mediumStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCraeateTime() {
        return craeateTime;
    }

    public void setCraeateTime(Date craeateTime) {
        this.craeateTime = craeateTime;
    }

    public String getOtherTel() {
        return otherTel;
    }

    public void setOtherTel(String otherTel) {
        this.otherTel = otherTel == null ? null : otherTel.trim();
    }

    public String getShopReadme() {
        return shopReadme;
    }

    public void setShopReadme(String shopReadme) {
        this.shopReadme = shopReadme == null ? null : shopReadme.trim();
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getOrientationId() {
        return orientationId;
    }

    public void setOrientationId(String orientationId) {
        this.orientationId = orientationId == null ? null : orientationId.trim();
    }

    public String getLoopLineId() {
        return loopLineId;
    }

    public void setLoopLineId(String loopLineId) {
        this.loopLineId = loopLineId == null ? null : loopLineId.trim();
    }

    public String getSubwayLineId() {
        return subwayLineId;
    }

    public void setSubwayLineId(String subwayLineId) {
        this.subwayLineId = subwayLineId == null ? null : subwayLineId.trim();
    }

    public String getSuccessFee() {
        return successFee;
    }

    public void setSuccessFee(String successFee) {
        this.successFee = successFee == null ? null : successFee.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Integer getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(Integer recommendType) {
        this.recommendType = recommendType;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }
}