package com.ch.model;

        import lombok.Data;

@Data
public class ViewWXLoginParam {

    private String header;

    private String nickName;

    private Integer gender;

    private String code;

    private String openId;

    private String sessionKey;

}
