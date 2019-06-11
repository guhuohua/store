package com.ch.entity;

import org.springframework.data.redis.core.index.PathBasedRedisIndexDefinition;

public class SubwayLine {
    private Long id;

    private String subwayLineDesc;

    private Integer cityId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubwayLineDesc() {
        return subwayLineDesc;
    }

    public void setSubwayLineDesc(String subwayLineDesc) {
        this.subwayLineDesc = subwayLineDesc == null ? null : subwayLineDesc.trim();
    }
}