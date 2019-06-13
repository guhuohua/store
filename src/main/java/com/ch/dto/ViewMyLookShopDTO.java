package com.ch.dto;

import lombok.Data;

@Data
public class ViewMyLookShopDTO {

    private Long id;

    private String name;

    private Long maxPrice;

    private Long minPrice;

    private Long maxArea;

    private Long minArea;

    private String title;

    private String address;

    private String headImg;
}
