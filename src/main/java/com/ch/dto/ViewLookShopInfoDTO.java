package com.ch.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ViewLookShopInfoDTO {
    private Long id;

    private String username;

    private String tel;

    private List<String> businessTypes;

    private String businessType;

    private String propertyType;

    private String shopType;

    private Long smallRent;

    private Long topRent;

    private Long smallArea;

    private Long topArea;

    private Integer transferStatus;

    private Integer status;

    private String title;

    private String city;

    private String area;

    private String decorateType;

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

    private String orientation;

    private String loopLine;

    private String subwayLine;

    private Long successFee;

    private Date updateTime;

    private Date publishedTime;

    private Date successTime;

    private Date checkTime;

    private Integer recommendType;

    private String street;

    private String province;

    private String address;

    private Integer doneStatus;

    private Integer checkStatus;

    private String shopRentType;

    private String headImg;

    private Integer collection;
}
