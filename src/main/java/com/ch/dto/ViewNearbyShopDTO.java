package com.ch.dto;

import lombok.Data;

@Data
public class ViewNearbyShopDTO {

    private Long id;

    private String title;

    private String image;

    private String address;

    private Integer area;

    private Long rent;

    private String lon;

    private String lat;

}
