package com.ch.model;

import lombok.Data;

@Data
public class ViewTransferShopListParam {

    private Long storeId;

    private String storeName;

    private Integer storeCategory;

    private Integer start;

    private Integer rows;

    private Integer provinceId;

    private Integer areaId;

    private Integer cityId;

    private Long maxArea;

    private Long minArea;

    private Long maxRent;

    private Long minRent;

    private String sort;

    private Integer storeType;

    private Integer storeStatus;

    private Long clientId;

    private Integer streetId;
}
