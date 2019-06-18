package com.ch.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ViewBrowseTransferShopDTO {

    private String image;

    private String title;

    private String address;

    private Integer rent;

    private Long area;

    private Date createDate;

    private Long id;

}
