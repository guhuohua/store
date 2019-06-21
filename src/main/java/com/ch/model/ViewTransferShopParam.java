package com.ch.model;

import com.ch.entity.TransferImage;
import lombok.Data;

import javax.validation.constraints.Size;
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

    @Size(max=999999999, min=1, message = "请输入正确的租金")
    private Long rent;


    @Size(max=99999, min=1, message = "请输入正确的面积")
    private Integer area;

    private Integer transferStatus;

    private String title;

    private Integer cityId;

    private Long decorateTypeId;

    private String requirementDetails;

    private String accessoryRequirements;

    @Size(max=100, min=1, message = "请输入正确的门宽")
    private Long gateWidth;

    private Long transferFee;

    private String shopSn;

    private Long serviceType;

    private String lon;

    private String lat;

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

    private String contacts;

    private List<TransferImage> transferImages;

    private Long shopRentTypeId;

    private String address;

    private String areaName;
}
