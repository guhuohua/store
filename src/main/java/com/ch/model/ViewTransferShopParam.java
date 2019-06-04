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

    private Date createTime;

    private List<TransferImage> transferImages;
}
