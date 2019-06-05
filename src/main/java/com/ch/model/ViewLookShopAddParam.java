package com.ch.model;

import lombok.Data;

import java.util.List;

@Data
public class ViewLookShopAddParam {

    private Long id;

    private Integer clientId;

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

    private String title;

    private String city;

    private String expectArea;

    private Long decorateTypeId;

    private String requirementDetails;

    private String accessoryRequirements;

    private Long gateWidth;

    private Long serviceType;

    private String longitude;

    private String latitude;

    private Integer mediumStatus;

    private Integer sort;

    private String otherTel;

    private String shopReadme;

    private String floor;

    private Long orienId;

    private Long loopLineId;

    private Long subwayLineId;

    private String successFee;

    private Integer recommendType;

    private String address;

}
