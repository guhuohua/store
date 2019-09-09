package com.ch.dto;

import com.ch.entity.TransferImage;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ViewTransferShopInfoDTO {

    private Long id;

    private String username;

    private String tel;

    private List<String> businessTypes;

    private Long propertyType;

    private Long shopType;

    private Long rent;

    private Integer area;

    private Integer transferStatus;

    private String title;

    private String city;

    private Long decorateType;

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

    private Long orientation;

    private Long loopLine;

    private Long subwayLine;

    private Date updateTime;

    private Date publishedTime;

    private Integer freePeriod;

    private String fakeTel;

    private String image;

    private Integer sort;

    private String areaName;

    private String street;

    private String province;

    private Integer recommendType;

    private Date createTime;

    private List<TransferImage> transferImageList;

    private Integer doneStatus;

    private Integer checkStatus;

    private String address;

    private String reasons;

    private String openId;

    private Long shopRentType;

    private String headImg;

    private Integer collection;

    private List<ViewBaseIcon> viewBaseIcons;

    private Integer depth;

    private Integer high;

    private List<Integer> addressIndex;

    private Integer startFloor;

    private Integer endFloor;

    private Integer deposit;

    private Integer payMonth;

    private String businessStatus;

    private Integer leaseTerm;
}
