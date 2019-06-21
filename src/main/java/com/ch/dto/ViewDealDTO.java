package com.ch.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ViewDealDTO {

    private Long id;

    private String title;

    private String address;

    private Integer area;

    private Long rent;

    private Date successTime;
}
