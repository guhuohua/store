package com.ch.entity;

import java.util.Date;

public class TransferShop {
    private Long id;

    private Long clientId;

    private String tel;

    private Long businessTypeId;

    private Long propertyTypeId;

    private Long shopTypeId;

    private Long rent;

    private Integer area;

    private Integer transferStatus;

    private Integer status;

    private String title;

    private Integer cityId;

    private Long decorateTypeId;

    private String requirementDetails;

    private String accessoryRequirements;

    private Long gateWidth;

    private Long transferFee;

    private String shopSn;

    private Long serviceType;

    private String longitude;

    private String latitude;

    private Integer mediumStatus;

    private String shopReadme;

    private Integer floorNumber;

    private Long orientationId;

    private Long loopLineId;

    private Long subwayLineId;

    private Date updateTime;

    private Date publishedTime;

    private Date checkTime;

    private Date successTime;

    private Integer freePeriod;

    private Long transferIconId;

    private String fakeTel;

    private String image;

    private Integer sort;

    private Integer areaId;

    private Integer streetId;

    private Integer provinceId;

    private Integer recommendType;

    private Integer checkStatus;

    private String address;

    private String contacts;

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

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

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
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

    public Long getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(Long transferFee) {
        this.transferFee = transferFee;
    }

    public String getShopSn() {
        return shopSn;
    }

    public void setShopSn(String shopSn) {
        this.shopSn = shopSn == null ? null : shopSn.trim();
    }

    public Long getServiceType() {
        return serviceType;
    }

    public void setServiceType(Long serviceType) {
        this.serviceType = serviceType;
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

    public String getShopReadme() {
        return shopReadme;
    }

    public void setShopReadme(String shopReadme) {
        this.shopReadme = shopReadme == null ? null : shopReadme.trim();
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }



    public Long getLoopLineId() {
        return loopLineId;
    }

    public void setLoopLineId(Long loopLineId) {
        this.loopLineId = loopLineId;
    }

    public Long getSubwayLineId() {
        return subwayLineId;
    }

    public void setSubwayLineId(Long subwayLineId) {
        this.subwayLineId = subwayLineId;
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

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Date getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Date successTime) {
        this.successTime = successTime;
    }

    public Integer getFreePeriod() {
        return freePeriod;
    }

    public void setFreePeriod(Integer freePeriod) {
        this.freePeriod = freePeriod;
    }

    public Long getTransferIconId() {
        return transferIconId;
    }

    public void setTransferIconId(Long transferIconId) {
        this.transferIconId = transferIconId;
    }

    public String getFakeTel() {
        return fakeTel;
    }

    public void setFakeTel(String fakeTel) {
        this.fakeTel = fakeTel == null ? null : fakeTel.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Integer getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(Integer recommendType) {
        this.recommendType = recommendType;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Long getOrientationId() {
        return orientationId;
    }

    public void setOrientationId(Long orientationId) {
        this.orientationId = orientationId;
    }
}