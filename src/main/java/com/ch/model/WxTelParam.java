package com.ch.model;

import lombok.Data;

@Data
public class WxTelParam {
    
    private String encryptedData;

    private String iv;
}
