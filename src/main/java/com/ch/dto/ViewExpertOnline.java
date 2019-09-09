package com.ch.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ViewExpertOnline<T> implements Serializable {

    private Integer total;

    private T data;
}
