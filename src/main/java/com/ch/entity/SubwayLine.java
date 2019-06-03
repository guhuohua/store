package com.ch.entity;

public class SubwayLine {
    private Long id;

    private String subwayLineDesc;

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