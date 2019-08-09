package com.ch.dto;

import lombok.Data;

@Data
public class WxTel {
    private String phoneNumber;
    private String purePhoneNumber;
    private String countryCode;
    private Watermark watermark;
}
