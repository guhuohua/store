package com.ch.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ViewBrowseLookShopDTO {

    private String image;

    private String title;

    private String address;

    private Long topRent;

    private Long smallRent;

    private Long topArea;

    private Long smallArea;

    private Date createDate;

    private Long id;
}
