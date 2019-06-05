package com.ch.model;

import com.ch.entity.TransferImage;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ViewTransferShopParam {

    private Long id;

    private Long clientId;

    private String tel;

    private List<Long> businessTypeIds;

    private Long propertyTypeId;

    private Long shopTypeId;

    private Long rent;

    private Integer area;

    private Integer transferStatus;

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

    private String floorNumber;

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

    private String contacts;

    private List<TransferImage> transferImages;
}
