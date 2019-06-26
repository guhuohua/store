package com.ch.dto;

import lombok.Data;

@Data
public class ViewBrowseLookShopDTO {

    private String image;

    private String title;

    private String address;

    private Long topRent;

    private Long smallRent;

    private Long topArea;

    private Long smallArea;

    private Long createDate;

    private Long id;
}
