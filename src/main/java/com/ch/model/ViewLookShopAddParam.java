package com.ch.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ViewLookShopAddParam {

    private Long id;

    private Long clientId;

    private Long shopRentTypeId;

    private String tel;

    private List<Long> businessTypeIds;

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

    private Integer cityId;

    private Integer areaId;

    private Long decorateTypeId;

    private String requirementDetails;

    private String accessoryRequirements;

    private Long gateWidth;

    private Long serviceType;

    private String lon;

    private String lat;

    private Integer mediumStatus;

    private Integer sort;

    private Date craeateTime;

    private String otherTel;

    private String shopReadme;

    private String floor;

    private Long orientationId;

    private Long loopLineId;

    private Long subwayLineId;

    private Long successFee;

    private Date updateTime;

    private Date publishedTime;

    private Date successTime;

    private Date checkTime;

    private Integer recommendType;

    private Integer streetId;

    private Integer provinceId;

    private String address;

    private String contacts;

    private String areaName;

    private Integer startFloor;

    private Integer endFloor;

}
