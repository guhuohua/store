package com.ch.enums;

public enum OderStatusEnum {

    UNPAID("0", "普通"),
    PAID("1", "精品");

    public final String code;

    public final String message;

    OderStatusEnum(String code, String message ) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }
    public String getMessage() {
        return this.message;
    }

    public String getExceptionMessage() {
        return this.code +"-"+this.message;
    }
}
