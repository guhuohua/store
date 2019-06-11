package com.ch.entity;

public class LoopLine {
    private Long id;

    private String loopLineDesc;

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

    public String getLoopLineDesc() {
        return loopLineDesc;
    }

    public void setLoopLineDesc(String loopLineDesc) {
        this.loopLineDesc = loopLineDesc == null ? null : loopLineDesc.trim();
    }
}