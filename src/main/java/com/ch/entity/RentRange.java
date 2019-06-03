package com.ch.entity;

public class RentRange {
    private Long id;

    private Long smallRent;

    private Long topRent;

    private String rentDesc;

    private Integer label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSmallRent() {
        return smallRent;
    }

    public void setSmallRent(Long smallRent) {
        this.smallRent = smallRent;
    }

    public Long getTopRent() {
        return topRent;
    }

    public void setTopRent(Long topRent) {
        this.topRent = topRent;
    }

    public String getRentDesc() {
        return rentDesc;
    }

    public void setRentDesc(String rentDesc) {
        this.rentDesc = rentDesc == null ? null : rentDesc.trim();
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }
}