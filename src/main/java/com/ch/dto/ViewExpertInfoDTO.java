package com.ch.dto;

import lombok.Data;

@Data
public class ViewExpertInfoDTO {

    private Long id;

    private String headImage;

    private String name;

    private String business;

    private String phone;

    private String area;

    private Integer star;

    private Integer count;
}
