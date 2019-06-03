package com.ch.entity;

public class Orientation {
    private Long id;

    private String orientationDesc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrientationDesc() {
        return orientationDesc;
    }

    public void setOrientationDesc(String orientationDesc) {
        this.orientationDesc = orientationDesc == null ? null : orientationDesc.trim();
    }
}